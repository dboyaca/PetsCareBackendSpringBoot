package com.petscare.PetsCareBackendSpringBoot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

import java.util.Set;
import java.util.HashSet;


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
    @MapsId                     //use the same value that users.id. This is the linkage
    @JoinColumn(name="id_empleado")
    private Users user;

    @Column(name="fecha_inicio")
    private LocalDateTime startDate;

    @Column(name="salario")
    private Float salary;

    /***
     * The following commands relates the creation of the many to many relationship belonging to
     * the Employee and speciality service.
     * By this mean, the employee carries information about its speciality in this model
     */
    @ManyToMany(fetch = FetchType.LAZY) //
    @JoinTable(
            name = "especialidadempleado",
            joinColumns = @JoinColumn(name = "id_empleado"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad")
    )

    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    public Employee() {}

    public Employee(Users user, LocalDateTime startDate, Float salary){
        this.user     = user;
        this.startDate = startDate;
        this.salary = salary;
    }


    public Users getUser() {
        return user;
    }

    public void setId_Employee(Integer id){
        this.user.setUserId(id);
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

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }
}
