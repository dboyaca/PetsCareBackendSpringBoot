package com.petscare.PetsCareBackendSpringBoot.services;
import com.petscare.PetsCareBackendSpringBoot.models.MedicalAppointment;
import com.petscare.PetsCareBackendSpringBoot.repositories.MedicalAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class MedicalAppointmentService {

    private final MedicalAppointmentRepository medicalAppointmentRepository;

    @Autowired   //It injects the dependency right away
    public MedicalAppointmentService(MedicalAppointmentRepository medicalAppointmentRepository){
        this.medicalAppointmentRepository = medicalAppointmentRepository;
    }

    public MedicalAppointment addMedicalAppointment(MedicalAppointment medicalAppointment){
        return this.medicalAppointmentRepository.save(medicalAppointment);
    }

    public MedicalAppointment getMedicalAppointmentById(Integer medicalAppointmentId){
        Optional<MedicalAppointment> optionalValue = this.medicalAppointmentRepository.findById(medicalAppointmentId);
        if(optionalValue.isEmpty()){
            return null;
        }
        return optionalValue.get();
    }

    public void deleteMedicalAppointmentById(Integer medicalAppointmentId){
        this.medicalAppointmentRepository.deleteById(medicalAppointmentId);
    }


}
