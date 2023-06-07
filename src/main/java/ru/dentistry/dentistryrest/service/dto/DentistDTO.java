package ru.dentistry.dentistryrest.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import ru.dentistry.dentistryrest.service.Views;

import javax.validation.constraints.Min;
import java.io.Serializable;

public class DentistDTO implements Serializable {
    private int dentist_id;

    @JsonView(Views.DentistPreview.class)
    private String dentist_name;

    @JsonView(Views.DentistryPreview.class)
    @JsonIgnoreProperties(value = { "dentistry_id", "head_of_clinic", "foundation_year", "customer_count" }, allowSetters = true)
    private DentistryDTO dentistry;
    @Min(0)
    @JsonView(Views.DentistPreview.class)
    private int experience;
    @JsonView(Views.DentistPreview.class)
    @JsonIgnoreProperties(value = { "type_id" }, allowSetters = true)
    private DentistTypeDTO dentist_type;

    public int getDentist_id() {return dentist_id;}

    public void setDentist_id(int dentist_id) {this.dentist_id = dentist_id;}

    public String getDentist_name() {return dentist_name;}

    public void setDentist_name(String dentist_name) {this.dentist_name = dentist_name;}

    public int getExperience() {return experience;}

    public void setExperience(int experience) {this.experience = experience;}

    public DentistryDTO getDentistry() {return dentistry;}

    public void setDentistry(DentistryDTO dentistry) {this.dentistry = dentistry;}

    public DentistTypeDTO getDentist_type() {return dentist_type;}

    public void setDentist_type(DentistTypeDTO dentist_type) {this.dentist_type = dentist_type;}

}
