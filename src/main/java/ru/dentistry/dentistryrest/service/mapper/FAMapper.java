package ru.dentistry.dentistryrest.service.mapper;

import org.mapstruct.Mapper;
import ru.dentistry.dentistryrest.entities.ForthcomingAppointment;
import ru.dentistry.dentistryrest.service.dto.FADTO;

@Mapper(componentModel = "spring", uses = { DentistryMapper.class, DentistMapper.class })
public interface FAMapper extends EntityMapper<FADTO, ForthcomingAppointment>{
    ForthcomingAppointment toEntity(FADTO dto);

    FADTO toDto(ForthcomingAppointment entity);
}
