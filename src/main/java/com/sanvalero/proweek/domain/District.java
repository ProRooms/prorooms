
package com.sanvalero.proweek.domain;

/**
 * District contains information about the neighbourhood in which a property is situated.
 */
public class District {
    
    //declare instance variables
    private int districtId;
    private String districtName;
    private double distanceFromCentre;
    private String zone;
    
    //constructor

    public District(int districtId, String districtName, double distanceFromCentre, String zone) {
        this.districtId = districtId;
        this.districtName = districtName;
        this.distanceFromCentre = distanceFromCentre;
        this.zone = zone;
    }
    
    //getters and setters

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public double getDistanceFromCentre() {
        return distanceFromCentre;
    }

    public void setDistanceFromCentre(double distanceFromCentre) {
        this.distanceFromCentre = distanceFromCentre;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

}
