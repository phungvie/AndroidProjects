package com.example.sonic.network.sharedPreferences;

import android.content.Context;

import com.example.sonic.network.model.UserDTO;
import com.google.gson.Gson;

public class DataLocalManager {
    private static final String PREF_FIRST_INTSTALL = "PREF_FIRST_INTSTALL";
    private static final String TOKEN_VALUE = "TOKEN_VALUE";
    private static final String NAME_VALUE = "NAME_VALUE";
    private static final String FREF_OBJECT_USER = "FREF_OBJECT_USER";
    private static MySharedPreferences instance;

    private DataLocalManager() {}

    public static MySharedPreferences getInstance(Context context) {
        if (instance == null) {
            instance = new MySharedPreferences(context);
        }
        return instance;
    }

    public static void setFirstIntstalled(boolean isFirst) {
        DataLocalManager.getInstance(null).putBooleanValue(PREF_FIRST_INTSTALL, isFirst);
    }


    public static boolean getFirstIntstalled() {
        return DataLocalManager.getInstance(null).getBooleanValue(PREF_FIRST_INTSTALL);
    }

    public static void setToken(String token) {
        DataLocalManager.getInstance(null).putStringValue(TOKEN_VALUE, token);
    }

    public static String getToken() {
        return DataLocalManager.getInstance(null).getStringValue(TOKEN_VALUE);
    }

    public static  void setUserDTO(UserDTO mUserDTO){
        Gson mGson=new Gson();
        String stringJsonUser=mGson.toJson(mUserDTO);
        DataLocalManager.getInstance(null).putStringValue(FREF_OBJECT_USER,stringJsonUser);
    }

    public static UserDTO getUserDTO(){
       String stringJsonUser= DataLocalManager.getInstance(null).getStringValue(FREF_OBJECT_USER);
       Gson mGson=new Gson();
       UserDTO mUserDTO=mGson.fromJson(stringJsonUser,UserDTO.class);


       return mUserDTO;
    }
}
