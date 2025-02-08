package com.bestroute.model;

public class Consumer {
    private final String id;
    private final GeoLocation location;

    public Consumer(String id, GeoLocation location) {
        this.id = id;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public GeoLocation getLocation() {
        return location;
    }
}
