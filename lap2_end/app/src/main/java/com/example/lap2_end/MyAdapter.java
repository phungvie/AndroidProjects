package com.example.lap2_end;

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

import com.example.lap2_end.model.Contact;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Contact> {
    Context context;
    int layoutResource;
    ArrayList<Contact> contacts;


    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Contact> objects) {
        super(context, resource, objects);
        this.context=context;
        this.layoutResource=resource;
        this.contacts=objects;

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView= inflater.inflate(layoutResource,null);

        Contact viet=contacts.get(position);

        if(layoutResource==R.layout.layout_item){
            CheckedTextView mCheckBox=convertView.findViewById(R.id.checkBox);
            mCheckBox.setChecked(viet.getStatus());

            TextView mTextViewName=convertView.findViewById(R.id.textViewNameContact);
            mTextViewName.setText(viet.getName());

            TextView mTextViewPhoneNumber=convertView.findViewById(R.id.textViewPhoneNumber);
            mTextViewPhoneNumber.setText(viet.getPhoneNumber());

            ImageView mImageView=convertView.findViewById(R.id.imageView);
            Picasso.get().load(viet.getImg()).into(mImageView);
        }else{
            TextView mTextViewName=convertView.findViewById(R.id.textViewNameContactCT);
            mTextViewName.setText(viet.getName());

            TextView mTextViewPhoneNumber=convertView.findViewById(R.id.textViewPhoneNumberCT);
            mTextViewPhoneNumber.setText(viet.getPhoneNumber());

            ImageView mImageView=convertView.findViewById(R.id.imageViewCT);
            Picasso.get().load(viet.getImg()).into(mImageView);
        }





        return convertView;
    }


}
