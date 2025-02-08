package com.bestroute.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    @Test
    void testRestaurantCreation() {
        GeoLocation loc = new GeoLocation(12.9352, 77.6245);
        Restaurant restaurant = new Restaurant("R1", loc, 15.0);

        assertEquals("R1", restaurant.getId());
        assertEquals(loc, restaurant.getLocation());
        assertEquals(15.0, restaurant.getPreparationTime());
    }
}