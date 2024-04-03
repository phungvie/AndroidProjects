package com.example.sonic.network.remote;

import com.example.sonic.model.ArtistDTO;
import com.example.sonic.model.PlaylistDTO;
import com.example.sonic.model.UserDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServiceToken {
    @GET("/security/getUser")
//    @Headers("Authorization:Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aWV0QGdtYWlsLmNvbSIsImlhdCI6MTcwODA5MzM0MCwiZXhwIjoxNzA4Njk4MTQwfQ.1kEgpaIkyIwYWk_M0QEFXBP2kiGZ3BNZAx8pACmKUiS2gTJibWkN8e9Qf5zZOAbMTedGhDgKj5OUN8rtB23VqQ")
    Call<UserDTO> getUser();
    @GET("/sonic/lib/artists")
    Call<List<ArtistDTO>> getArtistDto();

    @GET("/sonic/lib/playlists")
    Call<List<PlaylistDTO>> getPlaylistDto();



}
