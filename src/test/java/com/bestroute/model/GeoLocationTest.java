package com.bestroute.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeoLocationTest {

    @Test
    void testGeoLocation() {
        GeoLocation location = new GeoLocation(12.9716, 77.5946);
        assertEquals(12.9716, location.getLatitude());
        assertEquals(77.5946, location.getLongitude());
    }
}
