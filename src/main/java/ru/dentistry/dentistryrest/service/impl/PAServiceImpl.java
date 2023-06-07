package ru.dentistry.dentistryrest.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dentistry.dentistryrest.entities.PreviousAppointment;
import ru.dentistry.dentistryrest.repos.PARepository;
import ru.dentistry.dentistryrest.service.PAService;
import ru.dentistry.dentistryrest.service.dto.PADTO;
import ru.dentistry.dentistryrest.service.dto.TimeTableDTO;
import ru.dentistry.dentistryrest.service.mapper.PAMapper;

import java.util.Optional;


@Service
@Transactional
public class PAServiceImpl implements PAService {
    private final PAMapper paMapper;
    private final PARepository paRepository;

    public PAServiceImpl(PAMapper paMapper, PARepository paRepository) {
        this.paMapper = paMapper;
        this.paRepository = paRepository;
    }

    @Override
    public PADTO save(PADTO PaDTO) {
        PreviousAppointment appointment = paMapper.toEntity(PaDTO);
        appointment = paRepository.save(appointment);
        return paMapper.toDto(appointment);
    }

    @Override
    public Optional<PADTO> partialUpdate(PADTO PaDTO) {
        return paRepository
                .findById(PaDTO.getPrevious_appointment_id())
                .map(
                        existingDentist -> {
                            paMapper.partialUpdate(existingDentist, PaDTO);
                            return existingDentist;
                        }
                )
                .map(paRepository::save)
                .map(paMapper::toDto);
    }

    @Override
    public Page<PADTO> findAll(Pageable pageable) {
        return paRepository.findAll(pageable).map(paMapper::toDto);
    }

    @Override
    public Page<PADTO> findByDentistId(int id) {return new PageImpl<>(paRepository.findByDentistId(id)).map(paMapper::toDto);}

    @Override
    public Page<PADTO> findByDentistryId(int id) {return new PageImpl<>(paRepository.findByDentistryId(id)).map(paMapper::toDto);}

    @Override
    public Page<PADTO> findAllUnfilled() {return new PageImpl<>(paRepository.findAllUnfilled()).map(paMapper::toDto);}

    @Override
    public Page<PADTO> findAllFilled() {return new PageImpl<>(paRepository.findAllFilled()).map(paMapper::toDto);}

    @Override
    public Optional<PADTO> findOne(Long id) {
        return paRepository.findById(id.intValue()).map(paMapper::toDto);
    }

    @Override
    public void delete(int id) {paRepository.deleteById(id);}
}
