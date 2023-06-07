package ru.dentistry.dentistryrest.entities;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "dentistry")
public class Dentistry implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "dentistry_id")
    private int dentistry_id;
    @Column(name = "dentistry_name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "head_of_clinic")
    private String head_of_clinic;
    @Column(name = "address")
    private String address;
    @Column(name = "foundation_year")
    private int foundation_year;
    @Column(name = "customer_count")
    private int customer_count;

    public int getDentistry_id() {return dentistry_id;}

    public void setDentistry_id(int dentistry_id) {this.dentistry_id = dentistry_id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getHead_of_clinic() {return head_of_clinic;}

    public void setHead_of_clinic(String head_of_clinic) {this.head_of_clinic = head_of_clinic;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public int getFoundation_year() {return foundation_year;}

    public void setFoundation_year(int foundation_year) {this.foundation_year = foundation_year;}

    public int getCustomer_count() {return customer_count;}

    public void setCustomer_count(int customer_count) {this.customer_count = customer_count;}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Dentistry)) {
            return false;
        }
        return dentistry_id != 0 && dentistry_id ==((Dentistry) o).dentistry_id;
    }
}
