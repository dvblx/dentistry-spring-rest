package ru.dentistry.dentistryrest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.dentistry.dentistryrest.service.dto.DentistryDTO;
import ru.dentistry.dentistryrest.service.dto.FADTO;
import ru.dentistry.dentistryrest.service.dto.PADTO;
import ru.dentistry.dentistryrest.service.dto.TimeTableDTO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

public interface FAService {
    FADTO save(FADTO FaDTO);
    Optional<FADTO> partialUpdate(FADTO FaDTO);
    Page<FADTO> findAll(Pageable pageable);
    Page<FADTO> findAllUnfilledToOneDoc(int id, Date date);
    Optional<FADTO> findOne(Long id);
    void delete(int id);
}
