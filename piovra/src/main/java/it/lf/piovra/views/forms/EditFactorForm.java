package it.lf.piovra.views.forms;

import javax.validation.constraints.NotBlank;


public class EditFactorForm {

    @NotBlank
    private String id;
    @NotBlank
    private String newName;

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


}
