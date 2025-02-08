package com.bestroute.util;

import com.bestroute.model.GeoLocation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

    @Test
    void testHaversineDistance() {
        GeoLocation loc1 = new GeoLocation(12.9716, 77.5946);
        GeoLocation loc2 = new GeoLocation(12.9352, 77.6245);

        double distance = DistanceCalculator.haversineDistance(loc1, loc2);
        assertTrue(distance > 0);
    }

    @Test
    void testTravelTime() {
        GeoLocation loc1 = new GeoLocation(12.9716, 77.5946);
        GeoLocation loc2 = new GeoLocation(12.9352, 77.6245);

        double time = DistanceCalculator.travelTime(loc1, loc2);
        assertTrue(time > 0);
    }
}