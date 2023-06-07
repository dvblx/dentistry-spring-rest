package ru.dentistry.dentistryrest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "dentist_type")
public class DentistType implements Serializable {
    @Id
    @Column(name = "type_id")
    private int type_id;
    @Column(name = "type_name")
    private String type_name;

    public int getType_id() {return type_id;}

    public void setType_id(int type_id) {this.type_id = type_id;}

    public String getType_name() {return type_name;}

    public void setType_name(String type_name) {this.type_name = type_name;}
}
