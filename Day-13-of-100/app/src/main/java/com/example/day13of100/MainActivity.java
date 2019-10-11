package com.example.day13of100;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new GetJsonTask().execute();
    }

    private class GetJsonTask extends AsyncTask<Void, Void, User> {

        @Override
        protected User doInBackground(Void... voids) {
            String jsonData;
            try {
                jsonData = NetworkUtils.getJsonFromUrl(NetworkUtils.BASE_URL);
                List<User> userList = JsonUtils.parseJsonFromString(jsonData);
            } catch (Exception e) {
                Log.e("GET_JSON_ERROR", e.getMessage());
            }
            return null;
        }
    }
}
