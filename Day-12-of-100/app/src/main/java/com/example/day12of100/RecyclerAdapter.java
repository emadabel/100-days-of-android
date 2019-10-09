package com.example.day12of100;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyListViewHolder> {

    private MyListItemOnClickHandler mClickHandler;
    private MyListData[] myListData;

    public RecyclerAdapter(MyListItemOnClickHandler clickHandler, MyListData[] myListData) {
        this.mClickHandler = clickHandler;
        this.myListData = myListData;
    }

    @NonNull
    @Override
    public MyListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        MyListViewHolder viewHolder = new MyListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListViewHolder myListViewHolder, int position) {
        MyListData listData = myListData[position];
        myListViewHolder.imageView.setImageResource(listData.getImgId());
        myListViewHolder.textView.setText(listData.getDescription());
    }

    @Override
    public int getItemCount() {
        return myListData.length;
    }

    public interface MyListItemOnClickHandler {
        void onClick(String description);
    }

    class MyListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;

        public MyListViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            String itemDescription = myListData[adapterPosition].getDescription();
            mClickHandler.onClick(itemDescription);
        }
    }
}
