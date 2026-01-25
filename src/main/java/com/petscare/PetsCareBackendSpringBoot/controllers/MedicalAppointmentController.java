package com.petscare.PetsCareBackendSpringBoot.controllers;

import com.petscare.PetsCareBackendSpringBoot.models.MedicalAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.petscare.PetsCareBackendSpringBoot.services.MedicalAppointmentService;

import java.util.List;


@RestController
public class MedicalAppointmentController {

    private final MedicalAppointmentService medicalAppointmentService;

    @Autowired
    public MedicalAppointmentController(MedicalAppointmentService medicalAppointmentService){
        this.medicalAppointmentService = medicalAppointmentService;
    }

    @PostMapping("/medicalAppointment/add/{patientId}/{specialityId}/{employeeId}")
    public ResponseEntity<?> scheduleAppointment(
        @PathVariable Integer patientId,
        @PathVariable Integer specialityId,
        @PathVariable Integer employeeId,
        @RequestBody MedicalAppointment detailsMedicalAppointment) {

        try{
            MedicalAppointment medicalAppointment = medicalAppointmentService.addMedicalAppointment(patientId, specialityId, employeeId, detailsMedicalAppointment) ;
            return ResponseEntity.ok(medicalAppointment);
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/medicalAppointment/getById/{mId}")
    public MedicalAppointment getMedicalAppointmentById(@PathVariable(name="mId") Integer medicalAppointmentId){
        return this.medicalAppointmentService.getMedicalAppointmentById(medicalAppointmentId);
    }

    @GetMapping("/medicalAppointment/getByPatient/{patientId}")
    public ResponseEntity<List<MedicalAppointment>> getAppointmentsByPatient(@PathVariable Integer patientId) {

        List<MedicalAppointment> appointments = medicalAppointmentService.getMedicalAppointmentsByPatientId(patientId);

        if (appointments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(appointments);
    }


    @DeleteMapping("/medicalAppointment/deleteById/{medicalAppointmentId}")
    public void deleteMedicalAppointmentById(@PathVariable Integer medicalAppointmentId){
        this.medicalAppointmentService.deleteMedicalAppointmentById(medicalAppointmentId);
    }
}
