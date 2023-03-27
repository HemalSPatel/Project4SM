package com.example.rucafe.project4sm;

import java.util.ArrayList;

public class Coffee extends MenuItem {
    private String cupSize;
    private ArrayList<String> addIns;

    public Coffee(String cupSize) {
        super(cupSize + " coffee", calculatePrice(cupSize));
        this.cupSize = cupSize;
        this.addIns = new ArrayList<>();
    }

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

    public void addAddIn(String addIn) {
        addIns.add(addIn);
        setPrice(getPrice() + 0.3);
    }

    @Override
    public double itemPrice() {
        return getPrice();
    }

    public String getCupSize() {
        return cupSize;
    }

    public ArrayList<String> getAddIns() {
        return addIns;
    }
}

