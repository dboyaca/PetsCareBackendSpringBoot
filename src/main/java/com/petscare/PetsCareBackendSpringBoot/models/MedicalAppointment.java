package com.petscare.PetsCareBackendSpringBoot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="consultaagendada")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class MedicalAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_consulta")
    private Integer id_appointment;

    // This is the many side. One patient may have zero or many medical appointment.
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="id_paciente")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="id_especialidad")
    private Speciality speciality;

    @ManyToOne
    @JoinColumn(name="id_especialista")
    private Employee employee;

    @Column(name="hora_inicio")
    private LocalDateTime startHour;

    @Column(name="hora_fin")
    private LocalDateTime finalHour;

    @Column(name="estado_actual")
    private String state;

    public MedicalAppointment() {}

    public MedicalAppointment (Patient patient, Speciality speciality, Employee employee, LocalDateTime startHour, LocalDateTime finalHour, String state){
        this.patient = patient;
        this.speciality = speciality;
        this.employee = employee;
        this.startHour = startHour;
        this.finalHour = finalHour;
        this.state = state;
    }


    public int getId_appointment() {
        return id_appointment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalDateTime startHour) {
        this.startHour = startHour;
    }

    public LocalDateTime getFinalHour() {
        return finalHour;
    }

    public void setFinalHour(LocalDateTime finalHour) {
        this.finalHour = finalHour;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
