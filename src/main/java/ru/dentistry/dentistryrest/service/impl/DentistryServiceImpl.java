package ru.dentistry.dentistryrest.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dentistry.dentistryrest.entities.Dentistry;
import ru.dentistry.dentistryrest.repos.DentistryRepository;
import ru.dentistry.dentistryrest.service.DentistryService;
import ru.dentistry.dentistryrest.service.dto.DentistryDTO;
import ru.dentistry.dentistryrest.service.mapper.DentistryMapper;

import java.util.Optional;

@Service
@Transactional
public class DentistryServiceImpl implements DentistryService{
    private final DentistryMapper dentistryMapper;
    private final DentistryRepository dentistryRepository;

    public DentistryServiceImpl(DentistryMapper dentistryMapper, DentistryRepository dentistryRepository) {
        this.dentistryMapper = dentistryMapper;
        this.dentistryRepository = dentistryRepository;
    }

    @Override
    public DentistryDTO save(DentistryDTO dentistryDTO) {
        Dentistry dentist = dentistryMapper.toEntity(dentistryDTO);
        dentist = dentistryRepository.save(dentist);
        return dentistryMapper.toDto(dentist);
    }

    @Override
    public Optional<DentistryDTO> partialUpdate(DentistryDTO dentistryDTO) {
        return dentistryRepository
                .findById(dentistryDTO.getDentistry_id())
                .map(
                        existingDentist -> {
                            dentistryMapper.partialUpdate(existingDentist, dentistryDTO);
                            return existingDentist;
                        }
                )
                .map(dentistryRepository::save)
                .map(dentistryMapper::toDto);
    }

    @Override
    public Page<DentistryDTO> findAll(Pageable pageable) {return dentistryRepository.findAll(pageable).map(dentistryMapper::toDto);}

    @Override
    public Optional<DentistryDTO> findOne(Long id) {return dentistryRepository.findById(id.intValue()).map(dentistryMapper::toDto);}

    @Override
    public void delete(int id) {dentistryRepository.deleteById(id);}
}
