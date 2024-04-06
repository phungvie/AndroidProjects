package com.example.sonic.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sonic.R;
import com.example.sonic.adapter.CategoryAdapter;
import com.example.sonic.model.ArtistDTO;
import com.example.sonic.model.ArtistAndPlaylist;
import com.example.sonic.model.Category;
import com.example.sonic.model.PlaylistDTO;
import com.example.sonic.myInterface.IClickItemViet;
import com.example.sonic.myInterface.IToggle;
import com.example.sonic.network.remote.APIServiceToken;
import com.example.sonic.network.remote.RetrofitClientToken;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {
    private View mView;
    private RecyclerView mRecyclerView;
    private IToggle mIToggle;
    private CategoryAdapter mCategoryAdapter;
    private List<Category> data;

    public HomeFragment(IToggle mIToggle) {
        this.mIToggle = mIToggle;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);

        data = new ArrayList<>();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        mRecyclerView = mView.findViewById(R.id.rcv_category);
        mCategoryAdapter = new CategoryAdapter(getContext(), artistAndPlaylist -> {
            activity.findViewById(R.id.view_pager_2).setVisibility(View.GONE);
            activity.findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);
            activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

            //
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            PlaylistFragment fragment = new PlaylistFragment(artistAndPlaylist);
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            mIToggle.TurnOnTheBackButton();
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mCategoryAdapter);
        callApiGetCategory();

        mIToggle.setToggle(null);


        mCategoryAdapter.setData(data);
        return mView;
    }


    private int networkCallsCompleted = 0;

    private void callApiGetCategory() {

        Retrofit mRetrofit = RetrofitClientToken.getClientToken(null);
        APIServiceToken mApiServiceToken = mRetrofit.create(APIServiceToken.class);

        mApiServiceToken.getAllArtists().enqueue(new Callback<List<ArtistDTO>>() {
            @Override
            public void onResponse(Call<List<ArtistDTO>> call, Response<List<ArtistDTO>> response) {

                if (response.isSuccessful()) {
                    List<ArtistDTO> artistsDTO = response.body();
                    List<ArtistAndPlaylist> viet = new ArrayList<>();
                    for (ArtistDTO artistDTO : artistsDTO) {
                        viet.add(new ArtistAndPlaylist(artistDTO));
                    }
                    data.add(new Category("Các nghệ sĩ", viet));
                    // Tăng biến đếm khi cuộc gọi mạng hoàn thành
                    networkCallsCompleted++;
                    // Gọi hàm kiểm tra hoàn thành cuộc gọi mạng
                    checkNetworkCallsCompleted();

                } else {
                    // Xử lý trường hợp lỗi nếu có
                    Log.e("Lỗi home 1: ", response.code() + "");
                    // Tăng biến đếm khi cuộc gọi mạng hoàn thành (dù thất bại)
                    networkCallsCompleted++;
                    // Gọi hàm kiểm tra hoàn thành cuộc gọi mạng
                    checkNetworkCallsCompleted();
                }
            }

            @Override
            public void onFailure(Call<List<ArtistDTO>> call, Throwable t) {
                Log.e("Lỗi home 2: ", t.getMessage());
                // Tăng biến đếm khi cuộc gọi mạng hoàn thành (dù thất bại)
                networkCallsCompleted++;
                // Gọi hàm kiểm tra hoàn thành cuộc gọi mạng
                checkNetworkCallsCompleted();
            }
        });


        mApiServiceToken.getAllPlaylists().enqueue(new Callback<List<PlaylistDTO>>() {

            @Override
            public void onResponse(Call<List<PlaylistDTO>> call, Response<List<PlaylistDTO>> response) {
                if (response.isSuccessful()) {
                    List<PlaylistDTO> playlistsDTO = response.body();
                    List<ArtistAndPlaylist> viet = new ArrayList<>();
                    for (PlaylistDTO playlistDTO : playlistsDTO) {
                        viet.add(new ArtistAndPlaylist(playlistDTO));
                    }

                    data.add(new Category("Các danh sách phát", viet));
                    // Tăng biến đếm khi cuộc gọi mạng hoàn thành
                    networkCallsCompleted++;
                    // Gọi hàm kiểm tra hoàn thành cuộc gọi mạng
                    checkNetworkCallsCompleted();

                } else {
                    // Xử lý trường hợp lỗi nếu có
                    Log.e("Lỗi home 1*: ", response.code() + "");
                    // Tăng biến đếm khi cuộc gọi mạng hoàn thành (dù thất bại)
                    networkCallsCompleted++;
                    // Gọi hàm kiểm tra hoàn thành cuộc gọi mạng
                    checkNetworkCallsCompleted();
                }
            }

            @Override
            public void onFailure(Call<List<PlaylistDTO>> call, Throwable t) {
                Log.e("Lỗi home 2*: ", t.getMessage());
                // Tăng biến đếm khi cuộc gọi mạng hoàn thành (dù thất bại)
                networkCallsCompleted++;
                checkNetworkCallsCompleted();
                // Gọi hàm kiểm tra hoàn thành cuộc gọi mạng
                checkNetworkCallsCompleted();
            }
        });
    }

    private void checkNetworkCallsCompleted() {
//        testdata.setText(data.toString());
        // Kiểm tra xem cả hai cuộc gọi mạng đã hoàn thành hay chưa
        if (networkCallsCompleted == 2) {
            // Cả hai cuộc gọi mạng đã hoàn thành, thêm dữ liệu vào adapter và cập nhật giao diện
            mCategoryAdapter.setData(data);
        }
    }


}
