package it.lf.piovra.views.forms;

import org.hibernate.validator.constraints.NotBlank;

public class AddFactorForm {

    @NotBlank
    private String experimentId;
    @NotBlank
    private String name;

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
