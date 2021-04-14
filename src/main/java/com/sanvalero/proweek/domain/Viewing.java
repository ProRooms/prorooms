package com.sanvalero.proweek.domain;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Viewing contains information about an appointment to view a property made by a customer.
 */
public class Viewing extends Action {
    
    //declare instance variables
    private LocalTime time;

    //constructor

    public Viewing(LocalTime time, int id, LocalDate startDate, int propertyId, int userId) {
        super(id, startDate, propertyId, userId);
        this.time = time;
    }
    
    //getters and setters

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

}
