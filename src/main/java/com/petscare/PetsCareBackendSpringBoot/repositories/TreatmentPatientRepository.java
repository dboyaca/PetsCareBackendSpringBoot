package com.petscare.PetsCareBackendSpringBoot.repositories;

import com.petscare.PetsCareBackendSpringBoot.models.TreatmentPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentPatientRepository extends JpaRepository<TreatmentPatient, Integer> {

    @Query("SELECT tp FROM TreatmentPatient tp WHERE tp.patient.id_patient = :id ")
    List<TreatmentPatient> findTreatmentHistory(@Param("id") Integer id);

}
