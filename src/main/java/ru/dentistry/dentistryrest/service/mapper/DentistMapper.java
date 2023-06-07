package ru.dentistry.dentistryrest.service.mapper;

import org.mapstruct.Mapper;
import ru.dentistry.dentistryrest.entities.Dentist;
import ru.dentistry.dentistryrest.service.dto.DentistDTO;

@Mapper(componentModel = "spring", uses = { DentistryMapper.class, DentistTypeMapper.class, TTMapper.class })
public interface DentistMapper extends EntityMapper<DentistDTO, Dentist>{
    Dentist toEntity(DentistDTO dto);

    DentistDTO toDto(Dentist entity);
}
