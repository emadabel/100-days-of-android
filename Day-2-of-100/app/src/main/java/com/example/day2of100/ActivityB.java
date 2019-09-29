package com.example.day2of100;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    private TextView mTextViewEmail;
    private TextView mTextViewPassword;
    String mGetExtraEmail;
    String mGetExtraPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        mTextViewEmail = findViewById(R.id.text_view_email);
        mTextViewPassword = findViewById(R.id.text_view_password);

        Intent intentActivityB = getIntent();
        if (intentActivityB != null) {
            mGetExtraEmail = intentActivityB.getStringExtra(MainActivity.EXTRA_EMAIL);
            mGetExtraPassword = intentActivityB.getStringExtra(MainActivity.EXTRA_PASSWORD);
            mTextViewEmail.setText(mGetExtraEmail);
            mTextViewPassword.setText(mGetExtraPassword);
        }
    }
}
