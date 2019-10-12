package com.example.day13of100;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new GetJsonTask().execute();
    }

    private class GetJsonTask extends AsyncTask<Void, Void, List<User>> {

        @Override
        protected List<User> doInBackground(Void... voids) {
            String jsonData;
            try {
                jsonData = NetworkUtils.getJsonFromUrl(NetworkUtils.BASE_URL);
                return JsonUtils.parseJsonFromString(jsonData);
            } catch (Exception e) {
                Log.e("GET_JSON_ERROR", e.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<User> users) {
            UsersAdapter adapter = new UsersAdapter(getBaseContext(), users);
            ListView lvUsers = findViewById(R.id.list_users);
            lvUsers.setAdapter(adapter);

            lvUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    User user = (User) parent.getItemAtPosition(position);
                    Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                    intent.putExtra("EXTRA_USER", user.getObjToJson());
                    startActivity(intent);
                }
            });
        }
    }
}
