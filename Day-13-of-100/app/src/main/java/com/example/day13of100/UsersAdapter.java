package com.example.day13of100;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class UsersAdapter extends ArrayAdapter<User> {

    public UsersAdapter(@NonNull Context context, @NonNull List<User> users) {
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        TextView tvName = convertView.findViewById(R.id.text_name);
        TextView tvUsername = convertView.findViewById(R.id.text_username);
        TextView tvEmail = convertView.findViewById(R.id.text_email);

        tvName.setText(user.getName());
        tvUsername.setText(String.format("(%s)", user.getUsername()));
        tvEmail.setText(user.getEmail());

        return convertView;
    }
}
