package edu.corvinus.ht.gyakorlat.feladat2.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private boolean readTermsAndConditions = false;


    public User() { }

    public User(String email) {
        this.email = email;
    }

    public User(long id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isReadTermsAndConditions() {
        return readTermsAndConditions;
    }

    public void setReadTermsAndConditions(boolean readTermsAndConditions) {
        this.readTermsAndConditions = readTermsAndConditions;
    }

}
