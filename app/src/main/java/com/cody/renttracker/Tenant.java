package com.cody.renttracker;

/**
 * Created by CodyF on 1/23/2017.
 */

public class Tenant {
    private String mName;

    // Constructor creates a tenant for the household
    public Tenant(String aName){
        mName = aName;
    }

    // Member getter's and setters
    private String getName(){
        return mName;
    }

    private void setName(String aName){
        mName = aName;
    }

}
