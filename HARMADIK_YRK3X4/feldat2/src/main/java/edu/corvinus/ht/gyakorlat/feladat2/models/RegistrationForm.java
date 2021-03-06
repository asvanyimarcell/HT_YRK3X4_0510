package edu.corvinus.ht.gyakorlat.feladat2.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class RegistrationForm {

    @Email
    @Length(min = 3)
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z]{5,}$")
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
