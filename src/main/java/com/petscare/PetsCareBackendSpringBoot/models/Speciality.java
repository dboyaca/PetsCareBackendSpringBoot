package com.petscare.PetsCareBackendSpringBoot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

/***
 * This library guarantees that it does not exists duplicates in the table
 */
import java.util.Set;


@Entity
@Table(name="especialidad")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_especialidad")
    private Integer id_speciality;

    @Column(name="nombre_especialidad", length=100)
    private String name;

    @Column(name="costo_hora")
    private Float charge_per_hour;

    @OneToOne(mappedBy = "speciality", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    private MedicalAppointment medicalAppointment;

    @ManyToMany(mappedBy = "specialities",fetch= FetchType.LAZY)
    private Set<Employee> employees;

    public Speciality(String name, Float charge_per_hour){
        this.name = name;
        this.charge_per_hour = charge_per_hour;
    }

    public Speciality() {}

    public Integer getId_speciality() {
        return id_speciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCharge_per_hour() {
        return charge_per_hour;
    }

    public void setCharge_per_hour(Float charge_per_hour) {
        this.charge_per_hour = charge_per_hour;
    }
}
