package com.petscare.PetsCareBackendSpringBoot.repositories;
import com.petscare.PetsCareBackendSpringBoot.models.MedicalAppointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Integer>{
}
