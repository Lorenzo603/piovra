package it.lf.piovra.views.forms;

import org.hibernate.validator.constraints.NotBlank;

public class EditFactorForm {

    @NotBlank
    private String experimentId;
    @NotBlank
    private String id;
    @NotBlank
    private String newName;

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }

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
