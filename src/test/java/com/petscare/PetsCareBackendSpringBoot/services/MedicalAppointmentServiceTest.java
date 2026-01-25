package com.petscare.PetsCareBackendSpringBoot.services;

import com.petscare.PetsCareBackendSpringBoot.models.*;
import com.petscare.PetsCareBackendSpringBoot.repositories.*;

// Now, we are going to import JUnit and Mockito to perform the tests
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

//The following ones are to import assertEquals easily
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MedicalAppointmentServiceTest {

    //Through @Mock, we are going to call or instantiate the repositories that the service uses
    //Con @Mock, llamamos los repositorios que usamos, los inyectamos a la clase de prueba
    @Mock
    private PatientRepository patientRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private SpecialityRepository specialityRepository;

    @Mock
    private MedicalAppointmentRepository medicalAppointmentRepository;

    //@InjectMocks creates the instance of the service or class we'd like to test
    //Se crea una instancia de la clase que queremos testear
    @InjectMocks
    private MedicalAppointmentService medicalAppointmentService;

    @Test
    void addMedicalAppointment_EverythingValid(){
        Integer patientId = 1;
        Integer specialityId = 5;
        Integer employeeId = 10;

        Users mockUser = new Users();
        mockUser.setUserId(employeeId);

        Patient mockPatient = new Patient();
        mockPatient.setId_patient(patientId);

        Speciality mockSpeciality = new Speciality();
        mockSpeciality.setId_speciality(specialityId);

        Employee mockEmployee =  new Employee();

        mockEmployee.setUser(mockUser);

        MedicalAppointment inputAppointment = new MedicalAppointment();


        //Here we tell the test what to do when an action on the repositories is performed.
        //Basically, it will return the objects we've just created above.
        when(patientRepository.findById(patientId)).thenReturn(Optional.of(mockPatient));
        when(specialityRepository.findById(specialityId)).thenReturn(Optional.of(mockSpeciality));
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(mockEmployee));

        //When we finally create the Medical Appointment, we tell it what to do next, that is
        //return the created object

        //Se guarda la cita medica y se le indica que luego devuelva el objeto creado
        when(medicalAppointmentRepository.save(any(MedicalAppointment.class))).thenAnswer(i -> i.getArguments()[0]);

        //--------------------
        // RUNNING THE TEST
        //--------------------

        MedicalAppointment result = medicalAppointmentService.addMedicalAppointment(
                patientId, specialityId, employeeId, inputAppointment
        );

        //-----------------
        //  EVALUATE
        //-----------------

        //First, check that the result is not null
        //Revisamos que no nos de el resultado nulo
        assertNotNull(result);

        //Next, let us check whether we obtain the bussiness logic or not
        //Verificamos que ,efectivamente, se ha creado la cita medica
        assertEquals(mockPatient, result.getPatient() );
        assertEquals(mockEmployee, result.getEmployee() );

        //Next, we verify that the method to save the response was called once
        //Verificamos que el metodo para guardar la cita médica se llamo una vez
        verify(medicalAppointmentRepository, times(1)).save(any(MedicalAppointment.class));

    }



}
