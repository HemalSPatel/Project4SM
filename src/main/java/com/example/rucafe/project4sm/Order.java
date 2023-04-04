package com.example.rucafe.project4sm;

import java.util.ArrayList;

public class Order {

    private int orderNumber;
    private ArrayList<MenuItem> items;

    /**
     * constructor for an order object
     * @param orderNumber
     */
    public Order(int orderNumber, ArrayList<MenuItem> item) {
        this.orderNumber = orderNumber;
        this.items = item;
    }

    /**
     * appends a menu item to the order list
     * @param item
     */
    public void addItem(MenuItem item) {
        items.add(item);
    }

    /**
     * removes a menu item from the order list
     * @param item
     */
    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    /**
     * calculates the running total for all of the menu items in the order
     * @return total price of items
     */
    public double getOrderTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.itemPrice();
        }
        return total;
    }

    /**
     * getter method for the private instance variable order number
     * @return order number
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * getter method for all the items in the order
     * @return an array list of all the menu items
     */
    public ArrayList<MenuItem> getItems() {
        return items;
    }

}
