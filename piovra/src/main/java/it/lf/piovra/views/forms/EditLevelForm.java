package it.lf.piovra.views.forms;

import javax.validation.constraints.NotBlank;


public class EditLevelForm {

    @NotBlank
    private String id;
    @NotBlank
    private String newName;
    @NotBlank
    private String factorId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getFactorId() {
        return factorId;
    }

    public void setFactorId(String factorId) {
        this.factorId = factorId;
    }

}
