package com.bestroute;

import com.bestroute.model.Consumer;
import com.bestroute.model.GeoLocation;
import com.bestroute.model.Order;
import com.bestroute.model.Restaurant;
import com.bestroute.service.DeliveryOptimizer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GeoLocation driverStart = new GeoLocation(12.9352, 77.6245);

        Restaurant restaurant1 = new Restaurant("R1", new GeoLocation(12.9716, 77.5946), 15); // 15 min prep
        Restaurant restaurant2 = new Restaurant("R2", new GeoLocation(12.9260, 77.6762), 10); // 10 min prep

        Consumer consumer1 = new Consumer("C1", new GeoLocation(12.9784, 77.6408));
        Consumer consumer2 = new Consumer("C2", new GeoLocation(12.9141, 77.6481));

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("O1", restaurant1, consumer1));
        orders.add(new Order("O2", restaurant2, consumer2));

        double optimizedTime = DeliveryOptimizer.calculateOptimizedDeliveryTime(driverStart, orders);

        System.out.println("Optimized Delivery Time: " + optimizedTime + " minutes");
    }
}