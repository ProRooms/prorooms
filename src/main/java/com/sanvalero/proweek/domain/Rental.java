package com.sanvalero.proweek.domain;

import java.time.LocalDate;

/**
 * Rental contains information about a property rented by a customer.
 */
public class Rental extends Action {
    
    //declare instance variables
    private LocalDate endDate;

    //constructor

    public Rental(LocalDate endDate, int id, LocalDate startDate, int propertyId, int userId) {
        super(id, startDate, propertyId, userId);
        this.endDate = endDate;
    }

    
    //getters and setters

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    } 
}
