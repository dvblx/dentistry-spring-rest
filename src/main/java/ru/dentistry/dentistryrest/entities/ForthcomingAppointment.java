package ru.dentistry.dentistryrest.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "appointments")
public class ForthcomingAppointment implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "appointment_id")
    private int appointment_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;
    @Column(name = "appointment_day")
    private Date appointment_day;
    @Column(name = "appointment_time")
    private Time appointment_time;
    @Column(name = "patient")
    private String patient;

    public Date getAppointment_day() {return appointment_day;}

    public void setAppointment_day(Date appointment_day) {this.appointment_day = appointment_day;}

    public Time getAppointment_time() {return appointment_time;}

    public void setAppointment_time(Time appointment_time) {this.appointment_time = appointment_time;}

    public String getPatient() {return patient;}

    public void setPatient(String patient) {this.patient = patient;}

    public int getAppointment_id() {return appointment_id;}

    public void setAppointment_id(int appointment_id) {this.appointment_id = appointment_id;}

    public Dentist getDentist() {return dentist;}

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ForthcomingAppointment)) {
            return false;
        }
        return appointment_id != 0 && appointment_id ==((ForthcomingAppointment) o).appointment_id;
    }
}
