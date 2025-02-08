package com.bestroute.util;

import com.bestroute.model.GeoLocation;

public interface DistanceCalculator {
    double haversineDistance(GeoLocation loc1, GeoLocation loc2);
    double travelTime(GeoLocation loc1, GeoLocation loc2);
}