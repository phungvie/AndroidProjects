package com.example.sonic.adapter.model;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sonic.network.model.ArtistDTO;
import com.example.sonic.network.model.PlaylistDTO;
import com.google.gson.annotations.Expose;

public class Home extends RecyclerView.ViewHolder {
    private final ArtistDTO mArtistDTO;
    private final PlaylistDTO mPlaylistDTO;

    public Home(ArtistDTO mArtistDTO,@NonNull View itemView) {
        super(itemView);
        this.mArtistDTO = mArtistDTO;
        this.mPlaylistDTO = null;
    }
    public Home(PlaylistDTO mPlaylistDTO,@NonNull View itemView) {
        super(itemView);
        this.mArtistDTO = null;
        this.mPlaylistDTO = mPlaylistDTO;
    }
    public ArtistDTO getArtistDTO() {
        return mArtistDTO;
    }

    public PlaylistDTO getPlaylistDTO() {
        return mPlaylistDTO;
    }


    @Override
    public String toString() {
        return "lib{" +
                "mArtistDTO=" + mArtistDTO +
                ", mPlaylistDTO=" + mPlaylistDTO +
                '}';
    }
}

