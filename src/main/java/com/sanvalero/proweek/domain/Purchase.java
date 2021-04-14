package com.sanvalero.proweek.domain;

import java.time.LocalDate;

/**
 * Purchase contains information about a property purchased by a customer.
 */
public class Purchase extends Action {

    //constructor
    public Purchase(int id, LocalDate startDate, int propertyId, int userId) {
        super(id, startDate, propertyId, userId);
    }  
    
}