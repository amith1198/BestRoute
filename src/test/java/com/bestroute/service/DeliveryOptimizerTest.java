package com.bestroute.service;

import com.bestroute.model.*;
import com.bestroute.util.DistanceCalculator;
import com.bestroute.util.HaversineDistanceCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

class DeliveryOptimizerTest {

    @Test
    void testCalculateOptimizedDeliveryTime() {
        GeoLocation start = new GeoLocation(12.9716, 77.5946);
        Restaurant r1 = new Restaurant("R1", new GeoLocation(12.9352, 77.6245), 15.0);
        Restaurant r2 = new Restaurant("R2", new GeoLocation(12.9600, 77.6100), 20.0);
        Restaurant r3 = new Restaurant("R3", new GeoLocation(12.9200, 77.5800), 10.0);
        Consumer c1 = new Consumer("C1", new GeoLocation(12.9900, 77.6400));
        Consumer c2 = new Consumer("C2", new GeoLocation(12.8000, 77.6700));
        Consumer c3 = new Consumer("C3", new GeoLocation(12.9100, 77.6000));

        List<Order> orders = Arrays.asList(
                new Order("O1", r1, c1),
                new Order("O2", r2, c2),
                new Order("O3", r3, c3)
        );

        DistanceCalculator distanceCalculator = new HaversineDistanceCalculator();
        DeliveryOptimizer deliveryOptimizer = new DeliveryOptimizer(distanceCalculator);

        double deliveryTime = deliveryOptimizer.calculateOptimizedDeliveryTime(start, orders);
        assertEquals(21.447375788324173, deliveryTime);
    }
}