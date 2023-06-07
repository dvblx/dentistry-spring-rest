package ru.dentistry.dentistryrest.entities;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "dentist")
public class Dentist implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "dentist_id")
    private int dentist_id;
    @Column(name = "dentist_name")
    private String dentist_name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dentistry_id")
    private Dentistry dentistry;
    @Column(name = "experience")
    private int experience;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dentist_type_id")
    private DentistType dentist_type;

    public int getDentist_id() {return dentist_id;}

    public void setDentist_id(int dentist_id) {this.dentist_id = dentist_id;}

    public String getDentist_name() {return dentist_name;}

    public void setDentist_name(String dentist_name) {this.dentist_name = dentist_name;}

    public int getExperience() {return experience;}

    public void setExperience(int experience) {this.experience = experience;}

    public Dentistry getDentistry() {return dentistry;}

    public void setDentistry(Dentistry dentistry) {this.dentistry = dentistry;}

    public DentistType getDentist_type() {return dentist_type;}

    public void setDentist_type(DentistType dentist_type) {this.dentist_type = dentist_type;}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Dentist)) {
            return false;
        }
        return dentist_id != 0 && dentist_id ==((Dentist) o).dentist_id;
    }
}
