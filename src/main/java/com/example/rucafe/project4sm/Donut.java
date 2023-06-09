package com.example.rucafe.project4sm;

/**
 * Donut class creates instances of donuts and allows method
 * to access information about a donut
 * @author Hemal Patel, Ishika Patel
 */
public class Donut extends MenuItem {
    private String type;
    private String flavor;

    /**
     * Constructor for a donut object
     * @param type
     * @param flavor
     * @param amount
     */
    public Donut(String type, String flavor, int amount) {
        super(flavor + " " + type + " donut", calculatePrice(type), amount);
        this.type = type;
        this.flavor = flavor;
    }


    /**
     * calculates the price for the donut depending on its type
     * @param type
     * @return price of type of donut
     */
    private static double calculatePrice(String type) {
        switch (type) {
            case "Yeast":
                return 1.59;
            case "Cake":
                return 1.79;
            case "Donut Holes":
                return 0.39;
            default:
                return 0.0;
        }
    }

    /**
     * overrides the abstract method to return the price of the donut
     * @return price of donut
     */
    @Override
    public double itemPrice() {
        return getPrice();
    }

    /**
     * getter method for the type of donut
     * @return string for the type of donut
     */
    public String getType() {
        return type;
    }

    /**
     * getter method for the donut flavor
     * @return the flavor of the donut
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * to String method for a donut object
     * @return string of the item name, flavor, and the amount of the donut
     */
    public String toString(){
        return getItemName() + " (" + getAmount() + ")";
    }
}
