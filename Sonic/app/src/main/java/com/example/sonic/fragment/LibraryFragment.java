package com.example.sonic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sonic.R;
import com.example.sonic.adapter.MyAdapter;
import com.example.sonic.network.model.Lib;

import java.util.ArrayList;

public class LibraryFragment extends Fragment {
    private View mView;
    MyAdapter myAdapter;
    ListView mListView;
    ArrayList<Lib> data;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.fragment_library,container,false);
        mListView=mView.findViewById(R.id.list_view_lib);


        myAdapter = new MyAdapter(getContext(), R.layout.layout_item, data);
        mListView.setAdapter(myAdapter);
//        listView.setOnItemClickListener((parent, view, position, id) ->
        return mView;
    }
}
