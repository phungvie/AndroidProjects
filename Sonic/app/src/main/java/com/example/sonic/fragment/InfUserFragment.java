package com.example.sonic.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sonic.DataLocalManager;
import com.example.sonic.R;

public class InfUserFragment extends Fragment {


    View mvView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mvView = inflater.inflate(R.layout.fragment_inf_user, container, false);
        String name = DataLocalManager.getInstance().getName();
//        getActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView mTextViewName = mvView.findViewById(R.id.textViewName);
        mTextViewName.setText(name);
        return mvView;
    }


}