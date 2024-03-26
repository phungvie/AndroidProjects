package com.example.sonic.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sonic.R;
import com.example.sonic.adapter.MyAdapterListViewLib;
import com.example.sonic.adapter.MyAdapterListViewSong;
import com.example.sonic.network.model.ArtistDTO;
import com.example.sonic.network.model.Lib;
import com.example.sonic.network.model.PlaylistDTO;
import com.example.sonic.network.model.SongDTO;
import com.example.sonic.network.remote.APIService;
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


public class PlaylistFragment extends Fragment {
    private Lib mLib;
    private View mView;
    private List<SongDTO> data = new ArrayList<>();

    public PlaylistFragment(Lib viet) {
        this.mLib = viet;
    }

    private ListView mListView;
    private MyAdapterListViewSong myAdapterListViewSong;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_playlist, container, false);

        ImageView mImageView=mView.findViewById(R.id.imageViewPlayList);
        mListView = mView.findViewById(R.id.ListViewPlaylist);

        myAdapterListViewSong = new MyAdapterListViewSong(getActivity(), R.layout.layout_item_song, data);
        mListView.setAdapter(myAdapterListViewSong);

        TextView mTextViewNamePlayList = mView.findViewById(R.id.textViewNamePlaylist);
        if (mLib.getPlaylistDTO() != null) {

            PlaylistDTO mPlaylistDTO = mLib.getPlaylistDTO();

            Picasso.get().load(RetrofitClient.url+mPlaylistDTO.getImage()).into(mImageView);

            mTextViewNamePlayList.setTextSize(28);
            mTextViewNamePlayList.setText(mPlaylistDTO.getName());

            Retrofit mRetrofit = RetrofitClient.getClient();
            APIService mApiService = mRetrofit.create(APIService.class);
            mApiService.getSongsInPlaylist(mPlaylistDTO.getPlaylistID()).enqueue(new Callback<List<SongDTO>>() {
                @Override
                public void onResponse(Call<List<SongDTO>> call, Response<List<SongDTO>> response) {
                    if (response.isSuccessful()) {
                        List<SongDTO> mSongsDTO = response.body();
                        for (SongDTO songDTO : mSongsDTO) {
                            data.add(songDTO);
                        }
                        myAdapterListViewSong.notifyDataSetChanged();

                    } else {
                        // Xử lý trường hợp lỗi nếu có
                        Log.e("Lỗi playlist 1: ", response.code() + "");
                    }
                }

                @Override
                public void onFailure(Call<List<SongDTO>> call, Throwable t) {
                    Log.e("Lỗi playlist 2: ", t.getMessage());
                }
            });

        } else {
            ArtistDTO mArtistDTO = mLib.getArtistDTO();

            Picasso.get().load(RetrofitClient.url+mArtistDTO.getImage()).into(mImageView);

            mTextViewNamePlayList.setText(mArtistDTO.getName());
            mTextViewNamePlayList.setTextSize(35);

            Retrofit mRetrofit = RetrofitClient.getClient();
            APIService mApiService = mRetrofit.create(APIService.class);
            mApiService.getSongsOfArtist(mArtistDTO.getArtistID()).enqueue(new Callback<List<SongDTO>>() {
                @Override
                public void onResponse(Call<List<SongDTO>> call, Response<List<SongDTO>> response) {
                    if (response.isSuccessful()) {
                        List<SongDTO> mSongsDTO = response.body();
                        for (SongDTO songDTO : mSongsDTO) {
                            data.add(songDTO);
                        }
                        myAdapterListViewSong.notifyDataSetChanged();

                    } else {
                        // Xử lý trường hợp lỗi nếu có
                        Log.e("Lỗi playlist 3: ", response.code() + "");
                    }
                }

                @Override
                public void onFailure(Call<List<SongDTO>> call, Throwable t) {
                    Log.e("Lỗi playlist 4: ", t.getMessage());
                }
            });
        }


        return mView;
    }
}