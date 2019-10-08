package com.example.day10of100.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.day10of100.data.UsersContract.UsersEntry;

public class UsersDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UsersDb.db";

    private static final int DATABASE_VERSION = 1;

    public UsersDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_TABLE = "CREATE TABLE " +
                UsersEntry.TABLE_NAME + " (" +
                UsersEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                UsersEntry.COLUMN_NAME + " TEXT NOT NULL);";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UsersEntry.TABLE_NAME);
        onCreate(db);
    }
}
