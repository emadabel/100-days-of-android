package com.example.day13of100;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView tvName, tvUsername, tvEmail, tvAddress, tvPhone, tvWebsite, tvCompany;

        Intent intent = getIntent();
        if (intent != null) {
            String str = String.format("[%s]", intent.getStringExtra("EXTRA_USER"));
            User user = JsonUtils.parseJsonFromString(str).get(0);
            tvName = findViewById(R.id.details_text_name);
            tvUsername = findViewById(R.id.details_text_username);
            tvEmail = findViewById(R.id.details_text_email);
            tvAddress = findViewById(R.id.details_text_address);
            tvPhone = findViewById(R.id.details_text_phone);
            tvWebsite = findViewById(R.id.details_text_website);
            tvCompany = findViewById(R.id.details_text_company);

            tvName.setText(user.getName());
            tvUsername.setText(user.getUsername());
            tvEmail.setText(user.getEmail());
            String formatAddress = String.format("%1$s,\n%2$s,\n%3$s.\nZipcode: %4$s\nlat: %5$s\nlng: %6$s",
                    user.getAddress().getStreet(), user.getAddress().getSuite(),
                    user.getAddress().getCity(), user.getAddress().getZipcode(),
                    user.getAddress().getGeo().getLat(), user.getAddress().getGeo().getLng());
            tvAddress.setText(formatAddress);
            tvPhone.setText(user.getPhone());
            tvWebsite.setText(user.getWebsite());
            String formatCompany = String.format("%1$s\nCatch Phrase: %2$s\nbs: %3$s",
                    user.getCompany().getName(), user.getCompany().getCatchPhrase(), user.getCompany().getBs());
            tvCompany.setText(formatCompany);
        }
    }
}
