package com.example.rucafe.project4sm;

import java.util.ArrayList;

public class Coffee extends MenuItem {
    private String cupSize;
    private ArrayList<String> addIns;

    /**
     *
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
     * Adds additional adsd ins to the arraylist and updates the price of the coffee
     * @param addIn
     */
    public void addAddIn(String addIn) {
        addIns.add(addIn);
        setPrice(getPrice() + 0.3);
    }

    /**
     * overrides the abstract method and returns the price of the item
     * @return
     */
    @Override
    public double itemPrice() {
        return getPrice();
    }

    /**
     * getter method for private instance variable cub size
     * @return the cup size
     */
    public String getCupSize() {
        return cupSize;
    }

    /**
     * getter method for the private instance variable add-ins
     * @return list of add-ins in that specific coffee
     */
    public ArrayList<String> getAddIns() {
        return addIns;
    }

    /**
     *
     * @return
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

