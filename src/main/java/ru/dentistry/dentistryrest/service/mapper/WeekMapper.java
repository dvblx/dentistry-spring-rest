package ru.dentistry.dentistryrest.service.mapper;

import org.mapstruct.Mapper;
import ru.dentistry.dentistryrest.entities.Dentist;
import ru.dentistry.dentistryrest.entities.Week;
import ru.dentistry.dentistryrest.service.dto.DentistDTO;
import ru.dentistry.dentistryrest.service.dto.WeekDTO;

@Mapper(componentModel = "spring", uses = {})
public interface WeekMapper extends EntityMapper<WeekDTO, Week>{
    Week toEntity(WeekDTO dto);

    WeekDTO toDto(Week entity);
}
