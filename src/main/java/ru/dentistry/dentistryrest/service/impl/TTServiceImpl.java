package ru.dentistry.dentistryrest.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dentistry.dentistryrest.entities.TimeTable;
import ru.dentistry.dentistryrest.repos.TimeTableRepository;
import ru.dentistry.dentistryrest.service.TTService;
import ru.dentistry.dentistryrest.service.dto.DentistDTO;
import ru.dentistry.dentistryrest.service.dto.TimeTableDTO;
import ru.dentistry.dentistryrest.service.mapper.TTMapper;

import java.util.Optional;

@Service
@Transactional
public class TTServiceImpl implements TTService {
    private final TTMapper ttMapper;
    private final TimeTableRepository timeTableRepository;

    public TTServiceImpl(TTMapper ttMapper, TimeTableRepository timeTableRepository) {
        this.ttMapper = ttMapper;
        this.timeTableRepository = timeTableRepository;
    }

    @Override
    public TimeTableDTO save(TimeTableDTO timeTableDTO) {
        TimeTable tt = ttMapper.toEntity(timeTableDTO);
        tt = timeTableRepository.save(tt);
        return ttMapper.toDto(tt);
    }


    @Override
    public Page<TimeTableDTO> findAll(Pageable pageable) {
        return timeTableRepository.findAll(pageable).map(ttMapper::toDto);
    }

    @Override
    public Page<TimeTableDTO> findByDentistId(int id) {
        return new PageImpl<>(timeTableRepository.findByDentistId(id)) .map(ttMapper::toDto);
    }

    @Override
    public Page<TimeTableDTO> findByDentistryId(int id) {
        return new PageImpl<>(timeTableRepository.findByDentistryId(id)) .map(ttMapper::toDto);
    }

    @Override
    public Optional<TimeTableDTO> findOne(Long id) {
        return timeTableRepository.findById(id.intValue()).map(ttMapper::toDto);
    }

    @Override
    public void delete(int id) {timeTableRepository.deleteById(id);}
}
