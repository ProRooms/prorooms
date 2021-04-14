package com.sanvalero.proweek.domain;

import java.time.LocalDateTime;

/**
 * Purchase contains information about a property purchased by a customer.
 */
public class Purchase extends Action {

    //constructor
    public Purchase(int id, LocalDateTime startDate, int propertyId, int userId) {
        super(id, startDate, propertyId, userId);
    }  
    
}