package ru.dentistry.dentistryrest.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.dentistry.dentistryrest.repos.PARepository;
import ru.dentistry.dentistryrest.service.PAService;
import ru.dentistry.dentistryrest.service.dto.FADTO;
import ru.dentistry.dentistryrest.service.dto.PADTO;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/previous-appointments")
public class PAResource {
    private final PAService paService;
    private final PARepository paRepository;

    public PAResource(PAService faService, PARepository faRepository) {
        this.paService = faService;
        this.paRepository = faRepository;
    }
    @GetMapping("")
    public ResponseEntity<List<PADTO>> getAllAppointments(Pageable pageable) {
        Page<PADTO> page = paService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());

    }
    @GetMapping("/unfilled")
    public ResponseEntity<List<PADTO>> getUnfilledAppointments() {
        Page<PADTO> page = paService.findAllUnfilled();
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());

    }
    @GetMapping("/filled")
    public ResponseEntity<List<PADTO>> getFilledAppointments() {
        Page<PADTO> page = paService.findAllFilled();
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());

    }
    @GetMapping("/{id}")
    public ResponseEntity<PADTO> getOneAppointment(@PathVariable Long id) {
        Optional<PADTO> paDTO = paService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paDTO);
    }
    @PostMapping("")
    public ResponseEntity<PADTO> newAppointment(@RequestBody PADTO paDTO) throws URISyntaxException {
        PADTO result = paService.save(paDTO);
        return ResponseEntity
                .created(new URI("/api/forthcoming-appointments"))
                .body(result);

    }
    @PutMapping("/{id}")
    public ResponseEntity<PADTO> updateAppointment(
            @PathVariable(value = "id", required = true) final Long id,
            @RequestBody PADTO paDTO
    ) throws URISyntaxException {
        if (Objects.equals(id.intValue(), paDTO.getPrevious_appointment_id()) || paRepository.existsById(id.intValue())){
            PADTO result = paService.save(paDTO);
            return ResponseEntity.ok().body(result);
        }
        throw new RuntimeException("update exception");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        paService.delete(id.intValue());
        return ResponseEntity
                .noContent()
                .build();
    }
}
