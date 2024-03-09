package com.example.sonic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sonic.DataLocalManager;
import com.example.sonic.R;
import com.example.sonic.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private View mvView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mvView = inflater.inflate(R.layout.fragment_home, container, false);

        return mvView;
    }
}
