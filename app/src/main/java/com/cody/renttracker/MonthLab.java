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

public class MonthLab {
    private static MonthLab sMonthLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static TenantLab get(Context context){
        if(sMonthLab == null){
            sMonthLab = new MonthLab(context);
        }
        return sMonthLab;
    }// end get

    private MonthLab(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new RentTrackerBaseHelper(mContext).getWritableDatabase();
    } // end Constructor

    public List<Month> getMonths(){
        List<Month> lMonthList = new ArrayList<>();

        RentDBCursorWrapper cursor = queryTenants();

        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                lMonthList.add(cursor.getMonth());
                cursor.moveToNext();
            }
        } finally{
            cursor.close();
        }
        return lMonthList;
    }// end getTenants

    // SELECT * FROM Tenant
    private RentDBCursorWrapper queryMonths(){
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
