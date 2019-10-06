package com.example.day9of100;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.day9of100.data.SpinnerDbHelper;

import java.util.ArrayList;
import java.util.List;

import static com.example.day9of100.data.SpinnerContract.SpinnerEntry;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);

        SpinnerDbHelper dbHelper = new SpinnerDbHelper(this);
        mDb = dbHelper.getReadableDatabase();

        List<String> foods = getFoods();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, foods);
        spinner.setAdapter(adapter);
    }

    private List<String> getFoods() {
        List<String> list = new ArrayList<>();

        Cursor cursor = mDb.query(SpinnerEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
                );

        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(cursor.getColumnIndex(SpinnerEntry.COLUMN_FOOD_NAME)));
            } while (cursor.moveToNext());
        }

        cursor.close();
        mDb.close();

        return list;
    }
}
