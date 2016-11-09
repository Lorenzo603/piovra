package it.lf.piovra.views.forms;

import org.hibernate.validator.constraints.NotBlank;


public class RemoveLevelForm {

    @NotBlank
    private String id;
    @NotBlank
    private String factorId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFactorId() {
        return factorId;
    }

    public void setFactorId(String factorId) {
        this.factorId = factorId;
    }

}
