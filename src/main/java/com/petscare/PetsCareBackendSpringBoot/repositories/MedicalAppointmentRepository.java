package com.petscare.PetsCareBackendSpringBoot.repositories;
import com.petscare.PetsCareBackendSpringBoot.models.MedicalAppointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Integer>{
    @Query("SELECT m FROM MedicalAppointment m WHERE m.patient.id_patient = :patientId")
    List<MedicalAppointment> findByPatientId(@Param("patientId") Integer patientId);
}
