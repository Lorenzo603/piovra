package it.lf.piovra.views.forms;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class RegisterForm {

    @Email(message = "{Email.registerForm.email}")
    @NotBlank(message = "{NotBlank.registerForm.email}")
    private String email;
    @NotBlank(message = "{NotBlank.registerForm.password}")
    private String password;
    @NotBlank(message = "{NotBlank.registerForm.confirmPassword}")
    private String confirmPassword;

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
