package com.petscare.PetsCareBackendSpringBoot.repositories;

import com.petscare.PetsCareBackendSpringBoot.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
