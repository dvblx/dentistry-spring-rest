package ru.dentistry.dentistryrest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "week")
public class Week implements Serializable {
    @Id
    @Column(name = "day_id")
    private int day_id;
    @Column(name = "day_name")
    private String day_name;

    public int getDay_id() {return day_id;}

    public void setDay_id(int day_id) {this.day_id = day_id;}

    public String getDay_name() {return day_name;}

    public void setDay_name(String day_name) {this.day_name = day_name;}
}
