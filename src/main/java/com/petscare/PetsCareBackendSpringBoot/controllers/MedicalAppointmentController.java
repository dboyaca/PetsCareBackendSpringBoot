package com.petscare.PetsCareBackendSpringBoot.controllers;

import com.petscare.PetsCareBackendSpringBoot.models.MedicalAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.petscare.PetsCareBackendSpringBoot.services.MedicalAppointmentService;


@RestController
public class MedicalAppointmentController {

    private final MedicalAppointmentService medicalAppointmentService;

    @Autowired
    public MedicalAppointmentController(MedicalAppointmentService medicalAppointmentService){
        this.medicalAppointmentService = medicalAppointmentService;
    }

    @PostMapping("/medicalAppointment/add")
    public MedicalAppointment addMedicalAppointment(@RequestBody MedicalAppointment medicalAppointment){
        return this.medicalAppointmentService.addMedicalAppointment(medicalAppointment);
    }

    @GetMapping("/medicalAppointment/getById/{mId}")
    public MedicalAppointment getMedicalAppointmentById(@PathVariable(name="mId") Integer medicalAppointmentId){
        return this.medicalAppointmentService.getMedicalAppointmentById(medicalAppointmentId);
    }

    @DeleteMapping("/medicalAppointment/deleteById/{medicalAppointmentId}")
    public void deleteMedicalAppointmentById(Integer medicalAppointmentId){
        this.medicalAppointmentService.deleteMedicalAppointmentById(medicalAppointmentId);
    }
}
