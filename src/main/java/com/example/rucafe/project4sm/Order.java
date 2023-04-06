package com.example.rucafe.project4sm;

import java.util.ArrayList;

/**
 * order class has the structure of what is needed in an order
 * and contains methods that allow one to change or access information or
 * an order
 * @author Hemal Patel, Ishika Patel
 */
public class Order {

    private double totalPrice;
    private ArrayList<MenuItem> order;

    /**
     * Constructor for an order object
     */
    public Order() {
        order = new ArrayList<MenuItem>();
        totalPrice = 0;
    }

    /**
     * sets the total price of an order from the given numebr
     * @param price
     */
    public void setTotalPrice(double price){
        this.totalPrice = price;
    }

    /**
     * getter method for the private instance variable total price
     * @return double of the price
     */
    public double getTotalPrice(){
        return totalPrice;
    }

    /**
     * adds the given object to the end of the order
     * @param obj
     * @return true if the item was successfully added and false if not
     */
    public boolean add(Object obj) {
        if(obj instanceof MenuItem){
            MenuItem mi = (MenuItem) obj;
            order.add(mi);
            return true;
        }
        return false;
    }

    /**
     * removed the given object from the order list
     * @param obj
     * @return true if the item was successfully removed and false if not
     */
    public boolean remove(Object obj){
        if(obj instanceof MenuItem){
            MenuItem mi = (MenuItem) obj;
            order.remove(mi);
            return true;
        }
        return false;
    }

    /**
     * To string method for an order object
     * @return string containing the order menu items
     */
    public String toString(){
        String endString = "";
        for(int i = 0; i < order.size(); i++){
            endString += order.get(i).toString();
            endString += "\n";
        }
        return endString;
    }

    /**
     * getter method for private instance variable order
     * @return array list of menu items
     */
    public ArrayList<MenuItem> getOrder() {
        return order;
    }


}
