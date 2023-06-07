package ru.dentistry.dentistryrest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.dentistry.dentistryrest.service.dto.DentistDTO;
import ru.dentistry.dentistryrest.service.dto.DentistryDTO;

import java.util.Optional;
import java.util.UUID;

public interface DentistryService {
    DentistryDTO save(DentistryDTO dentistryDTO);
    Optional<DentistryDTO> partialUpdate(DentistryDTO dentistryDTO);
    Page<DentistryDTO> findAll(Pageable pageable);
    Optional<DentistryDTO> findOne(Long id);
    void delete(int id);
}
