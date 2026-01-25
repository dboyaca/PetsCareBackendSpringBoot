package com.petscare.PetsCareBackendSpringBoot.services;

// Now, we are going to import JUnit and Mockito to perform the tests
// Se importan las librerias necesarias para llevar a cabo las pruebas
import com.petscare.PetsCareBackendSpringBoot.models.Speciality;
import com.petscare.PetsCareBackendSpringBoot.repositories.SpecialityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//The following ones are to import assertEquals easily
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SpecialityServiceTest {

    //Inyectamos el repositorio del cual hace uso el servicio
    @Mock
    private SpecialityRepository specialityRepository;

    //Inyectamos el servicio a testar
    @InjectMocks
    private SpecialityService specialityService;

    //Next, we proceed with the test
    //Procedemos con el test
    @Test
    void getAllSpecialitiesTest(){

        //Creamos los objetos a almacenar
        Speciality s1 = new Speciality();
        s1.setId_speciality(101);
        s1.setName("Cardiology");

        Speciality s2 = new Speciality();
        s1.setId_speciality(102);
        s1.setName("Surgery");

        List<Speciality> mockList = Arrays.asList(s1,s2);

        when(specialityRepository.findAll()).thenReturn(mockList);

        //---------------------
        //    RUN THE TEST
        //---------------------

        List<Speciality> result = specialityService.allSpecialities();

        //----------------------
        // EVALUATE THE RESULTS
        //----------------------

        //Verificamos que el retorno no sea nulo
        assertNotNull(result);
        //Verificamos que el tamaño sí sea 2
        assertEquals(2, result.size());
        //Verificamos que la primera entrada sea Cardiologia
        assertEquals("Surgery", result.get(0).getName());

        //Verificamos que sólo se haya ejecutado una vez
        verify(specialityRepository, times(1)).findAll();
    }



}
