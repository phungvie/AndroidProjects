package com.example.sonic.network.remote;

import com.example.sonic.LoginActivity;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientToken {
    private static Retrofit retrofit = null;

    private RetrofitClientToken() {
    }
    public static Retrofit getClientToken(OkHttpClient.Builder mOkBuilder) {
        if (retrofit==null) {


            retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(mOkBuilder.build())
                    .build();
        }
        return retrofit;
    }
}
