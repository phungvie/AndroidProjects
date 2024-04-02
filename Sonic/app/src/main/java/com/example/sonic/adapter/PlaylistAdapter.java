package com.example.sonic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sonic.R;
import com.example.sonic.network.model.ArtistDTO;
import com.example.sonic.network.model.Lib;
import com.example.sonic.network.model.PlaylistDTO;
import com.example.sonic.network.remote.APIServiceToken;
import com.example.sonic.network.remote.RetrofitClient;
import com.example.sonic.network.remote.RetrofitClientToken;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder> {

    public static List<Lib> data;
//    private Context mContext;
//
//    public PlaylistAdapter(Context mContext) {
//        this.mContext = mContext;
//    }
    public void setData(List<Lib> data){
        this.data=data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist_home, parent, false);
        return new PlaylistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistViewHolder holder, int position) {
        Lib lib=data.get(position);
        if(lib==null){
            return;
        }
       if( lib.getArtistDTO()!=null){
           ArtistDTO artistDTO= lib.getArtistDTO();
           holder.textViewCategoryHomeItem.setText("Nghệ sĩ");
           holder.textViewNameHomeItem.setText(artistDTO.getName());
           Picasso.get().load(RetrofitClient.url+artistDTO.getImage()).into(holder.imageViewHomeItem);
       }else{
           PlaylistDTO playlistDTO=lib.getPlaylistDTO();
           holder.textViewCategoryHomeItem.setText("Danh sách phát");
           holder.textViewNameHomeItem.setText(playlistDTO.getName());
           Picasso.get().load(RetrofitClient.url+playlistDTO.getImage()).into(holder.imageViewHomeItem);
       }
    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }

    public void setData() {
        APIServiceToken apiServiceToken = RetrofitClientToken.getClientToken(null).create(APIServiceToken.class);
    }

    public class PlaylistViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewHomeItem;
        private TextView textViewNameHomeItem;
        private TextView textViewCategoryHomeItem;


        public PlaylistViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewHomeItem = itemView.findViewById(R.id.img_view_playlist_home_item);
            textViewNameHomeItem = itemView.findViewById(R.id.text_name_playlist_home_item);
            textViewCategoryHomeItem = itemView.findViewById(R.id.text_category_playlist_home_item);
        }
    }
}
