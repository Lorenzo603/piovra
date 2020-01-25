package it.lf.piovra.views.forms;

import javax.validation.constraints.NotBlank;


public class AddFactorForm {

    @NotBlank
    private String name;
    @NotBlank
    private String experimentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getExperimentId()
    {
        return experimentId;
    }

    public void setExperimentId(final String experimentId)
    {
        this.experimentId = experimentId;
    }
}
