package com.example.rucafe.project4sm;

public abstract class MenuItem {
    private String itemName;
    private double price;
    private int amount;

    /**
     *
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

    /**
     *
     * @return
     */
    public int getAmount(){
        return amount;
    }
}
