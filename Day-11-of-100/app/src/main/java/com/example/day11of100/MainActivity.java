package com.example.day11of100;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static final String IMAGE_URL = "https://cdn.pixabay.com/photo/2015/01/19/18/35/android-604356_960_720.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButtonLoadImage = findViewById(R.id.button_load_image);
        final ImageView mImageView = findViewById(R.id.image_view);

        mButtonLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetImageFromUrl(mImageView).execute(IMAGE_URL);
            }
        });
    }

    private class GetImageFromUrl extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        GetImageFromUrl(ImageView imageView) {
            this.imageView = imageView;
            Toast.makeText(getApplicationContext(), "Please wait, it may take a few minute...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String imageUrl = urls[0];
            Bitmap bitmap = null;
            try {
                InputStream is = new java.net.URL(imageUrl).openStream();
                bitmap = BitmapFactory.decodeStream(is);
            } catch (Exception e) {
                Log.e("IMAGE_LOADING_ERROR", e.getMessage());
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                Toast.makeText(getApplicationContext(), "Faild to load the image", Toast.LENGTH_LONG).show();
            }
        }
    }
}
