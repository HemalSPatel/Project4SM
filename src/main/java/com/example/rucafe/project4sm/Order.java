package com.example.rucafe.project4sm;

import java.util.ArrayList;

public class Order {

    private int orderNumber;
    private ArrayList<MenuItem> order;

    /**
     * constructor for an order object
     *
     * @param
     */
    public Order() {
        order = new ArrayList<MenuItem>();;
    }

    /**
     * appends a menu item to the order list
     * @param item
     */
    public void addItem(MenuItem item) {
        order.add(item);
    }

    /**
     * removes a menu item from the order list
     * @param item
     */
    public void removeItem(MenuItem item) {
        order.remove(item);
    }

    /**
     * calculates the running total for all of the menu items in the order
     * @return total price of items
     */
    public double getOrderTotal() {
        double total = 0.0;
        for (MenuItem item : order) {
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
        return order;
    }



    //--------------------


    public boolean add(Object obj) {
        if(obj instanceof MenuItem){
            MenuItem mi = (MenuItem) obj;
            order.add(mi);
            return true;
        }
        return false;
    }

    public boolean remove(Object obj){
        if(obj instanceof MenuItem){
            MenuItem mi = (MenuItem) obj;
            order.remove(mi);
            return true;
        }
        return false;
    }

    public ArrayList<MenuItem> getOrder() {
        return order;
    }


}
