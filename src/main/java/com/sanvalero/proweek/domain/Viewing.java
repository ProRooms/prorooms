package com.sanvalero.proweek.domain;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Viewing contains information about an appointment to view a property made by a customer.
 */
public class Viewing extends Action {

    //contsructor
    public Viewing() {}
    
    public Viewing(int id, LocalDate startDate, int propertyId, int userId) {
        super(id, startDate, propertyId, userId);
    }
}
