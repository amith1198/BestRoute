package com.bestroute.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testOrderCreation() {
        Restaurant restaurant = new Restaurant("R1", new GeoLocation(12.9352, 77.6245), 15.0);
        Consumer consumer = new Consumer("C1", new GeoLocation(12.9200, 77.6100));

        Order order = new Order("O1", restaurant, consumer);

        assertEquals("O1", order.getId());
        assertEquals(restaurant, order.getRestaurant());
        assertEquals(consumer, order.getConsumer());
    }
}