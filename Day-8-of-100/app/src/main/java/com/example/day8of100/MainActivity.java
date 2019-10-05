package com.example.day8of100;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String USER_NAME_KEY = "user_name_key";
    public static final String PASSWORD_KEY = "password_key";

    private final String mDefaultUsername = "Richard";
    private final String mDefaultPassword = "qwerty";

    private EditText mEditUsername;
    private EditText mEditPassword;
    private Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveUserData();

        mEditUsername = findViewById(R.id.edit_username);
        mEditPassword = findViewById(R.id.edit_password);
        mButtonLogin = findViewById(R.id.button_login);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                String username = prefs.getString(USER_NAME_KEY, "No name defined");
                String password = prefs.getString(PASSWORD_KEY, "");

                if (TextUtils.isEmpty(mEditUsername.getText()) || TextUtils.isEmpty(mEditPassword.getText())) {
                    Toast.makeText(MainActivity.this, "You have to complete the empty fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (!username.contentEquals(mEditUsername.getText())) {
                        Toast.makeText(MainActivity.this, "This user does not exist!", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!password.contentEquals(mEditPassword.getText())) {
                            Toast.makeText(MainActivity.this, "You have entered an incorrect password!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Welcome...", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, ActivityB.class);
                            intent.putExtra(USER_NAME_KEY, mEditUsername.getText().toString());
                            startActivity(intent);
                            mEditUsername.setText("");
                            mEditPassword.setText("");
                        }
                    }
                }
            }
        });
    }

    private void saveUserData() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(USER_NAME_KEY, mDefaultUsername);
        editor.putString(PASSWORD_KEY, mDefaultPassword);
        editor.apply();
    }
}
