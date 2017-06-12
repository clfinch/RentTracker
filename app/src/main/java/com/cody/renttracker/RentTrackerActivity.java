package com.cody.renttracker;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
/*
@Author Cody Finch
Purpose: This is the starting activity, it launches a fragment of the main hub page.
 */
public class RentTrackerActivity extends SingleFragmentActivity {


    protected Fragment createFragment(){
        return new HomeFragment();
    }// End Constructor
}// end RentTrackerActivity
