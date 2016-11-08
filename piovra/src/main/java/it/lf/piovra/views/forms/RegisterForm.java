package it.lf.piovra.views.forms;


import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

public class RegisterForm {

    @NotNull(message = "{general.required}")
    @Email
    private String email;
    @NotNull(message = "{general.required}")
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
