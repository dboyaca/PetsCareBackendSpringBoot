package com.petscare.PetsCareBackendSpringBoot.controllers;

import com.petscare.PetsCareBackendSpringBoot.models.Treatment;
import com.petscare.PetsCareBackendSpringBoot.models.TreatmentPatient;
import com.petscare.PetsCareBackendSpringBoot.services.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TreatmentController {

    private final TreatmentService treatmentService;

    @Autowired
    public TreatmentController(TreatmentService treatmentService){
        this.treatmentService = treatmentService;
    }

    @PostMapping("/addTreatment")
    public ResponseEntity<?> createTreatmentType(@RequestBody Treatment treatment) {
        try {
            Treatment newTreatment = treatmentService.createTreatment(treatment);
            return ResponseEntity.ok(newTreatment);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating treatment: " + e.getMessage());
        }
    }

    /*
    Assign a treatment to a specific patient
     */
    @PostMapping("/assignTreatement/{patientId}/{treatmentId}")
    public ResponseEntity<?> assignTreatment(
            @PathVariable Integer patientId,
            @PathVariable Integer treatmentId,
            @RequestBody TreatmentPatient details) {

        try {
            TreatmentPatient assignment = treatmentService.assignTreatment(patientId, treatmentId, details);
            return ResponseEntity.ok(assignment);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/patientHistory/{patientId}")
    public ResponseEntity<?> getPatientHistory(@PathVariable Integer patientId) {
        List<TreatmentPatient> history = treatmentService.getTreatmentsByPatient(patientId);

        if (history.isEmpty()) {
            return ResponseEntity.ok("This patient has no medical history yet.");
        }
        return ResponseEntity.ok(history);
    }

    @GetMapping("/allTreatments/")
    public List<Treatment> getAllTreatments(){
        return treatmentService.allTreatments();
    }

}


