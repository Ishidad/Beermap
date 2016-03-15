package com.mfpv.beermap.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mfpv.beermap.data.PlacesContract.LocationEntry;

public class PlacesDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "places.db";

    public PlacesDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_PLACES_TABLE = "CREATE TABLE " + LocationEntry.TABLE_NAME + " (" +
                LocationEntry._ID + " INTEGER PRIMARY KEY," +
                LocationEntry.COLUMN_PLACE_ID + " TEXT UNIQUE NOT NULL, " +
                LocationEntry.COLUMN_PLACE_NAME + " TEXT NOT NULL );";

        sqLiteDatabase.execSQL(SQL_CREATE_PLACES_TABLE);
    }

    public static Cursor getInformation(SQLiteDatabase db){
        String[] proyections = {LocationEntry.COLUMN_PLACE_NAME, LocationEntry.COLUMN_PLACE_ID};
        Cursor cursor = db.query(LocationEntry.TABLE_NAME,proyections,null,null,null,null,null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + LocationEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
