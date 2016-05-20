package it.lf.piovra.views.forms;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Lorenzo on 20/05/2016.
 */
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
