package com.example.day2of100;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_EMAIL = "extra_email";
    public static final String EXTRA_PASSWORD = "extra_password";

    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextEmail = findViewById(R.id.edit_text_email);
        mEditTextPassword = findViewById(R.id.edit_text_password);
        mButtonLogin = findViewById(R.id.button_login);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    Intent intentActivityB = new Intent(MainActivity.this, ActivityB.class);
                    intentActivityB.putExtra(EXTRA_EMAIL, mEditTextEmail.getText().toString());
                    intentActivityB.putExtra(EXTRA_PASSWORD, mEditTextPassword.getText().toString());
                    startActivity(intentActivityB);
                }
            }
        });
    }

    private boolean validate() {
        String email = mEditTextEmail.getText().toString();
        String password = mEditTextPassword.getText().toString();
        boolean valid = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEditTextEmail.setError("enter a valid email address");
            valid = false;
        } else {
            mEditTextEmail.setError(null);
        }

        if (password.isEmpty()) {
            mEditTextPassword.setError("password can not be empty");
            valid = false;
        } else {
            mEditTextPassword.setError(null);
        }

        return valid;
    }
}
