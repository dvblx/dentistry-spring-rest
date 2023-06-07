package ru.dentistry.dentistryrest.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dentistry.dentistryrest.entities.Dentist;
import ru.dentistry.dentistryrest.repos.DentistRepository;
import ru.dentistry.dentistryrest.service.DentistService;
import ru.dentistry.dentistryrest.service.dto.DentistDTO;
import ru.dentistry.dentistryrest.service.mapper.DentistMapper;

import java.util.Optional;

@Service
@Transactional
public class DentistServiceImpl implements DentistService {
    private final DentistMapper dentistMapper;
    private final DentistRepository dentistRepository;

    public DentistServiceImpl(DentistMapper dentistMapper, DentistRepository dentistRepository) {
        this.dentistMapper = dentistMapper;
        this.dentistRepository = dentistRepository;
    }

    @Override
    public DentistDTO save(DentistDTO dentistDTO) {
        Dentist dentist = dentistMapper.toEntity(dentistDTO);
        dentist = dentistRepository.save(dentist);
        return dentistMapper.toDto(dentist);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DentistDTO> partialUpdate(DentistDTO dentistDTO) {
        return dentistRepository
                .findById(dentistDTO.getDentist_id())
                .map(
                        existingDentist -> {
                            dentistMapper.partialUpdate(existingDentist, dentistDTO);
                            return existingDentist;
                        }
                )
                .map(dentistRepository::save)
                .map(dentistMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DentistDTO> findAll(Pageable pageable) {
        return dentistRepository.findAll(pageable).map(dentistMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DentistDTO> findByClinic(String clinic_name) {
        return new PageImpl<>(dentistRepository.findByClinic(clinic_name)).map(dentistMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DentistDTO> findByType(String type_name) {
        return new PageImpl<>(dentistRepository.findByType(type_name)).map(dentistMapper::toDto);
    }

    @Override
    public Page<DentistDTO> findByClinicAndType(String clinic_name, String type_name) {
        return new PageImpl<>(dentistRepository.findByClinicAndType(clinic_name, type_name)).map(dentistMapper::toDto);
    }

    @Override
    public Optional<DentistDTO> findOne(Long id) {
        return dentistRepository.findById(id.intValue()).map(dentistMapper::toDto);
    }

    @Override
    public void delete(int id) {
        dentistRepository.deleteById(id);
    }
}
