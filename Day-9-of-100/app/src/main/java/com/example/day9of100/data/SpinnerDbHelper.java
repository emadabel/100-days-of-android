package com.example.day9of100.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.day9of100.data.SpinnerContract.SpinnerEntry;

public class SpinnerDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "spinner_database";

    private static final int DATABASE_VERSION = 1;

    public SpinnerDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATED_SPINNER_DATA_TABLE = "CREATE TABLE " +
                SpinnerEntry.TABLE_NAME + " (" +
                SpinnerEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                SpinnerEntry.COLUMN_FOOD_NAME + " TEXT NOT NULL" +
                ");";

        sqLiteDatabase.execSQL(SQL_CREATED_SPINNER_DATA_TABLE);
        FoodData.insertFoodData(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SpinnerEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
