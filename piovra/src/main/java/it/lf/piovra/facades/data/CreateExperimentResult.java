package it.lf.piovra.facades.data;

import it.lf.piovra.views.ExperimentData;

public class CreateExperimentResult {

    private String messageCode;
    private CreateExperimentStatus status;
    private ExperimentData createdExperiment;

    public CreateExperimentResult(CreateExperimentStatus status) {
        this.status = status;
    }

    public CreateExperimentResult(CreateExperimentStatus status, String message) {
        this(status);
        this.messageCode = message;
    }

    public CreateExperimentResult(ExperimentData createdExperiment) {
        this(CreateExperimentStatus.OK);
        this.createdExperiment = createdExperiment;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public CreateExperimentStatus getStatus() {
        return status;
    }

    public void setStatus(CreateExperimentStatus status) {
        this.status = status;
    }

    public ExperimentData getCreatedExperiment() {
        return createdExperiment;
    }

    public void setCreatedExperiment(ExperimentData createdExperiment) {
        this.createdExperiment = createdExperiment;
    }
}
