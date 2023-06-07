package ru.dentistry.dentistryrest.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.dentistry.dentistryrest.repos.FARepository;
import ru.dentistry.dentistryrest.service.FAService;
import ru.dentistry.dentistryrest.service.dto.DentistryDTO;
import ru.dentistry.dentistryrest.service.dto.FADTO;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/forthcoming-appointments")
public class FAResource {
    private final FAService faService;
    private final FARepository faRepository;

    public FAResource(FAService faService, FARepository faRepository) {
        this.faService = faService;
        this.faRepository = faRepository;
    }
    @GetMapping("")
    //@JsonView(Views.DentistPreview.class)
    public ResponseEntity<List<FADTO>> getAllAppointments(Pageable pageable) {
        Page<FADTO> page = faService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());

    }
    @GetMapping("/{id}")
    public ResponseEntity<FADTO> getOneAppointment(@PathVariable Long id) {
        Optional<FADTO> dentistryDTO = faService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dentistryDTO);
    }
    @GetMapping("/{id}/unfilled")
    public ResponseEntity<List<FADTO>> getDoctorsUnfilledAppointments(@PathVariable Long id) {
        Date date = Date.valueOf(LocalDate.now());
        Page<FADTO> page = faService.findAllUnfilledToOneDoc(id.intValue(), date);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    @PostMapping("")
    public ResponseEntity<FADTO> newAppointment(@RequestBody FADTO faDTO) throws URISyntaxException {
        if (faRepository.findByDentistAndDay(faDTO.getDentist().getDentist_name(), faDTO.getAppointment_day()).size() ==0){
            FADTO result = faService.save(faDTO);
            return ResponseEntity
                    .created(new URI("/api/forthcoming-appointments"))
                    .body(result);
        }
        throw new RuntimeException("already exists");
    }
    @PutMapping("/{id}")
    public ResponseEntity<FADTO> updateAppointment(
            @PathVariable(value = "id", required = true) final Long id,
            @RequestBody FADTO dentistryDTO
    ) throws URISyntaxException {
        if (Objects.equals(id.intValue(), dentistryDTO.getAppointment_id()) || faRepository.existsById(id.intValue())){
            FADTO result = faService.save(dentistryDTO);
            return ResponseEntity.ok().body(result);
        }
        throw new RuntimeException("update exception");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        faService.delete(id.intValue());
        return ResponseEntity
                .noContent()
                .build();
    }

}
