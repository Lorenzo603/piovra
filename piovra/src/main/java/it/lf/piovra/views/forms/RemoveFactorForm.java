package it.lf.piovra.views.forms;


import javax.validation.constraints.NotBlank;


public class RemoveFactorForm {

    @NotBlank
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
