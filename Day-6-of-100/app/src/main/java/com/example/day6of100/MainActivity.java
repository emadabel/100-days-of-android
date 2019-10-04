package com.example.day6of100;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String strBuilder;
    int checked = 0;

    private CheckBox checkBoxOne;
    private CheckBox checkBoxTwo;
    private CheckBox checkBoxThree;
    private CheckBox checkBoxFour;
    private TextView textViewDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxOne = findViewById(R.id.check_box_one);
        checkBoxTwo = findViewById(R.id.check_box_two);
        checkBoxThree = findViewById(R.id.check_box_three);
        checkBoxFour = findViewById(R.id.check_box_four);

        textViewDisplay = findViewById(R.id.text_view_display);

        Button buttonCheck = findViewById(R.id.button_check);

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxOne.isChecked()) {
                    checked = checked | 1;
                } else {
                    checked = checked & ~1;
                }

                if (checkBoxTwo.isChecked()) {
                    checked = checked | 2;
                } else {
                    checked = checked & ~2;
                }

                if (checkBoxThree.isChecked()) {
                    checked = checked | 4;
                } else {
                    checked = checked & ~4;
                }

                if (checkBoxFour.isChecked()) {
                    checked = checked | 8;
                } else {
                    checked = checked & ~8;
                }

                strBuilder = "";

                if ((checked & 1) != 0) {
                    strBuilder = strBuilder + "Check one";
                }

                if ((checked & 2) != 0) {
                    if (!strBuilder.isEmpty()) {
                        strBuilder = strBuilder + " and ";
                    }
                    strBuilder = strBuilder + "Check two";
                }

                if ((checked & 4) != 0) {
                    if (!strBuilder.isEmpty()) {
                        strBuilder = strBuilder + " and ";
                    }
                    strBuilder = strBuilder + "Check three";
                }

                if ((checked & 8) != 0) {
                    if (!strBuilder.isEmpty()) {
                        strBuilder = strBuilder + " and ";
                    }
                    strBuilder = strBuilder + "Check four";
                }

                if (strBuilder.isEmpty()) {
                    strBuilder = "No Checkbox";
                }

                textViewDisplay.setText(strBuilder.concat(" selected"));
            }
        });
    }
}
