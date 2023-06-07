package ru.dentistry.dentistryrest.service.dto;

import com.fasterxml.jackson.annotation.JsonView;
import ru.dentistry.dentistryrest.service.Views;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class DentistryDTO implements Serializable {
    private int dentistry_id;
    @NotBlank
    @JsonView(Views.DentistryPreview.class)
    private String name;
    @NotBlank
    @JsonView(Views.DentistryDetail.class)
    private String phone;
    @NotBlank
    @JsonView(Views.DentistryDetail.class)
    private String head_of_clinic;
    @NotBlank
    @JsonView(Views.DentistryPreview.class)
    private String address;
    @Min(0)
    @Max(2023)
    @JsonView(Views.DentistryDetail.class)
    private int foundation_year;
    @Min(0)
    @JsonView(Views.DentistryPreview.class)
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
}
