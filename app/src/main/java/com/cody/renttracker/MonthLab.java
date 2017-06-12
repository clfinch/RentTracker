package com.cody.renttracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cody.renttracker.database.RentDBCursorWrapper;
import com.cody.renttracker.database.RentTrackerBaseHelper;
import com.cody.renttracker.database.RentTrackerDBSchema;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodyFinch on 2/22/2017.
 */

public class MonthLab {
    private static final String TAG = "MonthLab";
    private static MonthLab sMonthLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static MonthLab get(Context context){
        Log.i(TAG,"Getting monthlab reference");
        if(sMonthLab == null){
            sMonthLab = new MonthLab(context);
        }
        return sMonthLab;
    }// end get

    private MonthLab(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new RentTrackerBaseHelper(mContext).getWritableDatabase();

    } // end Constructor

    // Queries for active Months and returns a list of Month objects
    public List<Month> getMonths(){
        Log.i(TAG,"Getting Months from DB");
        List<Month> lMonthList = new ArrayList<>();
        // make query to select months
        RentDBCursorWrapper cursor = queryMonths(null,new String[]{""});
        Log.i(TAG,"Finished query");
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                lMonthList.add(cursor.getMonth());
                cursor.moveToNext();
            }
        } finally{
            cursor.close();
        }
        Log.i(TAG,"Closing DB Cursor");
        return lMonthList;
    }// end getTenants


    // Queries DB for month names
    private RentDBCursorWrapper queryMonths(String whereClause, String[] whereArgs){
        Log.i(TAG,"in Querymonths start");
        Cursor cursor = mDatabase.query(RentTrackerDBSchema.MonthTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null);

        return new RentDBCursorWrapper(cursor);
    }
}
