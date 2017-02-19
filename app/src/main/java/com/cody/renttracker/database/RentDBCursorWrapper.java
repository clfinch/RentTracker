package com.cody.renttracker.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.cody.renttracker.Tenant;
import com.cody.renttracker.database.RentTrackerDBSchema.TenantTable;
import com.cody.renttracker.database.RentTrackerDBSchema.MonthTable;
import com.cody.renttracker.database.RentTrackerDBSchema.BillTable;
/**
 * Created by CodyF on 1/25/2017.
 */

public class RentDBCursorWrapper extends CursorWrapper {

    public RentDBCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Tenant getTenant(){
        String tenantName = getString(getColumnIndex(TenantTable.Cols.TENANTNAME));
        int isPaid = getInt(getColumnIndex(TenantTable.Cols.PAID));

        Tenant lTenant = new Tenant(tenantName);

    }
}
