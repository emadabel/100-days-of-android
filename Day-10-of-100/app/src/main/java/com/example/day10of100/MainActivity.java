package com.example.day10of100;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day10of100.data.UsersContract;

import static com.example.day10of100.data.UsersContract.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button mButtonAddUser = findViewById(R.id.button_add_user);
        Button mButtonShowUsers = findViewById(R.id.button_show_users);

        mButtonAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText mEditName = findViewById(R.id.edit_name);

                String input = mEditName.getText().toString();
                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "The name should not be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }

                ContentValues contentValues = new ContentValues();
                contentValues.put(UsersEntry.COLUMN_NAME, input);

                Uri uri = getContentResolver().insert(UsersEntry.CONTENT_URI, contentValues);

                if (uri != null) {
                    Toast.makeText(MainActivity.this, "Successfully added a new name.", Toast.LENGTH_SHORT).show();
                    mEditName.setText("");
                }
            }
        });

        mButtonShowUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mTextUsers = findViewById(R.id.text_users);

                Cursor cursor;

                try {
                    cursor = getContentResolver().query(UsersEntry.CONTENT_URI,
                            null,
                            null,
                            null,
                            null);
                } catch (Exception e) {
                    Log.e("DATA_ERROR", "Faild to load data.");
                    return;
                }

                if (cursor != null && cursor.moveToFirst()) {
                    StringBuilder strBuilder = new StringBuilder();
                    while (!cursor.isAfterLast()){
                        strBuilder.append("\n" + cursor.getString(cursor.getColumnIndex(UsersEntry.COLUMN_ID)) + "- " + cursor.getString((cursor.getColumnIndex(UsersEntry.COLUMN_NAME))));
                        cursor.moveToNext();
                    }
                    mTextUsers.setText(strBuilder);
                } else {
                    mTextUsers.setText("No records found");
                }
            }
        });
    }
}
