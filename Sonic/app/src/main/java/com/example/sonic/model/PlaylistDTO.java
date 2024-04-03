package com.example.sonic.model;

import com.google.gson.annotations.Expose;

public class PlaylistDTO {
    @Expose
    private Integer playlistID;
    @Expose
    private String name;
    @Expose
    private String image;

    public PlaylistDTO(Integer playlistID, String name, String image) {
        this.playlistID = playlistID;
        this.name = name;
        this.image = image;
    }

    public PlaylistDTO() {
    }

    public Integer getPlaylistID() {
        return playlistID;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void setPlaylistID(Integer playlistID) {
        this.playlistID = playlistID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "PlaylistDTO{" +
                "playlistID=" + playlistID +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
