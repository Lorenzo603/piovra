package it.lf.piovra.views.forms;

import org.hibernate.validator.constraints.NotBlank;

public class EditLevelForm {

    @NotBlank
    private String id;
    @NotBlank
    private String newName;
    @NotBlank
    private String factorId;
    @NotBlank
    private String experimentId;

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

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }
}
