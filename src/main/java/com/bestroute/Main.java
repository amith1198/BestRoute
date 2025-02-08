package com.bestroute;

import com.bestroute.model.Consumer;
import com.bestroute.model.GeoLocation;
import com.bestroute.model.Order;
import com.bestroute.model.Restaurant;
import com.bestroute.service.DeliveryOptimizer;

public class Main {
    public static void main(String[] args) {
        GeoLocation startLocation = new GeoLocation(12.9716, 77.5946);
        Restaurant restaurant1 = new Restaurant("R1", new GeoLocation(12.9352, 77.6245), 15);
        Restaurant restaurant2 = new Restaurant("R2", new GeoLocation(12.9600, 77.6100), 20);
        Consumer consumer1 = new Consumer("C1", new GeoLocation(12.9200, 77.6100));
        Consumer consumer2 = new Consumer("C2", new GeoLocation(12.9900, 77.6400));

        Order order1 = new Order("O1", restaurant1, consumer1);
        Order order2 = new Order("O2", restaurant2, consumer2);

        double deliveryTime = DeliveryOptimizer.calculateDeliveryTime(startLocation, order1, order2);
        System.out.println("Optimized Delivery Time: " + deliveryTime + " minutes");
    }
}
