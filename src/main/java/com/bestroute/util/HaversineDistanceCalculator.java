package com.bestroute.util;

import com.bestroute.model.GeoLocation;

public class HaversineDistanceCalculator implements DistanceCalculator {
    private static final double EARTH_RADIUS_KM = 6371.0;
    private static final double AVERAGE_SPEED_KMH = 20.0;

    private double toRadians(double degree) {
        return degree * Math.PI / 180.0;
    }

    @Override
    public double haversineDistance(GeoLocation loc1, GeoLocation loc2) {
        double lat1 = toRadians(loc1.getLatitude());
        double lon1 = toRadians(loc1.getLongitude());
        double lat2 = toRadians(loc2.getLatitude());
        double lon2 = toRadians(loc2.getLongitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c;
    }

    @Override
    public double travelTime(GeoLocation loc1, GeoLocation loc2) {
        return haversineDistance(loc1, loc2) / AVERAGE_SPEED_KMH;
    }
}

