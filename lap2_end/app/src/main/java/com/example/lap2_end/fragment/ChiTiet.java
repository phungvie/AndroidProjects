package com.example.lap2_end.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lap2_end.MainActivity;
import com.example.lap2_end.MyAdapter;
import com.example.lap2_end.R;
import com.example.lap2_end.model.Contact;

import java.util.ArrayList;

public class ChiTiet extends Fragment {
    private View mView;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_chi_tiet, container, false);

        //
        listView = mView.findViewById(R.id.listView);
        //

        //
        ArrayList<Contact> data= MainActivity.data;
        //



        MyAdapter myAdapter = new MyAdapter(getContext(), R.layout.layout_item_chi_tiet, data);
        listView.setAdapter(myAdapter);
        return mView;
    }
}