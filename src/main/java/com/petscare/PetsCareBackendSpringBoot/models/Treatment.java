package com.petscare.PetsCareBackendSpringBoot.models;

import jakarta.persistence.*;

@Entity
@Table(name="tratamiento")
public class Treatment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_tratamiento")
    private Integer id_treatment;

    @Column(name="nombre_tratamiento", length=100)
    private String treatment_name;

    @Column(name="descripcion", length = 500)
    private String description;

    @Column(name="precio")
    private Float price;

    public Treatment(String treatment_name, String description, Float price){
        this.treatment_name = treatment_name;
        this.description = description;
        this.price = price;
    }

    public Treatment() {}

    public Integer getId_treatment() {
        return id_treatment;
    }

    public void setId_treatment(Integer id_treatment) {
        this.id_treatment = id_treatment;
    }

    public String getTreatment_name() {
        return treatment_name;
    }

    public void setTreatment_name(String treatment_name) {
        this.treatment_name = treatment_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
