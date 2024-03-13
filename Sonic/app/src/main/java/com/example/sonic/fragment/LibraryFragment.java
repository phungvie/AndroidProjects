package com.example.sonic.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sonic.DataLocalManager;
import com.example.sonic.R;
import com.example.sonic.adapter.MyAdapter;
import com.example.sonic.network.model.ArtistDTO;
import com.example.sonic.network.model.Lib;
import com.example.sonic.network.model.UserDTO;
import com.example.sonic.network.remote.APIServiceToken;
import com.example.sonic.network.remote.RetrofitClientToken;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LibraryFragment extends Fragment {
    private View mView;
    MyAdapter myAdapter;
    ListView mListView;
    List<Lib> data=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.fragment_library,container,false);
        mListView=mView.findViewById(R.id.list_view_lib);




        Retrofit mRetrofit = RetrofitClientToken.getClientToken(null);
        APIServiceToken mApiServiceToken = mRetrofit.create(APIServiceToken.class);

        mApiServiceToken.getArtistDto(1).enqueue(new Callback<List<ArtistDTO>>() {
            @Override
            public void onResponse(Call<List<ArtistDTO>> call, Response<List<ArtistDTO>> response) {
                if (response.isSuccessful()) {
                    List<ArtistDTO> mArtistDTOs = response.body();
                    data=mArtistDTOs.stream().map(artistDTO -> new Lib(artistDTO)).collect(Collectors.toList());
                    myAdapter = new MyAdapter(getActivity(), R.layout.layout_item, data);
                    mListView.setAdapter(myAdapter);
                    myAdapter.notifyDataSetChanged();
                } else {
                    // Xử lý trường hợp lỗi nếu có
                    Log.e("Lỗi lib 3: ", response.code() + "");
                }
            }

            @Override
            public void onFailure(Call<List<ArtistDTO>> call, Throwable t) {
                Log.e("Lỗi lib 4: ", t.getMessage());
            }
        });


//        listView.setOnItemClickListener((parent, view, position, id) ->
        return mView;
    }
}
