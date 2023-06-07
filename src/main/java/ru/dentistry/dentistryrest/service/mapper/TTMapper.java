package ru.dentistry.dentistryrest.service.mapper;


import org.mapstruct.Mapper;
import ru.dentistry.dentistryrest.entities.TimeTable;
import ru.dentistry.dentistryrest.service.dto.TimeTableDTO;
@Mapper(componentModel = "spring", uses = { DentistryMapper.class, DentistMapper.class, WeekMapper.class })
public interface TTMapper extends EntityMapper<TimeTableDTO, TimeTable>{
    TimeTable toEntity(TimeTableDTO dto);

    TimeTableDTO toDto(TimeTable entity);

}
