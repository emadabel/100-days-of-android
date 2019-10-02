package com.example.day5of100;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        radioGroup = findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        textView.setText("You have selected the first RadioButton");
                        break;
                    case R.id.radioButton2:
                        textView.setText("You have selected the second RadioButton");
                        break;
                    case R.id.radioButton3:
                        textView.setText("You have selected the third RadioButton");
                        break;
                    case R.id.radioButton4:
                        textView.setText("You have selected the fourth RadioButton");
                        break;
                }
            }
        });
    }
}
