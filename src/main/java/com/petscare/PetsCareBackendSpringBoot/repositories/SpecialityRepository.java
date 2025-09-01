package com.petscare.PetsCareBackendSpringBoot.repositories;

import com.petscare.PetsCareBackendSpringBoot.models.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {

}
