package com.example.day12of100;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.MyListItemOnClickHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListData[] data = new MyListData[] {
                new MyListData(android.R.drawable.ic_dialog_email, "Email"),
                new MyListData(android.R.drawable.ic_dialog_info, "Info"),
                new MyListData(android.R.drawable.ic_delete, "Delete"),
                new MyListData(android.R.drawable.ic_dialog_dialer, "Dialer"),
                new MyListData(android.R.drawable.ic_dialog_alert, "Alert"),
                new MyListData(android.R.drawable.ic_dialog_map, "Map"),
                new MyListData(android.R.drawable.ic_dialog_email, "Email"),
                new MyListData(android.R.drawable.ic_dialog_info, "Info"),
                new MyListData(android.R.drawable.ic_delete, "Delete"),
                new MyListData(android.R.drawable.ic_dialog_dialer, "Dialer"),
                new MyListData(android.R.drawable.ic_dialog_alert, "Alert"),
                new MyListData(android.R.drawable.ic_dialog_map, "Map")
        };

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerAdapter adapter = new RecyclerAdapter(this, data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(String description) {
        Toast.makeText(this, "Click on item: " + description, Toast.LENGTH_SHORT).show();
    }
}
