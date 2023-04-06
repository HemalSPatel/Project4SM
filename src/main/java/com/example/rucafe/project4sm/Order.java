package com.example.rucafe.project4sm;

import java.util.ArrayList;

public class Order {

    private double totalPrice;
    private ArrayList<MenuItem> order;

    /**
     *
     */
    public Order() {
        order = new ArrayList<MenuItem>();
        totalPrice = 0;
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
     *
     * @param price
     */
    public void setTotalPrice(double price){
        this.totalPrice = price;
    }


    /**
     * getter method for all the items in the order
     * @return an array list of all the menu items
     */
    public ArrayList<MenuItem> getItems() {
        return order;
    }

    /**
     *
     * @return
     */
    public double getTotalPrice(){
        return totalPrice;
    }

    /**
     *
     * @param obj
     * @return
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
     *
     * @param obj
     * @return
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
     *
     * @return
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
     *
     * @return
     */
    public ArrayList<MenuItem> getOrder() {
        return order;
    }


}
