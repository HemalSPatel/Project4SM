package com.example.rucafe.project4sm;

import java.util.ArrayList;

/**
 * Coffee class creates the structure of a coffee instance and contains
 * methods to access its information
 * @author Hemal Patel, Ishika Patel
 */
public class Coffee extends MenuItem {
    private String cupSize;
    private ArrayList<String> addIns;

    /**
     * Constructor for a coffee menu item
     * @param cupSize
     * @param amount
     */
    public Coffee(String cupSize, int amount) {
        super(cupSize + " coffee", calculatePrice(cupSize), amount);
        this.cupSize = cupSize;
        this.addIns = new ArrayList<>();
    }

    /**
     * calculates the price of the coffee based on size
     * @param cupSize
     * @return price of coffee
     */
    private static double calculatePrice(String cupSize) {
        switch (cupSize) {
            case "Short":
                return 1.89;
            case "Tall":
                return 2.29;
            case "Grande":
                return 2.69;
            case "Venti":
                return 3.09;
            default:
                return 0.0;
        }
    }

    /**
     * Adds additional add-ins to the arraylist and updates the price of the coffee
     * @param addIn
     */
    public void addAddIn(String addIn) {
        addIns.add(addIn);
        setPrice(getPrice() + 0.3);
    }

    /**
     * overrides the abstract method and returns the price of the item
     * @return price of the menu item
     */
    @Override
    public double itemPrice() {
        return getPrice();
    }

    /**
     * getter method for the private instance variable add-ins
     * @return list of add-ins in that specific coffee
     */
    public ArrayList<String> getAddIns() {
        return addIns;
    }

    /**
     * toString method for a coffee object
     * @return a string of the size, item, amount, and all add-ins
     */
    public String toString(){
        String end = "";
        end += getItemName() + " ";
        if(getAddIns().size() != 0){
            end += "[";
            for(String e : getAddIns()){
                end += e + " ";
            }
            end += "]";
        }
        end += " (" + getAmount() + ")";
        return end;
    }
}

