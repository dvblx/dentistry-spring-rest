package ru.dentistry.dentistryrest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.dentistry.dentistryrest.service.dto.DentistDTO;

import java.util.Optional;

public interface DentistService {
    DentistDTO save(DentistDTO dentistDTO);
    Optional<DentistDTO> partialUpdate(DentistDTO dentistDTO);
    Page<DentistDTO> findAll(Pageable pageable);
    Page<DentistDTO> findByClinic(String clinic_name);
    Page<DentistDTO> findByType(String type_name);
    Page<DentistDTO> findByClinicAndType(String clinic_name, String type_name);
    Optional<DentistDTO> findOne(Long id);
    void delete(int id);
}
