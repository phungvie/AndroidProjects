package com.example.sonic.network.remote;

import com.example.sonic.network.model.ArtistDTO;
import com.example.sonic.network.model.PlaylistDTO;
import com.example.sonic.network.model.UserDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIServiceToken {
    @GET("/security/getUser")
//    @Headers("Authorization:Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aWV0QGdtYWlsLmNvbSIsImlhdCI6MTcwODA5MzM0MCwiZXhwIjoxNzA4Njk4MTQwfQ.1kEgpaIkyIwYWk_M0QEFXBP2kiGZ3BNZAx8pACmKUiS2gTJibWkN8e9Qf5zZOAbMTedGhDgKj5OUN8rtB23VqQ")
    Call<UserDTO> getUser();
    @GET("/sonic/lib/artists/{id}")
    Call<List<ArtistDTO>> getArtistDto(@Path("id") Integer id);

    @GET("/sonic/lib/playlists/{id}")
    Call<List<PlaylistDTO>> getPlaylistDto(@Path("id") Integer id);

}