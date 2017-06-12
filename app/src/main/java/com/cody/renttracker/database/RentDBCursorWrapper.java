package com.cody.renttracker.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.util.Log;

import com.cody.renttracker.Month;
import com.cody.renttracker.Tenant;
import com.cody.renttracker.database.RentTrackerDBSchema.TenantTable;
import com.cody.renttracker.database.RentTrackerDBSchema.MonthTable;
import com.cody.renttracker.database.RentTrackerDBSchema.BillTable;

/**
 * Created by CodyF on 1/25/2017.
 */

public class RentDBCursorWrapper extends CursorWrapper {

    private static final String TAG = "RentDBCursorWrapper";
    public RentDBCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Tenant getTenant(){

        String tenantName = getString(getColumnIndex(TenantTable.Cols.FIRSTNAME));
        //String tenantLastName = getString(getColumnIndex(TenantTable.Cols.LASTNAME));

        Tenant lTenant = new Tenant(tenantName);
        return lTenant;
    }

    public Month getMonth(){
        Log.i(TAG,"DB Wrapper getting month from cursor");
        String monthName = getString(getColumnIndex(MonthTable.Cols.MONTHNAME));
        Month lMonth = new Month(monthName);
        return lMonth;
    }
}
