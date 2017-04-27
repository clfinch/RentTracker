package com.cody.renttracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cody.renttracker.database.RentDBCursorWrapper;
import com.cody.renttracker.database.RentTrackerBaseHelper;
import com.cody.renttracker.database.RentTrackerDBSchema;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodyFinch on 2/22/2017.
 */

public class TenantLab {
    private static TenantLab sTenantLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static TenantLab get(Context context){
        if(sTenantLab == null){
            sTenantLab = new TenantLab(context);
        }
        return sTenantLab;
    }// end get

    private TenantLab(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new RentTrackerBaseHelper(mContext).getWritableDatabase();
    } // end Constructor

    public List<Tenant> getTenants(){
        List<Tenant> lTenantList = new ArrayList<>();

        RentDBCursorWrapper cursor = queryTenants();

        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                lTenantList.add(cursor.getTenant());
                cursor.moveToNext();
            }
        } finally{
            cursor.close();
        }
        return lTenantList;
    }// end getTenants

    // SELECT * FROM Tenant
    private RentDBCursorWrapper queryTenants(){
        Cursor cursor = mDatabase.query(RentTrackerDBSchema.TenantTable.NAME,
                null,
                null,
                null,
                null,
                null,
                null);

        return new RentDBCursorWrapper(cursor);
    }
}
