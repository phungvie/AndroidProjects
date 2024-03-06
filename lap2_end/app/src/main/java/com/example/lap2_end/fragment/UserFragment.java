package com.example.lap2_end.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lap2_end.R;
import com.example.lap2_end.model.Contact;


public class UserFragment extends Fragment {


    private Contact viet;


    private  View mView;
    public UserFragment(Contact viet) {
        this.viet=viet;
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_user, container, false);
        TextView mTextViewName=mView.findViewById(R.id.textViewName);
        mTextViewName.setText(viet.getName());






        return mView;
    }
}