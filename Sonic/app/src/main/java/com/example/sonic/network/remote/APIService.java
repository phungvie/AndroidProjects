package com.example.sonic.network.remote;

import com.example.sonic.network.model.LoginRequest;
import com.example.sonic.network.model.TokenLogin;
import com.example.sonic.network.model.UserDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
public interface APIService {


    @POST("/api/login")
    Call<TokenLogin> loginToken(@Body LoginRequest loginRequest);

    @GET("/api/getUser")
//    @Headers("Authorization:Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aWV0QGdtYWlsLmNvbSIsImlhdCI6MTcwODA5MzM0MCwiZXhwIjoxNzA4Njk4MTQwfQ.1kEgpaIkyIwYWk_M0QEFXBP2kiGZ3BNZAx8pACmKUiS2gTJibWkN8e9Qf5zZOAbMTedGhDgKj5OUN8rtB23VqQ")
    Call<UserDTO> getUser();
    
}
