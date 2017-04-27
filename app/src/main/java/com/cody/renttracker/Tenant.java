package com.cody.renttracker;

import java.util.UUID;

/**
 * Created by CodyF on 1/23/2017.
 */

public class Tenant {
    private String mID;
    private String mFirstName;
    private String mLastName;

    // Constructor creates a tenant for the household
    public Tenant(String aFirstName, String aLastName){
        mFirstName = aFirstName;
        mLastName = aLastName;
        mID = UUID.randomUUID().toString();
    }

    // Member getter's and setters
    private String getName(){
        return mFirstName + " " + mLastName;
    }
    private String getTenantID(){return mID;}

    private void setFirstName(String aName){
        mFirstName = aName;
    }
    private void setLastName(String aName) { mLastName = aName; }

}
