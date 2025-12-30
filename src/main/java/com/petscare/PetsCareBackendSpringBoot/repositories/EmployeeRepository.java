package com.petscare.PetsCareBackendSpringBoot.repositories;
import com.petscare.PetsCareBackendSpringBoot.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //Since LAZY fetching method was selected, we need an exception for
    //querying efficiently all the Employees with their respective specialities.
    //This is mainly for retrieving the data from employees and specialities all at once,
    //when employee is required

    @EntityGraph(attributePaths = {"specialities", "user"})
    List<Employee> findAll();

}
