package com.example.sonic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sonic.R;
import com.example.sonic.network.remote.APIServiceToken;
import com.example.sonic.network.remote.RetrofitClientToken;

import retrofit2.Retrofit;

public class PremiumFragment extends Fragment {
    private View mvView;
    Button mButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mvView=inflater.inflate(R.layout.fragment_premium,container,false);
        mButton=mvView.findViewById(R.id.bt_premuim);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit= RetrofitClientToken.getClientToken(null);
                APIServiceToken apiServiceToken=  retrofit.create(APIServiceToken.class);

            }
        });
        return mvView;
    }
}
