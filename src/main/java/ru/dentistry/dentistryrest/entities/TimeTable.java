package ru.dentistry.dentistryrest.entities;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "timetable")
public class TimeTable implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "tt_id")
    private int tt_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dentist_id", referencedColumnName ="dentist_id")
    private Dentist dentist;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "day_id")
    private Week day;
    @Column(name = "admission_time")
    private String admission_time;

    public int getTt_id() {
        return tt_id;
    }

    public void setTt_id(int tt_id) {this.tt_id = tt_id;}

    public String getAdmission_time() {return admission_time;}

    public void setAdmission_time(String admission_time) {this.admission_time = admission_time;}


    public Dentist getDentist() {return dentist;}

    public void setDentist(Dentist dentist) {this.dentist = dentist;}

    public Week getDay() {return day;}

    public void setDay(Week day) {this.day = day;}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TimeTable)) {
            return false;
        }
        return tt_id != 0 && tt_id ==((TimeTable) o).tt_id;
    }
}
