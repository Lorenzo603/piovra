package it.lf.piovra.views.forms;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Lfurrer on 17/05/2016.
 */
public class AddFactorForm {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
