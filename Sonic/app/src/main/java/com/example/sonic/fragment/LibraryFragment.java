package com.example.sonic.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.sonic.R;
import com.example.sonic.adapter.MyAdapterListViewLib;
import com.example.sonic.network.model.ArtistDTO;
import com.example.sonic.network.model.Lib;
import com.example.sonic.network.model.PlaylistDTO;
import com.example.sonic.network.remote.APIServiceToken;
import com.example.sonic.network.remote.RetrofitClient;
import com.example.sonic.network.remote.RetrofitClientToken;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LibraryFragment extends Fragment {
    private View mView;
    private MyAdapterListViewLib myAdapterListViewLib;
    private  ListView mListView;
    private ActionBarDrawerToggle toggle;

    private   ActionBarDrawerToggle.Delegate delegate;
    private  FragmentManager fragmentManager;
    public static List<Lib> data;

    public LibraryFragment(ActionBarDrawerToggle toggle) {
        this.toggle = toggle;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.fragment_library,container,false);

//
       data= new ArrayList<>();
        //
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        //
        mListView=mView.findViewById(R.id.list_view_lib);

        myAdapterListViewLib = new MyAdapterListViewLib(activity, R.layout.layout_item, data);
        mListView.setAdapter(myAdapterListViewLib);


        Retrofit mRetrofit = RetrofitClientToken.getClientToken(null);
        APIServiceToken mApiServiceToken = mRetrofit.create(APIServiceToken.class);


        mApiServiceToken.getArtistDto().enqueue(new Callback<List<ArtistDTO>>() {
            @Override
            public void onResponse(Call<List<ArtistDTO>> call, Response<List<ArtistDTO>> response) {
                if (response.isSuccessful()) {
                    List<ArtistDTO> mArtistsDTO = response.body();
                    for (ArtistDTO ArtistDTO:mArtistsDTO) {
                        data.add(new Lib(ArtistDTO));
                    }
                    myAdapterListViewLib.notifyDataSetChanged();

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
                    List<PlaylistDTO> mPlaylistsDTO = response.body();
                    for (PlaylistDTO playlistDTO:mPlaylistsDTO) {
                        data.add(new Lib(playlistDTO));
                    }
                    myAdapterListViewLib.notifyDataSetChanged();
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

                activity.findViewById(R.id.view_pager_2).setVisibility(View.GONE);
                activity.findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);
                activity.getSupportActionBar().setTitle("");

                //
                fragmentManager= activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                PlaylistFragment fragment = new PlaylistFragment(data.get(position));
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                //
//                FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container, new HomeFragment());
//                transaction.addToBackStack(null);
//                transaction.commit();

                toggle.setDrawerIndicatorEnabled(false);
                toggle.setHomeAsUpIndicator(R.drawable.ic_left);

            }
        });

        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fragmentManager.getBackStackEntryCount()==1){
                    activity.getSupportActionBar().setTitle(R.string.lib);
                    activity.onBackPressed();
                    activity.findViewById(R.id.view_pager_2).setVisibility(View.VISIBLE);
                    activity.findViewById(R.id.fragment_container).setVisibility(View.GONE);
                    toggle.setDrawerIndicatorEnabled(true);
                }else{
                    activity.onBackPressed();
                }
            }
        });
        return mView;

    }





}
