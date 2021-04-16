
package com.sanvalero.proweek.domain;

/**
 * Property contains information about the property to be sold, rented or viewed; its location, characteristics and
 * price.
 */
public class Property {
    
    //declare instance variables
    private int propertyId;
    private String type;
    private String street;
    private int size;
    private int rooms;
    private int bathrooms;
    private int parkingSpaces;
    private int storageUnits;
    private String directionFacing;
    private double price;
    private int districtId;
    
    //constructor
    
    public Property() { }
    
    public Property(int propertyId, String type, String street, int size,
            int rooms, int bathrooms, int parkingSpaces, int storageUnits,
            String directionFacing, double price, int districtId) {
        this.propertyId = propertyId;
        this.type = type;
        this.street = street;
        this.size = size;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.parkingSpaces = parkingSpaces;
        this.storageUnits = storageUnits;
        this.directionFacing = directionFacing;
        this.price = price;
        this.districtId = districtId;
    }
    
    //getters and setters

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getParkingSpaces() {
        return parkingSpaces;
    }

    public void setParkingSpaces(int parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public int getStorageUnits() {
        return storageUnits;
    }

    public void setStorageUnits(int storageUnits) {
        this.storageUnits = storageUnits;
    }

    public String getDirectionFacing() {
        return directionFacing;
    }

    public void setDirectionFacing(String directionFacing) {
        this.directionFacing = directionFacing;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }
}
