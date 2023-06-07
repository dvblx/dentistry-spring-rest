package ru.dentistry.dentistryrest.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.dentistry.dentistryrest.repos.DentistryRepository;
import ru.dentistry.dentistryrest.service.DentistryService;
import ru.dentistry.dentistryrest.service.dto.DentistryDTO;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/dentistry")
public class DentistryResource {
    private final DentistryService dentistryService;
    private final DentistryRepository dentistryRepository;

    public DentistryResource(DentistryService dentistryService, DentistryRepository dentistryRepository) {
        this.dentistryService = dentistryService;
        this.dentistryRepository = dentistryRepository;
    }

    @GetMapping("")
    //@JsonView(Views.DentistPreview.class)
    public ResponseEntity<List<DentistryDTO>> getAllDentistry(Pageable pageable) {
        Page<DentistryDTO> page = dentistryService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());

    }
    @GetMapping("/{id}")
    public ResponseEntity<DentistryDTO> getOneDentistry(@PathVariable Long id) {
        Optional<DentistryDTO> dentistryDTO = dentistryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dentistryDTO);
    }
    @PostMapping("")
    public ResponseEntity<DentistryDTO> newDentist(@RequestBody DentistryDTO dentistryDTO) throws URISyntaxException {
        DentistryDTO result = dentistryService.save(dentistryDTO);
        return ResponseEntity
                .created(new URI("/api/dentists/"))
                .body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DentistryDTO> updateDentistry(
            @PathVariable(value = "id", required = true) final Long id,
            @RequestBody DentistryDTO dentistryDTO
    ) throws URISyntaxException {
        if (Objects.equals(id.intValue(), dentistryDTO.getDentistry_id()) || dentistryRepository.existsById(id.intValue())){
            DentistryDTO result = dentistryService.save(dentistryDTO);
            return ResponseEntity.ok().body(result);
        }
        throw new RuntimeException("update exeption");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDentistry(@PathVariable Long id) {
        dentistryService.delete(id.intValue());
        return ResponseEntity
                .noContent()
                .build();
    }
}
