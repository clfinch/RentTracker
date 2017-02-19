package com.cody.renttracker.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.cody.renttracker.database.RentTrackerDBSchema.TenantTable;
import com.cody.renttracker.database.RentTrackerDBSchema.MonthTable;
import com.cody.renttracker.database.RentTrackerDBSchema.BillTable;
/**
 * Created by CodyF on 1/25/2017.
 */

public class RentTrackerBaseHelper extends SQLiteOpenHelper{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "rentTracker.db";

    public RentTrackerBaseHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }// end constructor

    @Override
    public void onCreate(SQLiteDatabase db){
        // Create Tenant Table
        db.execSQL("create table "+ TenantTable.NAME + "("+
            TenantTable.Cols.TENANTNAME + ", " +
            TenantTable.Cols.PAID + ", " +
            TenantTable.Cols.MONTHNAME + ")");

        db.execSQL("create table "+MonthTable.NAME + "("+
            MonthTable.Cols.MONTHNAME + ", "+
            MonthTable.Cols.AMOUNT + ")");

        db.execSQL("create table "+BillTable.NAME + "("+
            BillTable.Cols.BILLNAME + ", "+
            BillTable.Cols.AMOUNT + ", "+
            BillTable.Cols.MONTHNAME + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // do nothing
    }
}

