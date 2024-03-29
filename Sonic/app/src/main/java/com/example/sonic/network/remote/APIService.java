package com.example.sonic.network.remote;

import com.example.sonic.network.model.ArtistDTO;
import com.example.sonic.network.model.Lib;
import com.example.sonic.network.model.LoginRequest;
import com.example.sonic.network.model.SongDTO;
import com.example.sonic.network.model.TokenLogin;
import com.example.sonic.network.model.UserDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {
    @POST("/security/login")
    Call<TokenLogin> loginToken(@Body LoginRequest loginRequest);

    @GET("/sonic/playlist/songs/{id}")
    Call<List<SongDTO>> getSongsInPlaylist(@Path("id") Integer id);

    @GET("/sonic/artist/songs/{id}")
    Call<List<SongDTO>> getSongsOfArtist(@Path("id") Integer id);
    
}
