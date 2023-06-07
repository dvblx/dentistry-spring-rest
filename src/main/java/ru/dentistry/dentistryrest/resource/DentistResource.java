package ru.dentistry.dentistryrest.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.dentistry.dentistryrest.repos.DentistRepository;
import ru.dentistry.dentistryrest.repos.TimeTableRepository;
import ru.dentistry.dentistryrest.service.DentistService;
import ru.dentistry.dentistryrest.service.TTService;
import ru.dentistry.dentistryrest.service.dto.DentistDTO;
import ru.dentistry.dentistryrest.service.dto.TimeTableDTO;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/dentists")
public class DentistResource {
    private final DentistService dentistService;
    private final DentistRepository dentistRepository;

    public DentistResource(DentistService dentistService, DentistRepository dentistRepository) {
        this.dentistService = dentistService;
        this.dentistRepository = dentistRepository;
    }

    @GetMapping("")
    //@JsonView(Views.DentistPreview.class)
    public ResponseEntity<List<DentistDTO>> getAllDentists(Pageable pageable, @RequestParam(value = "dentistry", required = false) String dentistry,
                                                           @RequestParam(value = "dentist_type", required = false) String dentist_type) {
        Page<DentistDTO> page;
        if (dentistry != null && dentist_type != null){
            page = dentistService.findByClinicAndType(dentistry, dentist_type);
        }
        else if (dentistry != null){
            page = dentistService.findByClinic(dentistry);
        }
        else if (dentist_type != null){
            page = dentistService.findByType(dentist_type);
        }
        else{
            page = dentistService.findAll(pageable);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());

    }
    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> getOneDentist(@PathVariable Long id) {
        Optional<DentistDTO> dentistDTO = dentistService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dentistDTO);
    }
    @PostMapping("")
    public ResponseEntity<DentistDTO> newDentist(@RequestBody DentistDTO dentistDTO) throws URISyntaxException {
        DentistDTO result = dentistService.save(dentistDTO);
        return ResponseEntity
                .created(new URI("/api/dentists/"))
                .body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DentistDTO> updateDentist(
            @PathVariable(value = "id", required = true) final Long id,
            @RequestBody DentistDTO dentistDTO
    ) throws URISyntaxException {
        if (Objects.equals(id.intValue(), dentistDTO.getDentist_id()) || dentistRepository.existsById(id.intValue())){
            DentistDTO result = dentistService.save(dentistDTO);
            return ResponseEntity.ok().body(result);
        }
        throw new RuntimeException("update exeption");
    }
    //@PatchMapping("/{id}")
    //public ResponseEntity<DentistDTO> partialUpdateDentist(
    //        @PathVariable(value = "id", required = true) final Long id,
    //        @RequestBody DentistDTO dentistDTO
    //) throws URISyntaxException {
    //    if (Objects.equals(id.intValue(), dentistDTO.getDentist_id()) || dentistRepository.existsById(id.intValue())){
    //        Optional<DentistDTO> result = dentistService.partialUpdate(dentistDTO);
    //        return ResponseUtil.wrapOrNotFound(result);
    //    }
    //    throw new RuntimeException("partial update exeption");
    //}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDentist(@PathVariable Long id) {
        dentistService.delete(id.intValue());
        return ResponseEntity
                .noContent()
                .build();
    }
}
