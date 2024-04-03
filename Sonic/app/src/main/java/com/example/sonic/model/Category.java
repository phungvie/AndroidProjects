package com.example.sonic.model;

import java.util.List;

public class Category {
    private String name;
    private List<ArtistAndPlaylist> artistsAndPlaylists;

    public Category(String name, List<ArtistAndPlaylist> artistsAndPlaylists) {
        this.name = name;
        this.artistsAndPlaylists = artistsAndPlaylists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArtistAndPlaylist> getLibs() {
        return artistsAndPlaylists;
    }

    public void setLibs(List<ArtistAndPlaylist> artistAndPlaylists) {
        this.artistsAndPlaylists = artistAndPlaylists;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", libs=" + artistsAndPlaylists +
                '}';
    }
}
