package com.petscare.PetsCareBackendSpringBoot.models;

//import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="paciente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_paciente")
    private Integer id_patient;

    @Column(name="nombre_paciente", length=100)
    private String name;

    @Column(name="especie_paciente", length=100)
    private String species;

    @Column(name="raza_paciente", length=100)
    private String breed;

    @Column(name="edad")
    private Integer age;

    @Column (name="peso_paciente")
    private Float weight;

    @Column (name="info_adicional", length=500)
    private String additional_info;

    public Patient(String name, String species, String breed, Integer age, Float weight, String additional_info){
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
        this.additional_info = additional_info;
    }

    public Patient () {}

    public Integer getId_patient() {
        return id_patient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getAdditional_info() {
        return additional_info;
    }

    public void setAdditional_info(String additional_info) {
        this.additional_info = additional_info;
    }
}
