package com.petscare.PetsCareBackendSpringBoot.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import javax.annotation.processing.Generated;

@Entity
@Table(name="tratamientopaciente")
public class TreatmentPatient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_tratamiento_paciente")
    private Integer id_treatment_patient;

    @ManyToOne
    @JoinColumn(name="id_paciente")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="id_tratamiento")
    private Treatment treatment;

    @Column(name="inicio")
    private LocalDateTime startDate;

    @Column(name="final")
    private LocalDateTime endDate;

    @Column(name="frecuencia_hora")
    private Integer frequencyHours; //e.g. every 2 hours

    @Column(name="cantidad")
    private Integer quantity;

    @Column(name="observaciones")
    private String observations;

    public TreatmentPatient(){}

    public TreatmentPatient(Patient patient, Treatment treatment, LocalDateTime startDate, LocalDateTime endDate, Integer frequencyHours, Integer quantity, String observations){
        this.patient = patient;
        this.treatment = treatment;
        this.startDate = startDate;
        this.endDate = endDate;
        this.frequencyHours = frequencyHours;
        this.quantity = quantity;
        this.observations = observations;
    }

    public Integer getId_treatment_patient() {
        return id_treatment_patient;
    }

    public void setId_treatment_patient(Integer id_treatment_patient) {
        this.id_treatment_patient = id_treatment_patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getFrequencyHours() {
        return frequencyHours;
    }

    public void setFrequencyHours(Integer frequencyHours) {
        this.frequencyHours = frequencyHours;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
