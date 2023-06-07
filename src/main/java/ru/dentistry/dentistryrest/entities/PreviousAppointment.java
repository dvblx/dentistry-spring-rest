package ru.dentistry.dentistryrest.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "previousappointments")
public class PreviousAppointment implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "previous_appointment_id")
    private int previous_appointment_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;
    @Column(name = "appointment_day")
    private Date appointment_day;
    @Column(name = "appointment_time")
    private Time appointment_time;
    @Column(name = "patient")
    private String patient;
    @Column(name = "diagnosis")
    private String diagnosis;
    @Column(name = "admission_price")
    private int admission_price;

    public int getPrevious_appointment_id() {return previous_appointment_id;}

    public void setPrevious_appointment_id(int previous_appointment_id) {this.previous_appointment_id = previous_appointment_id;}

    public Date getAppointment_day() {return appointment_day;}

    public void setAppointment_day(Date appointment_day) {this.appointment_day = appointment_day;}

    public Time getAppointment_time() {return appointment_time;}

    public void setAppointment_time(Time appointment_time) {this.appointment_time = appointment_time;}

    public String getPatient() {return patient;}

    public void setPatient(String patient) {this.patient = patient;}

    public String getDiagnosis() {return diagnosis;}

    public void setDiagnosis(String diagnosis) {this.diagnosis = diagnosis;}

    public int getAdmission_price() {return admission_price;}

    public void setAdmission_price(int admission_price) {this.admission_price = admission_price;}

    public Dentist getDentist() {return dentist;}

    public void setDentist(Dentist dentist) {this.dentist = dentist;}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PreviousAppointment)) {
            return false;
        }
        return previous_appointment_id != 0 && previous_appointment_id ==((PreviousAppointment) o).previous_appointment_id;
    }
}
