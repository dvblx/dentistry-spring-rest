package ru.dentistry.dentistryrest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.dentistry.dentistryrest.service.dto.DentistDTO;
import ru.dentistry.dentistryrest.service.dto.TimeTableDTO;

import java.util.Optional;

public interface TTService {
    TimeTableDTO save(TimeTableDTO timeTableDTO);
    Page<TimeTableDTO> findAll(Pageable pageable);
    Page<TimeTableDTO> findByDentistId(int id);
    Page<TimeTableDTO> findByDentistryId(int id);
    Optional<TimeTableDTO> findOne(Long id);
    void delete(int id);
}
