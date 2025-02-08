package com.bestroute.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConsumerTest {

    @Test
    void testConsumerCreation() {
        GeoLocation loc = new GeoLocation(12.9200, 77.6100);
        Consumer consumer = new Consumer("C1", loc);

        assertEquals("C1", consumer.getId());
        assertEquals(loc, consumer.getLocation());
    }
}