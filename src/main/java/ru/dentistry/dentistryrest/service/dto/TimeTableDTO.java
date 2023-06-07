package ru.dentistry.dentistryrest.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.dentistry.dentistryrest.entities.Dentist;
import ru.dentistry.dentistryrest.entities.Dentistry;
import ru.dentistry.dentistryrest.entities.Week;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class TimeTableDTO implements Serializable {
    private int tt_id;
    private DentistDTO dentist;
    @JsonIgnoreProperties(value = { "day_id" }, allowSetters = true)
    private Week day;
    private String admission_time;

    public int getTt_id() {
        return tt_id;
    }

    public void setTt_id(int tt_id) {this.tt_id = tt_id;}

    public String getAdmission_time() {return admission_time;}

    public void setAdmission_time(String admission_time) {this.admission_time = admission_time;}

    public DentistDTO getDentist() {return dentist;}

    public void setDentist(DentistDTO dentist) {this.dentist = dentist;}

    public Week getDay() {return day;}

    public void setDay(Week day) {this.day = day;}
}
