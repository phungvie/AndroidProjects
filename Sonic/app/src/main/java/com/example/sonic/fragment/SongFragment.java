package com.example.sonic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sonic.R;
import com.example.sonic.service.MusicService;


public class SongFragment extends Fragment {
    EditText mEditTextService;
    Button mButtonStartService;
    Button mButtonStopService;
    private View mView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.fragment_song,container,false);


         mEditTextService=mView.findViewById(R.id.edit_text_content_service);
         mButtonStartService=mView.findViewById(R.id.startService);
         mButtonStopService=mView.findViewById(R.id.stopService);
          mButtonStartService.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  clickStartService();
              }
          });
        mButtonStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStopService();
            }
        });


        return mView;
    }

    private void clickStopService() {
        Intent intent=new Intent(getActivity(), MusicService.class);
        intent.putExtra("key_data_intent",mEditTextService.getText().toString().trim());




        getActivity().startService(intent);
    }

    private void clickStartService() {
    }
}