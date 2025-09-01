package com.petscare.PetsCareBackendSpringBoot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
//We decided tu put users in order to avoid any confusion with the User reserved word for DBMS
//This has a one to one relationship with the Employee class

@Entity
@Table(name="usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_usuario")
    private Integer userId;

    @Column(name="primer_nombre")
    private String firstName;

    @Column(name="segundo_nombre")
    private String secondName;

    @Column(name="primer_apellido")
    private String firstLastName;

    @Column(name="segundo_apellido")
    private String secondLastName;

    @Column(name="dia_registro")
    private LocalDateTime signUpDate;

    @Column(name="ultima_conexion")
    private LocalDateTime lastConnection;

    @Column(name="logueado")
    private Byte online;

    public Users(String firstName, String secondName, String firstLastName, String secondLastName, LocalDateTime signUpDate, LocalDateTime lastConnection, Byte online){
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.signUpDate = signUpDate;
        this.lastConnection = lastConnection;
        this.online = online;
    }

    public Users() {}

    public Integer getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public LocalDateTime getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(LocalDateTime signUpDate) {
        this.signUpDate = signUpDate;
    }

    public LocalDateTime getLastConnection() {
        return lastConnection;
    }

    public void setLastConnection(LocalDateTime lastConnection) {
        this.lastConnection = lastConnection;
    }

    public byte getOnline() {
        return online;
    }

    public void setOnline(Byte online) {
        this.online = online;
    }
}
