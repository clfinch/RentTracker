package com.cody.renttracker;

import java.util.UUID;

/**
 * Created by CodyF on 1/23/2017.
 */

public class Tenant {
    private String mID;
    private String mName;

    // Constructor creates a tenant for the household
    public Tenant(String aName){
        mName = aName;
        mID = UUID.randomUUID().toString();
    }

    // Member getter's and setters
    private String getName(){
        return mName;
    }
    private String getTenantID(){return mID;}

    private void setFirstName(String aName){
        mName = aName;
    }


}
