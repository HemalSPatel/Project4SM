package com.example.rucafe.project4sm;

/**
 * abstract class of a menu item that has the structure
 * of what is needed in an item
 * @author Hemal Patel, Ishika Patel
 */
public abstract class MenuItem {
    private String itemName;
    private double price;
    private int amount;

    /**
     * Constructor for a menu item object
     * @param itemName
     * @param price
     * @param amount
     */
    public MenuItem(String itemName, double price, int amount) {
        this.itemName = itemName;
        this.price = price;
        this.amount = amount;
    }

    /**
     * getter method for instance variable item name
     * @return string for item name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * getter method for instance variable item price
     * @return price for the object in a double
     */
    public double getPrice() {
        return price;
    }

    /**
     * setter method for instance variable item price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * abstract method for subclasses to calculate item price
     * @return price of the item from the subclass
     */
    public abstract double itemPrice();

    /**
     * returns the amount of items for that certain menu item
     * @return number of duplicates of that menu item
     */
    public int getAmount(){
        return amount;
    }
}
