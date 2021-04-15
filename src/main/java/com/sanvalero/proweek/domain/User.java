package com.sanvalero.proweek.domain;

/**
 * User class contains details of registered customers using the application.
 */
public class User {
    
    //declare the instance variables
    private int userId;
    private String name;
    private String surname;
    private String email;
    private String telephone;
    
    //constructors
    public User() {}

    public User(String name, String surname, String email, String telephone) {
        this.name = name;
        this.surname = surname;
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
