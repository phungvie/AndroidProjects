package com.example.lap2_end.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lap2_end.R;
import com.example.lap2_end.model.Contact;
import com.squareup.picasso.Picasso;


public class UserFragment extends Fragment {


    private Contact viet;

    Button mButtonCall;
    private  View mView;
    public UserFragment(Contact viet) {
        this.viet=viet;
        // Required empty public constructor
    }
    ImageView mImageView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_user, container, false);

        //
        TextView mTextViewName=mView.findViewById(R.id.textViewName);
        TextView mTextViewPhone=mView.findViewById(R.id.textViewPhone);
        mImageView=mView.findViewById(R.id.imageViewAvatars);
        mButtonCall=mView.findViewById(R.id.buttonCall);
        //


        mTextViewName.setText(viet.getName());
        mTextViewPhone.setText(viet.getPhoneNumber());
        Picasso.get().load(viet.getImg()).into(mImageView);



        mButtonCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+viet.getPhoneNumber()));
            startActivity(intent);

//            Intent intent = new Intent(Intent.ACTION_DIAL);
//            intent.setData(Uri.parse(viet.getPhoneNumber())); // Thay số điện thoại bằng số muốn gọi
//            startActivity(intent);

//            Intent intent = new Intent(Intent.ACTION_CALL);
//            intent.setData(Uri.parse(viet.getPhoneNumber())); // Thay số điện thoại bằng số muốn gọi
//            startActivity(intent);
        });


        return mView;
    }
}