package com.example.rucafe.project4sm;

public abstract class MenuItem {
    private String itemName;
    private double price;

    /**
     * Constructor for a menu item
     * @param itemName
     * @param price
     */
    public MenuItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    /**
     * getter method for instance variable item name
     * @return string for item name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * setter method for instance variable item name
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
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
}
