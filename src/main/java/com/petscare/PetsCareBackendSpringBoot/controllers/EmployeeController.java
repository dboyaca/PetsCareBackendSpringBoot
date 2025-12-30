package com.petscare.PetsCareBackendSpringBoot.controllers;

import com.petscare.PetsCareBackendSpringBoot.models.Employee;
import com.petscare.PetsCareBackendSpringBoot.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    //Injecting the dependecies right away

    @Autowired
    public EmployeeController (EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employeeById/{eId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(name="eId") Integer employeeId ){
        Employee employee = employeeService.getEmployeeDetails(employeeId);

        return ResponseEntity.ok(employee);
    }

    @GetMapping("/EmployeesSpecialities/all")
    public List<Employee> allEmployeesSpecialities(){
        return this.employeeService.getAllEmployeesWithSpecialities();
    }

    @PostMapping("/addSpecialities/{empId}/{specId}")
    public ResponseEntity<Employee> assignSpeciality(
            @PathVariable(name="empId") Integer empId,
            @PathVariable(name="specId") Integer specId) {

        Employee updatedEmployee = employeeService.addSpecialityToEmployee(empId, specId);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/removeSpeciality/{empId}/{specId}")
    public Employee removeSpeciality(@PathVariable Integer empId, @PathVariable Integer specId){
        Employee updatedEmployee = employeeService.removeSpecialityFromEmployee(empId, specId);

        return updatedEmployee;
    }


}
