package com.example.day10of100.data;

import android.net.Uri;

public class UsersContract {

    public static final String AUTHORITY = "com.example.day10of100";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    public static final String PATH_USERS = "users";

    private UsersContract() {}

    public static final class UsersEntry {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_USERS).build();

        public static final String TABLE_NAME = "users";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
    }
}
