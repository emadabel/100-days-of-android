package com.example.day13of100;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class NetworkUtils {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    public static String getJsonFromUrl(String url) throws IOException  {
        URL mUrl = null;
        try {
            mUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpsURLConnection urlConnection = (HttpsURLConnection) mUrl.openConnection();
        try {
            InputStream is = urlConnection.getInputStream();

            Scanner scanner = new Scanner(is);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
                urlConnection.disconnect();
        }
    }
}
