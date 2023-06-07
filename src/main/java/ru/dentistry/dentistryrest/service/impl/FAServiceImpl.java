package ru.dentistry.dentistryrest.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dentistry.dentistryrest.entities.ForthcomingAppointment;
import ru.dentistry.dentistryrest.repos.FARepository;
import ru.dentistry.dentistryrest.service.FAService;
import ru.dentistry.dentistryrest.service.dto.FADTO;
import ru.dentistry.dentistryrest.service.mapper.FAMapper;

import java.sql.Date;
import java.util.Optional;

@Service
@Transactional
public class FAServiceImpl implements FAService {
    private final FAMapper faMapper;
    private final FARepository faRepository;

    public FAServiceImpl(FAMapper faMapper, FARepository faRepository) {
        this.faMapper = faMapper;
        this.faRepository = faRepository;
    }

    @Override
    public FADTO save(FADTO FaDTO) {
        ForthcomingAppointment appointment = faMapper.toEntity(FaDTO);
        appointment = faRepository.save(appointment);
        return faMapper.toDto(appointment);
    }

    @Override
    public Optional<FADTO> partialUpdate(FADTO FaDTO) {
        return faRepository
                .findById(FaDTO.getAppointment_id())
                .map(
                        existingDentist -> {
                            faMapper.partialUpdate(existingDentist, FaDTO);
                            return existingDentist;
                        }
                )
                .map(faRepository::save)
                .map(faMapper::toDto);
    }

    @Override
    public Page<FADTO> findAll(Pageable pageable) {
        return faRepository.findAll(pageable).map(faMapper::toDto);
    }

    @Override
    public Page<FADTO> findAllUnfilledToOneDoc(int id, Date date) {return  new PageImpl<>(faRepository.findAllUnfilledForOneDoc(id, date)).map(faMapper::toDto);}

    @Override
    public Optional<FADTO> findOne(Long id) {
        return faRepository.findById(id.intValue()).map(faMapper::toDto);
    }

    @Override
    public void delete(int id) {faRepository.deleteById(id);}
}
