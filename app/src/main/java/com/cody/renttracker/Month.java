package com.cody.renttracker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Cody Finch
 * Description: The month class resemles a month, and tracks whether or not the month has been
 * paid in full, and the total amount owed for the month. It keeps track a list of bills that
 * are added for the month. The total amount is divied up evenly
 */

public class Month {
    // Class Properties
    private String mID;
    private String mName;
    private boolean mPaid;
    private double mTotalAmount;
    private List<Bill> mBills;

    // Constructor
    // @arg aName = Name of the month
    public Month(String aName){
        mName = aName;
        mPaid = false;
        mTotalAmount = 0.0;
        mBills = new ArrayList<Bill>();
        mID = UUID.randomUUID().toString();
    }

    public String getMonthID(){
        return mID;
    }

    public String getMonthName(){
        return mName;
    }

    public boolean isMonthPaid(){
        return mPaid;
    }

    public double getTotalAmount(){
        return mTotalAmount;
    }

    public List<Bill> getBills(){
        return mBills;
    }

    public void setMonthName(String aName){
        mName = aName;
    }

    public void setPaid(boolean aPaid){
        mPaid = aPaid;
    }

    public void setAmount(double aAmount){
        mTotalAmount = aAmount;
    }

    public void addBill(Bill b){
        mBills.add(b);
    }

    //TODO remove bill functionality
}
