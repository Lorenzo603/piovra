package it.lf.piovra.views.forms;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Lorenzo on 20/05/2016.
 */
public class EditLevelForm {

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
