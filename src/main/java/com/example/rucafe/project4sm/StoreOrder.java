package com.example.rucafe.project4sm;

import java.util.ArrayList;


public class StoreOrder {
    private ArrayList<Order> storeOrders= new ArrayList<Order>();


    public boolean add(Object obj) {
        if(obj instanceof Order){
            Order order = (Order) obj;
            storeOrders.add(order);
            return true;
        }
        return false;
    }

    public boolean remove(Object obj){
        if(obj instanceof Order){
            Order order = (Order) obj;
            storeOrders.remove(order);
            return true;
        }
        return false;
    }

    public ArrayList<Order> getStoreOrders() {
        return storeOrders;
    }


}

