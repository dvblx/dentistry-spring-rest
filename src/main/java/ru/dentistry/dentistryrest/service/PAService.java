package ru.dentistry.dentistryrest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.dentistry.dentistryrest.service.dto.PADTO;

import java.util.Optional;

public interface PAService {
    PADTO save(PADTO PaDTO);
    Optional<PADTO> partialUpdate(PADTO PaDTO);
    Page<PADTO> findAll(Pageable pageable);
    Page<PADTO> findByDentistId(int id);
    Page<PADTO> findByDentistryId(int id);
    Page<PADTO> findAllUnfilled();
    Page<PADTO> findAllFilled();
    Optional<PADTO> findOne(Long id);
    void delete(int id);
}
