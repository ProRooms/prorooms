package com.sanvalero.proweek.domain;

import java.time.LocalDate;


/**
 * Action class creates a template for the possible transactions that can be made by a customer: purchase, rental, or
 * viewing.
 */
public class Action {
    
    //declare instance variables
    private int id;
    private LocalDate startDate;
    private int propertyId;
    private int userId;

    //constructor
    public Action() {}
    
    public Action(int id, LocalDate startDate, int propertyId, int userId) {
        this.id = id;
        this.startDate = startDate;
        this.propertyId = propertyId;
        this.userId = userId;
    }
    
    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
