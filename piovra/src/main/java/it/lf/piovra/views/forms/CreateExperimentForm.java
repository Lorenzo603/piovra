package it.lf.piovra.views.forms;

import org.hibernate.validator.constraints.NotBlank;

public class CreateExperimentForm {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
