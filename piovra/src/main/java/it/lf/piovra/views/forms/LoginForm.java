package it.lf.piovra.views.forms;

import org.hibernate.validator.constraints.NotBlank;


public class LoginForm {

    @NotBlank(message = "{NotBlank.loginForm.username}")
    private String username;
    @NotBlank(message = "{NotBlank.loginForm.password}")
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
