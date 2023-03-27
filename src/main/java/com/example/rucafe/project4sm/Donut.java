package com.example.rucafe.project4sm;

public class Donut extends MenuItem {
    private String type;
    private String flavor;

    public Donut(String type, String flavor) {
        super(flavor + " " + type + " donut", calculatePrice(type));
        this.type = type;
        this.flavor = flavor;
    }

    private static double calculatePrice(String type) {
        switch (type) {
            case "yeast":
                return 1.59;
            case "cake":
                return 1.79;
            case "hole":
                return 0.39;
            default:
                return 0.0;
        }
    }

    @Override
    public double itemPrice() {
        return getPrice();
    }

    public String getType() {
        return type;
    }

    public String getFlavor() {
        return flavor;
    }
}
