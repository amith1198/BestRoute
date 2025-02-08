package com.bestroute.model;

public class Order {
    private final String id;
    private final Restaurant restaurant;
    private final Consumer consumer;

    public Order(String id, Restaurant restaurant, Consumer consumer) {
        this.id = id;
        this.restaurant = restaurant;
        this.consumer = consumer;
    }

    public String getId() {
        return id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Consumer getConsumer() {
        return consumer;
    }
}
