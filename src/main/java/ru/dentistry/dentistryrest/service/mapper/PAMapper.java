package ru.dentistry.dentistryrest.service.mapper;

import org.mapstruct.Mapper;
import ru.dentistry.dentistryrest.entities.PreviousAppointment;
import ru.dentistry.dentistryrest.service.dto.PADTO;
@Mapper(componentModel = "spring", uses = { DentistryMapper.class, DentistMapper.class })
public interface PAMapper extends EntityMapper<PADTO, PreviousAppointment>{
    PreviousAppointment toEntity(PADTO dto);

    PADTO toDto(PreviousAppointment entity);
}
