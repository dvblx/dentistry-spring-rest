package ru.dentistry.dentistryrest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.dentistry.dentistryrest.entities.Dentist;

import java.util.List;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Integer>, JpaSpecificationExecutor<Dentist> {
    @Query(value ="SELECT d FROM Dentist d WHERE d.dentistry.name like ?1")
    List<Dentist> findByClinic(String clinic_name);
    @Query(value ="SELECT d FROM Dentist d WHERE d.dentist_type.type_name like ?1")
    List<Dentist> findByType(String type);
    @Query(value ="SELECT d FROM Dentist d WHERE d.dentistry.name like ?1 and d.dentist_type.type_name like ?2")
    List<Dentist> findByClinicAndType(String clinic_name, String type);
}
