package com.example.sonic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sonic.R;
import com.example.sonic.network.model.Lib;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Lib> {
    Context context;
    int layoutResource;
    ArrayList<Lib> mLibs;


    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Lib> objects) {
        super(context, resource, objects);
        this.context=context;
        this.layoutResource=resource;
        this.mLibs=objects;

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView= inflater.inflate(layoutResource,null);

        Lib viet= mLibs.get(position);

        if(viet.getPlaylistDTO()!=null){
            ImageView mImageViewLib=convertView.findViewById(R.id.imageViewLib);
            TextView mTextViewName=convertView.findViewById(R.id.textViewNameLib);
            TextView mTextViewGen=convertView.findViewById(R.id.textViewGenLib);
            mTextViewName.setText(viet.getPlaylistDTO().getName());
            mTextViewGen.setText("Danh sách phát");
            Picasso.get().load(viet.getPlaylistDTO().getImage()).into(mImageViewLib);


        }else{
            ImageView mImageViewLib=convertView.findViewById(R.id.imageViewLib);
            TextView mTextViewName=convertView.findViewById(R.id.textViewNameLib);
            TextView mTextViewGen=convertView.findViewById(R.id.textViewGenLib);
            mTextViewName.setText(viet.getArtistDTO().getName());
            mTextViewGen.setText("Nghệ sĩ");
            Picasso.get().load(viet.getArtistDTO().getImage()).into(mImageViewLib);
        }





        return convertView;
    }


}
