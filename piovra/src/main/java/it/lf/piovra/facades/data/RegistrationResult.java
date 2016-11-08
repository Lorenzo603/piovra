package it.lf.piovra.facades.data;

public class RegistrationResult {

    private String messageCode;
    private RegistrationResultStatus status;

    public RegistrationResult(RegistrationResultStatus status) {
        this.status = status;
    }

    public RegistrationResult(RegistrationResultStatus status, String message) {
        this(status);
        this.messageCode = message;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }


    public RegistrationResultStatus getStatus() {
        return status;
    }

    public void setStatus(RegistrationResultStatus status) {
        this.status = status;
    }
}
