package com.example.sonic.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.sonic.R;
import com.example.sonic.adapter.MyAdapterListViewLib;
import com.example.sonic.model.ArtistDTO;
import com.example.sonic.model.ArtistAndPlaylist;
import com.example.sonic.model.PlaylistDTO;
import com.example.sonic.myInterface.IToggle;
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
    private MyAdapterListViewLib myAdapterListViewLib;
    private  ListView mListView;
    private IToggle mIToggle;
    private List<ArtistAndPlaylist> data;
    public LibraryFragment(IToggle iToggle) {
        this.mIToggle = iToggle;
    }
    AppCompatActivity activity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.fragment_library,container,false);
         activity = (AppCompatActivity) getActivity();
        //
        mListView=mView.findViewById(R.id.list_view_lib);
//

        data= new ArrayList<>();
        myAdapterListViewLib = new MyAdapterListViewLib(activity, R.layout.layout_item, data);
        mListView.setAdapter(myAdapterListViewLib);

        vietLoadLib();
//
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                activity.findViewById(R.id.view_pager_2).setVisibility(View.GONE);
                activity.findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);
                activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
                //
                FragmentManager fragmentManager= activity.getSupportFragmentManager();
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

                mIToggle.TurnOnTheBackButton();
            }
        });

        mIToggle.setToggle(this);

                Toast.makeText(getContext(), "viet onCreateView", Toast.LENGTH_SHORT).show();

        return mView;

    }


    public void vietLoadLib(){
        data.clear();
        Retrofit mRetrofit = RetrofitClientToken.getClientToken(null);
        APIServiceToken mApiServiceToken = mRetrofit.create(APIServiceToken.class);


        mApiServiceToken.getArtistDto().enqueue(new Callback<List<ArtistDTO>>() {
            @Override
            public void onResponse(Call<List<ArtistDTO>> call, Response<List<ArtistDTO>> response) {
                if (response.isSuccessful()) {
                    List<ArtistDTO> mArtistsDTO = response.body();
                    for (ArtistDTO ArtistDTO:mArtistsDTO) {
                        data.add(new ArtistAndPlaylist(ArtistDTO));
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
                        data.add(new ArtistAndPlaylist(playlistDTO));
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
    }
//
    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onResume() {
        super.onResume();
        vietLoadLib();
    }

}
