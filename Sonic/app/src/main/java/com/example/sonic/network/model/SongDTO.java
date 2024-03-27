package com.example.sonic.network.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class SongDTO implements Serializable {
    private Integer songID;
    private String name;
    private String image;
    private String sound;
    private Timestamp releaseTime;
    private String artistName;

    public SongDTO(Integer songID, String name, String image, String sound, Timestamp releaseTime, String artistName) {
        this.songID = songID;
        this.name = name;
        this.image = image;
        this.sound = sound;
        this.releaseTime = releaseTime;
        this.artistName = artistName;
    }

    public Integer getSongID() {
        return songID;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getSound() {
        return sound;
    }

    public Timestamp getReleaseTime() {
        return releaseTime;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setSongID(Integer songID) {
        this.songID = songID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setReleaseTime(Timestamp releaseTime) {
        this.releaseTime = releaseTime;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
