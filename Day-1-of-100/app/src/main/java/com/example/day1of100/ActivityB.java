package com.example.day1of100;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ActivityB extends AppCompatActivity {

    private TextView randomBTextView;
    private Button activityBButton;
    private int mGetIntExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        randomBTextView = findViewById(R.id.txt_random_b);
        activityBButton = findViewById(R.id.btn_activity_b);

        Intent activityAIntent = getIntent();
        if (activityAIntent != null) {
            mGetIntExtra = activityAIntent.getIntExtra(MainActivity.RANDOM_NUMBER_EXTRA, 0);
            randomBTextView.setText(String.valueOf(mGetIntExtra));
        }

        activityBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetIntExtra = new Random().nextInt(100000);
                Intent activityAIntent = new Intent(ActivityB.this, MainActivity.class);
                activityAIntent.putExtra(MainActivity.RANDOM_NUMBER_EXTRA, mGetIntExtra);
                startActivity(activityAIntent);
            }
        });
    }
}
