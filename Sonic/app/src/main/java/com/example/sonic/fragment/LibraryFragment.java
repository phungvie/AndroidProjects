package com.example.sonic.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.sonic.R;
import com.example.sonic.adapter.MyAdapterListViewLib;
import com.example.sonic.network.model.ArtistDTO;
import com.example.sonic.network.model.Lib;
import com.example.sonic.network.model.PlaylistDTO;
import com.example.sonic.network.remote.APIServiceToken;
import com.example.sonic.network.remote.RetrofitClientToken;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LibraryFragment extends Fragment {
    private View mView;
    MyAdapterListViewLib myAdapter;
    ListView mListView;

    ActionBarDrawerToggle toggle;

    ActionBar mActionBar;
    FragmentManager fragmentManager;
    List<Lib> data=new ArrayList<>();

    public LibraryFragment(ActionBar mActionBar,ActionBarDrawerToggle toggle) {
        this.mActionBar = mActionBar;
        this.toggle=toggle;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.fragment_library,container,false);
        mListView=mView.findViewById(R.id.list_view_lib);

        myAdapter = new MyAdapterListViewLib(getActivity(), R.layout.layout_item, data);
        mListView.setAdapter(myAdapter);


        Retrofit mRetrofit = RetrofitClientToken.getClientToken(null);
        APIServiceToken mApiServiceToken = mRetrofit.create(APIServiceToken.class);




        mApiServiceToken.getArtistDto().enqueue(new Callback<List<ArtistDTO>>() {
            @Override
            public void onResponse(Call<List<ArtistDTO>> call, Response<List<ArtistDTO>> response) {
                if (response.isSuccessful()) {
                    List<ArtistDTO> mArtistDTOs = response.body();
                    for (ArtistDTO ArtistDTO:mArtistDTOs) {
                        data.add(new Lib(ArtistDTO));
                    }
                    myAdapter.notifyDataSetChanged();

                } else {
                    // Xử lý trường hợp lỗi nếu có
                    Log.e("Lỗi lib 1: ", response.code() + "");
                }
            }

            @Override
            public void onFailure(Call<List<ArtistDTO>> call, Throwable t) {
                Log.e("Lỗi lib 2: ", t.getMessage());
            }
        });

        mApiServiceToken.getPlaylistDto().enqueue(new Callback<List<PlaylistDTO>>() {
            @Override
            public void onResponse(Call<List<PlaylistDTO>> call, Response<List<PlaylistDTO>> response) {
                if (response.isSuccessful()) {
                    List<PlaylistDTO> mPlaylistDTOs = response.body();
                    for (PlaylistDTO playlistDTO:mPlaylistDTOs) {
                        data.add(new Lib(playlistDTO));
                    }
                    myAdapter.notifyDataSetChanged();
                } else {
                    // Xử lý trường hợp lỗi nếu có
                    Log.e("Lỗi lib 3: ", response.code() + "");
                }
            }

            @Override
            public void onFailure(Call<List<PlaylistDTO>> call, Throwable t) {
                Log.e("Lỗi lib 4: ", t.getMessage());
            }
        });


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getActivity().findViewById(R.id.view_pager_2).setVisibility(View.GONE);
                getActivity().findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);


                //
                fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                PlaylistFragment fragment = new PlaylistFragment(data.get(position));
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                //
//                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container, new HomeFragment());
//                transaction.addToBackStack(null);
//                transaction.commit();

                toggle.setDrawerIndicatorEnabled(false);
                mActionBar.setDisplayHomeAsUpEnabled(true);
                mActionBar.setHomeAsUpIndicator(R.drawable.ic_left);

            }
        });

        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fragmentManager.getBackStackEntryCount()==1){
                    getActivity().onBackPressed();
                    getActivity().findViewById(R.id.view_pager_2).setVisibility(View.VISIBLE);
                    getActivity().findViewById(R.id.fragment_container).setVisibility(View.GONE);
                    toggle.setDrawerIndicatorEnabled(true);
                    mActionBar.setDisplayHomeAsUpEnabled(true);
                    mActionBar.setHomeAsUpIndicator(R.drawable.ic_bars_sort);
                }else{
                    getActivity().onBackPressed();
                }
            }
        });
        return mView;

    }





}
