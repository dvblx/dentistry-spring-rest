package ru.dentistry.dentistryrest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.dentistry.dentistryrest.entities.PreviousAppointment;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PARepository extends JpaRepository<PreviousAppointment, Integer>, JpaSpecificationExecutor<PreviousAppointment> {
    @Query(value ="SELECT p FROM PreviousAppointment p WHERE p.dentist.dentist_id = ?1")
    List<PreviousAppointment> findByDentistId(Integer id);

    @Query(value ="SELECT p FROM PreviousAppointment p WHERE p.dentist.dentistry.dentistry_id = ?1")
    List<PreviousAppointment> findByDentistryId(Integer id);
    @Query(value ="SELECT p FROM PreviousAppointment p WHERE p.patient IS NULL OR p.diagnosis IS NULL OR p.admission_price=0")
    List<PreviousAppointment> findAllUnfilled();
    @Query(value ="SELECT p FROM PreviousAppointment p WHERE p.patient IS NOT NULL AND p.diagnosis IS NOT NULL AND p.admission_price > 0")
    List<PreviousAppointment> findAllFilled();
}
