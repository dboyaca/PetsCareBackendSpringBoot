package com.petscare.PetsCareBackendSpringBoot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="empleado")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Employee {

    //@OneToOne(mappedBy= "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name="id_empleado", unique = true)
    //private Users user;

    @Id
    @Column(name="id_empleado")
    private Integer idEmployee;

    @OneToOne
    @MapsId                     //use the same value that users.id
    @JoinColumn(name="id_empleado")
    private Users user;

    @Column(name="fecha_inicio")
    private LocalDateTime startDate;

    @Column(name="salario")
    private Float salary;

    public Employee() {}

    public Employee(LocalDateTime startDate, Float salary){
        this.startDate = startDate;
        this.salary = salary;
    }


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }
}
