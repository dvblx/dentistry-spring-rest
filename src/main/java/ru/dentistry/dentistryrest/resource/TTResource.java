package ru.dentistry.dentistryrest.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.dentistry.dentistryrest.service.TTService;
import ru.dentistry.dentistryrest.service.dto.TimeTableDTO;
import tech.jhipster.web.util.PaginationUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TTResource {
    private final TTService ttService;

    public TTResource(TTService ttService) {
        this.ttService = ttService;
    }

    @GetMapping("/timetable")
    public ResponseEntity<List<TimeTableDTO>> getFullTimeTable(Pageable pageable) {
        Page<TimeTableDTO> page = ttService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    @PostMapping("/dentists/{id}/timetable")
    public ResponseEntity<TimeTableDTO> newTimeTable(@RequestBody TimeTableDTO ttDTO) throws URISyntaxException {
        TimeTableDTO result = ttService.save(ttDTO);
        return ResponseEntity
                .created(new URI("/dentists/{id}/timetable"))
                .body(result);
    }
    @GetMapping("/dentists/{id}/timetable")
    public ResponseEntity<List<TimeTableDTO>> getOneDentistTimeTable( @PathVariable Long id) {
        Page<TimeTableDTO> page = ttService.findByDentistId(id.intValue()) ;
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    @GetMapping("/dentistry/{id}/timetable")
    public ResponseEntity<List<TimeTableDTO>> getOneClinicTimeTable(@PathVariable Long id ) {
        Page<TimeTableDTO> page = ttService.findByDentistryId(id.intValue());
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

}
