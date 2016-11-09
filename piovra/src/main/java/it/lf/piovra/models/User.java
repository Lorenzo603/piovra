package it.lf.piovra.models;


import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String email;
    private String encodedPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

}
