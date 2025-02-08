package com.bestroute.service;

import com.bestroute.model.*;
import com.bestroute.util.DistanceCalculator;

public class DeliveryOptimizer {

    public static double calculateDeliveryTime(GeoLocation start, Order order1, Order order2) {
        double travelToR1 = DistanceCalculator.travelTime(start, order1.getRestaurant().getLocation());
        double travelToR2 = DistanceCalculator.travelTime(start, order2.getRestaurant().getLocation());

        double prepTime1 = order1.getRestaurant().getPreparationTime();
        double prepTime2 = order2.getRestaurant().getPreparationTime();

        // Choose optimal pickup order
        boolean pickR1First = (Math.max(travelToR1, prepTime1) <= Math.max(travelToR2, prepTime2));
        Order firstOrder = pickR1First ? order1 : order2;
        Order secondOrder = pickR1First ? order2 : order1;

        double pickupTimeFirst = Math.max(DistanceCalculator.travelTime(start, firstOrder.getRestaurant().getLocation()), firstOrder.getRestaurant().getPreparationTime());
        double pickupTimeSecond = Math.max(DistanceCalculator.travelTime(firstOrder.getRestaurant().getLocation(), secondOrder.getRestaurant().getLocation()), secondOrder.getRestaurant().getPreparationTime());

        double deliveryTime1 = DistanceCalculator.travelTime(firstOrder.getRestaurant().getLocation(), firstOrder.getConsumer().getLocation());
        double deliveryTime2 = DistanceCalculator.travelTime(secondOrder.getRestaurant().getLocation(), secondOrder.getConsumer().getLocation());

        return pickupTimeFirst + pickupTimeSecond + deliveryTime1 + deliveryTime2;
    }
}
