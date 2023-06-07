package ru.dentistry.dentistryrest.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.dentistry.dentistryrest.entities.Dentist;
import ru.dentistry.dentistryrest.entities.Dentistry;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class PADTO implements Serializable {
    private int previous_appointment_id;
    private Dentist dentist;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date appointment_day;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Time appointment_time;
    private String patient;
    private String diagnosis;
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
}
