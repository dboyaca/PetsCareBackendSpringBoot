package com.petscare.PetsCareBackendSpringBoot.controllers;

import com.petscare.PetsCareBackendSpringBoot.models.Speciality;
import com.petscare.PetsCareBackendSpringBoot.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpecialityController {

    private final SpecialityService specialityService;

    @Autowired
    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @PostMapping("/speciality/add")
    public Speciality addSpeciality(@RequestBody Speciality speciality){
        return this.specialityService.addSpeciality(speciality);
    }

    @GetMapping("/specialityById/{sId}")
    public Speciality getSpecialityById(@PathVariable(name="sId") Integer specialityId){
        return this.specialityService.getSpecialityById(specialityId);
    }

    @PutMapping("/updateSpeciality/{specialityId}")
    public Speciality updateStudent(@PathVariable Integer specialityId, @RequestBody Speciality speciality){
        if(specialityId != speciality.getId_speciality()){
            return speciality;
        }
        return this.specialityService.updateSpeciality(speciality);
    }

    @DeleteMapping("/deleteSpeciality/{specialityId}")
    public void deleteSpeciality(@PathVariable Integer specialityId){
        this.specialityService.deleteSpecialityById(specialityId);
    }

}
