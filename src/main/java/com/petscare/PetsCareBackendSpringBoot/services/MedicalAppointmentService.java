package com.petscare.PetsCareBackendSpringBoot.services;
import com.petscare.PetsCareBackendSpringBoot.models.Employee;
import com.petscare.PetsCareBackendSpringBoot.models.MedicalAppointment;
import com.petscare.PetsCareBackendSpringBoot.models.Patient;
import com.petscare.PetsCareBackendSpringBoot.models.Speciality;
import com.petscare.PetsCareBackendSpringBoot.repositories.EmployeeRepository;
import com.petscare.PetsCareBackendSpringBoot.repositories.MedicalAppointmentRepository;
import com.petscare.PetsCareBackendSpringBoot.repositories.PatientRepository;
import com.petscare.PetsCareBackendSpringBoot.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MedicalAppointmentService {

    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final PatientRepository patientRepository;
    private final EmployeeRepository employeeRepository;
    private final SpecialityRepository specialityRepository;

    @Autowired   //It injects the dependency right away
    public MedicalAppointmentService(MedicalAppointmentRepository medicalAppointmentRepository, PatientRepository patientRepository,
                                     EmployeeRepository employeeRepository,
                                     SpecialityRepository specialityRepository){
        this.medicalAppointmentRepository = medicalAppointmentRepository;
        this.patientRepository = patientRepository;
        this.employeeRepository = employeeRepository;
        this.specialityRepository = specialityRepository;
    }

    public MedicalAppointment addMedicalAppointment(Integer patientId, Integer specialityId, Integer employeeId, MedicalAppointment detailsMedicalAppointment){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new RuntimeException("Patient not found"));
        Speciality speciality = specialityRepository.findById(specialityId)
                .orElseThrow(()-> new RuntimeException("Speciality not found"));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new RuntimeException("Specialist not found"));

        detailsMedicalAppointment.setPatient(patient);
        detailsMedicalAppointment.setSpeciality(speciality);
        detailsMedicalAppointment.setEmployee(employee);
        detailsMedicalAppointment.setState("Scheduled");

        return this.medicalAppointmentRepository.save(detailsMedicalAppointment);
    }


    public MedicalAppointment getMedicalAppointmentById(Integer medicalAppointmentId){
        Optional<MedicalAppointment> optionalValue = this.medicalAppointmentRepository.findById(medicalAppointmentId);
        if(optionalValue.isEmpty()){
            return null;
        }
        return optionalValue.get();
    }

    public List<MedicalAppointment> getMedicalAppointmentsByPatientId(Integer patientId) {
        return this.medicalAppointmentRepository.findByPatientId(patientId);
    }

    public void deleteMedicalAppointmentById(Integer medicalAppointmentId){
        this.medicalAppointmentRepository.deleteById(medicalAppointmentId);
    }


}
