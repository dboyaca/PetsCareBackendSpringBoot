package com.petscare.PetsCareBackendSpringBoot.services;

import com.petscare.PetsCareBackendSpringBoot.models.Patient;
import com.petscare.PetsCareBackendSpringBoot.models.Treatment;
import com.petscare.PetsCareBackendSpringBoot.models.TreatmentPatient;
import com.petscare.PetsCareBackendSpringBoot.repositories.PatientRepository;
import com.petscare.PetsCareBackendSpringBoot.repositories.TreatmentPatientRepository;
import com.petscare.PetsCareBackendSpringBoot.repositories.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {

    private final TreatmentRepository treatmentRepository;
    private final PatientRepository patientRepository;
    private final TreatmentPatientRepository treatmentPatientRepository;

    @Autowired
    public TreatmentService (TreatmentRepository treatmentRepository, PatientRepository patientRepository, TreatmentPatientRepository treatmentPatientRepository){
        this.treatmentRepository = treatmentRepository;
        this.patientRepository = patientRepository;
        this.treatmentPatientRepository = treatmentPatientRepository;
    }

    public Treatment createTreatment (Treatment treatment){
        return this.treatmentRepository.save(treatment);
    }

    public TreatmentPatient assignTreatment(Integer patientId, Integer treatmentId, TreatmentPatient details){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new RuntimeException("Patient not found"));

        Treatment treatment = treatmentRepository.findById(treatmentId)
                .orElseThrow(()-> new RuntimeException("Treatment not found"));

        //We proceed to link the  patient with the treatment

        details.setPatient(patient);
        details.setTreatment(treatment);

        return treatmentPatientRepository.save(details);
    }

    public List<TreatmentPatient> getTreatmentsByPatient(Integer patientId){
        return treatmentPatientRepository.findTreatmentHistory(patientId);
    }

    public List<Treatment> allTreatments(){
        return treatmentRepository.findAll();
    }

}
