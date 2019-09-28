package com.example.day1of100;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String RANDOM_NUMBER_EXTRA = "random_number_extra";

    final int random = new Random().nextInt(100000);

    private TextView randomATextView;
    private Button activityAButton;
    private int mGetIntExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomATextView = findViewById(R.id.txt_random_a);
        activityAButton = findViewById(R.id.btn_activity_a);

        Intent activityBIntent = getIntent();
        if (activityBIntent != null) {
            mGetIntExtra = activityBIntent.getIntExtra(MainActivity.RANDOM_NUMBER_EXTRA, random);
            randomATextView.setText(String.valueOf(mGetIntExtra));
        } else {
            randomATextView.setText(String.valueOf(random));
        }

        activityAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityBIntent = new Intent(MainActivity.this, ActivityB.class);
                activityBIntent.putExtra(RANDOM_NUMBER_EXTRA, Integer.valueOf(randomATextView.getText().toString()));
                startActivity(activityBIntent);
            }
        });
    }
}
