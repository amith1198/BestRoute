package com.bestroute.service;

import com.bestroute.model.*;
import com.bestroute.util.DistanceCalculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DeliveryOptimizer {

    private final DistanceCalculator distanceCalculator;

    public DeliveryOptimizer(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    public double calculateOptimizedDeliveryTime(GeoLocation start, List<Order> orders) {
        if (orders.isEmpty()) return 0;

        List<Restaurant> restaurants = new ArrayList<>();
        for (Order order : orders) {
            restaurants.add(order.getRestaurant());
        }

        restaurants.sort(Comparator.comparingDouble(r ->
                Math.max(distanceCalculator.travelTime(start, r.getLocation()), r.getPreparationTime())
        ));

        double currentTime = 0;
        GeoLocation currLocation = start;

        for (Restaurant restaurant : restaurants) {
            double travelTime = distanceCalculator.travelTime(currLocation, restaurant.getLocation());
            currentTime += travelTime;
            currentTime = Math.max(currentTime, restaurant.getPreparationTime());
            currLocation = restaurant.getLocation();
        }

        List<Consumer> consumers = new ArrayList<>();
        for (Order order : orders) {
            consumers.add(order.getConsumer());
        }

        final GeoLocation lastLocation = currLocation;

        consumers.sort(Comparator.comparingDouble(c ->
                distanceCalculator.travelTime(lastLocation, c.getLocation())
        ));

        for (Consumer consumer : consumers) {
            currentTime += distanceCalculator.travelTime(currLocation, consumer.getLocation());
            currLocation = consumer.getLocation();
        }

        return currentTime;
    }
}
