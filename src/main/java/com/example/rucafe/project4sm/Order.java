package com.example.rucafe.project4sm;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<MenuItem> items;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public double getOrderTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.itemPrice();
        }
        return total;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }
}
