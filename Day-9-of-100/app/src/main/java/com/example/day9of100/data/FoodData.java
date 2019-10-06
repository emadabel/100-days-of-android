package com.example.day9of100.data;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.day9of100.data.SpinnerContract.SpinnerEntry;

import java.util.ArrayList;
import java.util.List;

public class FoodData {

    private static String[] foodNames = new String[]{
            "Pizza",
            "Salad",
            "Soup",
            "Rice with Sauce",
            "Noodles",
            "Baked Potato",
            "Bulgar"
    };

    public static void insertFoodData(SQLiteDatabase db) {
        if (db == null) {
            return;
        }

        List<ContentValues> list = new ArrayList<>();

        ContentValues cv;

        for (String food:foodNames) {
            cv = new ContentValues();
            cv.put(SpinnerEntry.COLUMN_FOOD_NAME, food);
            list.add(cv);
        }

        try {
            db.beginTransaction();
            db.delete(SpinnerEntry.TABLE_NAME, null, null);
            for (ContentValues c:list) {
                db.insert(SpinnerEntry.TABLE_NAME, null, c);
            }
            db.setTransactionSuccessful();
        }
        catch (SQLException e) {
            Log.d("DB TRANSACTION ERROR", e.getMessage());
        }
        finally {
            db.endTransaction();
        }
    }
}
