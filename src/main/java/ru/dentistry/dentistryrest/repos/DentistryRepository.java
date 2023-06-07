package ru.dentistry.dentistryrest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.dentistry.dentistryrest.entities.Dentistry;

@Repository
public interface DentistryRepository extends JpaRepository<Dentistry, Integer>, JpaSpecificationExecutor<Dentistry> {
}
