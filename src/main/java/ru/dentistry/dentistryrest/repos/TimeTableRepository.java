package ru.dentistry.dentistryrest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.dentistry.dentistryrest.entities.TimeTable;

import java.util.List;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Integer>, JpaSpecificationExecutor<TimeTable>{
    @Query(value ="SELECT t FROM TimeTable t WHERE t.dentist.dentist_id = ?1")
    List<TimeTable> findByDentistId(Integer id);

    @Query(value ="SELECT t FROM TimeTable t WHERE t.dentist.dentistry.dentistry_id = ?1")
    List<TimeTable> findByDentistryId(Integer id);
}
