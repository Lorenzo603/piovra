package it.lf.piovra.views.forms;

import javax.validation.constraints.NotBlank;


public class CreateExperimentForm {

    @NotBlank(message = "{NotBlank.createExperimentForm.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
