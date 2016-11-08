package it.lf.piovra.views.forms;

import javax.validation.constraints.NotNull;


public class LoginForm {

    @NotNull(message = "{general.required}")
    private String username;
    @NotNull(message = "{general.required}")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
