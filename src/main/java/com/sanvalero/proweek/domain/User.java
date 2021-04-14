package com.sanvalero.proweek.domain;

import java.time.LocalDate;

/**
 * User class contains details of registered customers using the application.
 */
public class User {
    
    //declare the instance variables
    private int userId;
    private String name;
    private String surname;
    private LocalDate dob;
    private String email;
    private String telephone;
    
    //constructor

    public User(int userId, String name, String surname, LocalDate dob, String email, String telephone) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.email = email;
        this.telephone = telephone;
    }
    
    //getters and setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
