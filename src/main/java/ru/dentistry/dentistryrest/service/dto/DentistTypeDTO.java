package ru.dentistry.dentistryrest.service.dto;

import com.fasterxml.jackson.annotation.JsonView;
import ru.dentistry.dentistryrest.service.Views;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class DentistTypeDTO implements Serializable {
    private int type_id;
    @NotBlank
    @JsonView(Views.DentistPreview.class)
    private String type_name;

    public int getType_id() {return type_id;}

    public void setType_id(int type_id) {this.type_id = type_id;}

    public String getType_name() {return type_name;}

    public void setType_name(String type_name) {this.type_name = type_name;}
}
