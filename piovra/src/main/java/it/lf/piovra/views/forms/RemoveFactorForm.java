package it.lf.piovra.views.forms;

import org.hibernate.validator.constraints.NotBlank;


public class RemoveFactorForm {

    @NotBlank
    private String experimentId;
    @NotBlank
    private String id;

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


}
