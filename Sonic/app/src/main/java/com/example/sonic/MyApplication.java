package com.example.sonic;

import android.app.Application;

import com.example.sonic.network.remote.RetrofitClientToken;
import com.example.sonic.network.sharedPreferences.DataLocalManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataLocalManager.getInstance(getApplicationContext());

        //
        String token = DataLocalManager.getToken();
        if (!token.isEmpty()) {
            Interceptor mInterceptor = chain -> {
                Request mRequest = chain.request();
                Request.Builder mBuilder = mRequest.newBuilder();
                mBuilder.addHeader("Authorization", token);
                return chain.proceed(mBuilder.build());
            };
            OkHttpClient.Builder mOkBuilder = new OkHttpClient.Builder().addInterceptor(mInterceptor);

            //
            Retrofit mRetrofit = RetrofitClientToken.getClientToken(mOkBuilder);
        }
    }
}
