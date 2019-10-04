package com.example.day7of100;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean visiblity = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = findViewById(R.id.imageView);
        final Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visiblity = !visiblity;
                imageView.setVisibility(visiblity ? View.VISIBLE : View.INVISIBLE);
                button.setText(visiblity ? "Hide Image" : "Show Image");
            }
        });
    }
}
