package com.bestroute.model;

public class Restaurant {
    private final String id;
    private final GeoLocation location;
    private final double preparationTime; // in minutes

    public Restaurant(String id, GeoLocation location, double preparationTime) {
        this.id = id;
        this.location = location;
        this.preparationTime = preparationTime;
    }

    public String getId() {
        return id;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public double getPreparationTime() {
        return preparationTime;
    }
}

