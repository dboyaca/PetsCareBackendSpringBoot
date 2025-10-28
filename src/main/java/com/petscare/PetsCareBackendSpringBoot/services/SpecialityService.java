package com.petscare.PetsCareBackendSpringBoot.services;

import com.petscare.PetsCareBackendSpringBoot.repositories.SpecialityRepository;
import com.petscare.PetsCareBackendSpringBoot.models.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpecialityService {
    private final SpecialityRepository specialityRepository;

    @Autowired
    public SpecialityService(SpecialityRepository specialityRepository){
        this.specialityRepository = specialityRepository;
    }

    public Speciality addSpeciality(Speciality speciality){
        return this.specialityRepository.save(speciality);
    }

    public Speciality getSpecialityById(Integer specialityId){
        Optional<Speciality> optionalValue = this.specialityRepository.findById(specialityId);
        if(optionalValue.isEmpty()){
            return null;
        }
        return optionalValue.get();
    }

    public List<Speciality> allSpecialities(){
        return this.specialityRepository.findAll();
    }

    public Speciality updateSpeciality(Speciality speciality){
        Speciality existingSpeciality = this.getSpecialityById(speciality.getId_speciality());
        if(existingSpeciality==null){
            return null;
        }else{
            existingSpeciality.setName(speciality.getName());
            existingSpeciality.setCharge_per_hour(speciality.getCharge_per_hour());
            return this.specialityRepository.save(existingSpeciality);
        }
    }

    public void deleteSpecialityById(Integer specialityId){
        this.specialityRepository.deleteById(specialityId);
    }

}
