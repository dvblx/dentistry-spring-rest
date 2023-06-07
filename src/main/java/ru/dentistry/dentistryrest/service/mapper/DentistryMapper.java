package ru.dentistry.dentistryrest.service.mapper;

import org.mapstruct.Mapper;
import ru.dentistry.dentistryrest.entities.Dentistry;
import ru.dentistry.dentistryrest.service.dto.DentistryDTO;

@Mapper(componentModel = "spring", uses = {})
public interface DentistryMapper extends EntityMapper<DentistryDTO, Dentistry>{
    Dentistry toEntity(DentistryDTO dto);

    DentistryDTO toDto(Dentistry entity);
}
