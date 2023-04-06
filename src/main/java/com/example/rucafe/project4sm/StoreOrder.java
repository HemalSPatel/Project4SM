package com.example.rucafe.project4sm;

import java.util.ArrayList;

/**
 * Store order class creates the structure of a store order instance
 * and contains all the methods to access and manipulate the store order
 * @author Hemal Patel, Ishika Patel
 */
public class StoreOrder {
    private ArrayList<Order> storeOrders= new ArrayList<Order>();

    /**
     * adds the given object to the end of the store order list
     * @param obj
     * @return true if order added and false if not
     */
    public boolean add(Object obj) {
        if(obj instanceof Order){
            Order order = (Order) obj;
            storeOrders.add(order);
            return true;
        }
        return false;
    }

    /**
     * removed the given object from the list of orders
     * @param obj
     * @return true if order removed and false if not
     */
    public boolean remove(Object obj){
        if(obj instanceof Order){
            Order order = (Order) obj;
            storeOrders.remove(order);
            return true;
        }
        return false;
    }

    /**
     * getter method for private instance variable store orders
     * @return array list of all store orders
     */
    public ArrayList<Order> getStoreOrders() {
        return storeOrders;
    }


}

