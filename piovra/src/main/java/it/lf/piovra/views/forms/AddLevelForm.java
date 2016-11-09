package it.lf.piovra.views.forms;

import org.hibernate.validator.constraints.NotBlank;


public class AddLevelForm {

    @NotBlank
    private String name;
    @NotBlank
    private String factorId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactorId() {
        return factorId;
    }

    public void setFactorId(String factorId) {
        this.factorId = factorId;
    }

}
