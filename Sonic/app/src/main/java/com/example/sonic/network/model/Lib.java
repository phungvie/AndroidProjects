package com.example.sonic.network.model;

import com.google.gson.annotations.Expose;

public class Lib {
    private final ArtistDTO mArtistDTO;
    private final PlaylistDTO mPlaylistDTO;

    public Lib(ArtistDTO mArtistDTO) {
        this.mArtistDTO = mArtistDTO;
        this.mPlaylistDTO = null;
    }
    public Lib(PlaylistDTO mPlaylistDTO) {
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
