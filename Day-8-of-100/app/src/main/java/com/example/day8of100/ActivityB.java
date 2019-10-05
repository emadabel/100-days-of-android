package com.example.day8of100;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        final TextView textUsername = findViewById(R.id.text_username);
        Button buttonLogout = findViewById(R.id.button_logout);

        Intent intent= getIntent();
        if (intent != null) {
            String username = intent.getStringExtra(MainActivity.USER_NAME_KEY);
            textUsername.setText(username);
        }

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textUsername.setText("");
                finish();
            }
        });
    }
}
