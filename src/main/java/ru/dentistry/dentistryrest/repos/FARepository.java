package ru.dentistry.dentistryrest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.dentistry.dentistryrest.entities.ForthcomingAppointment;
import ru.dentistry.dentistryrest.entities.PreviousAppointment;
import ru.dentistry.dentistryrest.entities.TimeTable;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FARepository extends JpaRepository<ForthcomingAppointment, Integer>, JpaSpecificationExecutor<ForthcomingAppointment> {
    @Query(value ="SELECT f FROM ForthcomingAppointment f WHERE f.dentist.dentist_id = ?1")
    List<ForthcomingAppointment> findByDentistId(Integer id);

    @Query(value ="SELECT f FROM ForthcomingAppointment f WHERE f.dentist.dentistry.dentistry_id = ?1")
    List<ForthcomingAppointment> findByDentistryId(Integer id);
    @Query(value ="SELECT f FROM ForthcomingAppointment f WHERE f.dentist.dentist_name like ?1 and f.appointment_day = ?2")
    List<ForthcomingAppointment> findByDentistAndDay(String dentist_name, Date day);
    @Query(value ="SELECT f FROM ForthcomingAppointment f WHERE f.dentist.dentist_id = ?1 AND f.appointment_day < ?2")
    List<ForthcomingAppointment> findAllUnfilledForOneDoc(int doc_id, Date date);
}
