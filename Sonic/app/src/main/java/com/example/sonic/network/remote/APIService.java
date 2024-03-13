package com.example.sonic.network.remote;

import com.example.sonic.network.model.ArtistDTO;
import com.example.sonic.network.model.Lib;
import com.example.sonic.network.model.LoginRequest;
import com.example.sonic.network.model.TokenLogin;
import com.example.sonic.network.model.UserDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
public interface APIService {
    @POST("/security/login")
    Call<TokenLogin> loginToken(@Body LoginRequest loginRequest);




    
}
