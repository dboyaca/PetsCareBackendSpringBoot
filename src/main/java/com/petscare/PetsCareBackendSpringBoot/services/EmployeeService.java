package com.petscare.PetsCareBackendSpringBoot.services;
import com.petscare.PetsCareBackendSpringBoot.models.Employee;
import com.petscare.PetsCareBackendSpringBoot.models.Speciality;
import com.petscare.PetsCareBackendSpringBoot.repositories.EmployeeRepository;
import com.petscare.PetsCareBackendSpringBoot.repositories.SpecialityRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final SpecialityRepository specialityRepository;

    //We inject the dependency by hand
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, SpecialityRepository specialityRepository){
        this.employeeRepository = employeeRepository;
        this.specialityRepository = specialityRepository;
    }

    @Transactional
    public Employee addSpecialityToEmployee(Integer employeeId, Integer specialityId){
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + employeeId));

        Speciality speciality = specialityRepository.findById(specialityId)
                .orElseThrow(() -> new RuntimeException("Speciality not found with id " + specialityId));

        employee.getSpecialities().add(speciality);

        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee getEmployeeDetails(Integer id){
        Employee emp = employeeRepository.findById(id).orElseThrow();

        int count = emp.getSpecialities().size();

        return emp;
    }

    public List<Employee> getAllEmployeesWithSpecialities(){
        return employeeRepository.findAll();
    }

    public Employee removeSpecialityFromEmployee(Integer employeeId, Integer specialityId) {
        //Find the employee (or fail if he/she is not found)
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // 2. Remove speciality that matches the id from the Set of specialities belonging to the employee
        // This modifies the Java set in memory.
        boolean removed = employee.getSpecialities().removeIf( s -> s.getId_speciality().equals(specialityId));

        // Check if it was actually removed through throwing an exception
        if (!removed) {
            throw new RuntimeException("Speciality not found in this employee's list");
        }

        // ORM (Hibernate) sees the item is gone and deletes the row in the join table.
        return employeeRepository.save(employee);
    }


}
