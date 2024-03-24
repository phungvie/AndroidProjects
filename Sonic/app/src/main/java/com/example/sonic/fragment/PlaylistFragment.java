package com.example.sonic.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sonic.R;
import com.example.sonic.network.model.ArtistDTO;
import com.example.sonic.network.model.Lib;
import com.example.sonic.network.model.PlaylistDTO;


public class PlaylistFragment extends Fragment {
    private Lib mLib;

    public PlaylistFragment(Lib viet) {
        this.mLib = viet;
    }

    View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_playlist, container, false);

        TextView mTextViewNamePlayList = mView.findViewById(R.id.textViewNamePlaylist);
        if (mLib.getPlaylistDTO() != null) {
            PlaylistDTO mPlaylistDTO = mLib.getPlaylistDTO();
            mTextViewNamePlayList.setTextSize(28);
            mTextViewNamePlayList.setText(mPlaylistDTO.getName());
        } else {
            ArtistDTO mmPlaylistDTO = mLib.getArtistDTO();
            mTextViewNamePlayList.setText(mmPlaylistDTO.getName());
            mTextViewNamePlayList.setTextSize(35);
        }


        return mView;
    }
}