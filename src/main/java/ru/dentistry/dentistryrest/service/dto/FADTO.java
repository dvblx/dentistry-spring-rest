package ru.dentistry.dentistryrest.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.dentistry.dentistryrest.entities.Dentist;
import ru.dentistry.dentistryrest.entities.Dentistry;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class FADTO implements Serializable {
    private int appointment_id;
    private DentistDTO dentist;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date appointment_day;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Time appointment_time;
    @NotBlank
    private String patient;

    public int getId() {return appointment_id;}

    public void setId(int id) {this.appointment_id = id;}

    public Date getAppointment_day() {return appointment_day;}

    public void setAppointment_day(Date appointment_day) {this.appointment_day = appointment_day;}

    public Time getAppointment_time() {return appointment_time;}

    public void setAppointment_time(Time appointment_time) {this.appointment_time = appointment_time;}

    public String getPatient() {return patient;}

    public void setPatient(String patient) {this.patient = patient;}

    public int getAppointment_id() {return appointment_id;}

    public void setAppointment_id(int appointment_id) {this.appointment_id = appointment_id;}

    public DentistDTO getDentist() {return dentist;}

    public void setDentist(DentistDTO dentist) {
        this.dentist = dentist;
    }
}
