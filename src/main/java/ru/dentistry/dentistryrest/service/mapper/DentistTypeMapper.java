package ru.dentistry.dentistryrest.service.mapper;

import org.mapstruct.Mapper;
import ru.dentistry.dentistryrest.entities.DentistType;
import ru.dentistry.dentistryrest.service.dto.DentistTypeDTO;

@Mapper(componentModel = "spring", uses = {})
public interface DentistTypeMapper extends EntityMapper<DentistTypeDTO, DentistType> {
    DentistType toEntity(DentistTypeDTO dto);

    DentistTypeDTO toDto(DentistType entity);
}
