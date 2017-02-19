package com.cody.renttracker;

/**
 * @author Cody Finch
 * Description - This is a bill object, created when a user adds a new bill for a month.
 * it has a name and amount associated with it.
 */

public class Bill {
    private String mName;
    private double mAmount;

    // Constructor, Takes in bill name and amount
    public Bill(String aName, double aAmount){
        mName = aName;
        mAmount = aAmount;
    }

    // Member Getter and setters
    private String getName(){
        return mName;
    }

    private double getAmount(){
        return mAmount;
    }

    private void setName(String aName){
        mName = aName;
    }

    private void setAmount(double aAmount){
        mAmount = aAmount;
    }
}
