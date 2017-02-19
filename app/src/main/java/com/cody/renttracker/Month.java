package com.cody.renttracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cody Finch
 * Description: The month class resemles a month, and tracks whether or not the month has been
 * paid in full, and the total amount owed for the month. It keeps track a list of bills that
 * are added for the month. The total amount is divied up evenly
 */

public class Month {
    // Class Properties
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
    }
}
