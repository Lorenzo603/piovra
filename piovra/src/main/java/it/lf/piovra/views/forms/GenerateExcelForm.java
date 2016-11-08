package it.lf.piovra.views.forms;


import org.hibernate.validator.constraints.NotBlank;

public class GenerateExcelForm {

    @NotBlank
    private String experimentId;

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }
}
