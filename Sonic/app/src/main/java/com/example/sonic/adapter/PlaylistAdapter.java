package com.example.sonic.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sonic.R;
import com.example.sonic.adapter.model.Home;
import com.example.sonic.network.model.Lib;
import com.example.sonic.network.model.PlaylistDTO;

import java.util.List;

public class PlaylistAdapter extends  RecyclerView.Adapter<Home> {

    public static List<Home>data;

    @NonNull
    @Override
    public Home onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Home holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class PlaylistViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageViewHomeItem;
        TextView mTextViewNameHomeItem;
        TextView mTextViewCategoryHomeItem;


        public PlaylistViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewHomeItem=itemView.findViewById(R.id.img_view_playlist_home_item);
            mTextViewNameHomeItem=itemView.findViewById(R.id.text_name_playlist_home_item);
            mTextViewCategoryHomeItem=itemView.findViewById(R.id.text_category_playlist_home_item);
        }
    }
}
