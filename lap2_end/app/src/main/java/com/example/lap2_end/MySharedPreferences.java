package com.example.lap2_end;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {
    private static final String MY_SHARED_PRE="MY_SHARED_PRE";
    private Context mContext;

    public MySharedPreferences(Context mContext) {
        this.mContext = mContext;
    }
    public void putBooleanValue(String key,boolean value){
        SharedPreferences mSharedPreferences=mContext.getSharedPreferences(MY_SHARED_PRE,Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor=mSharedPreferences.edit();
        mEditor.putBoolean(key,value);
        mEditor.apply();
    }

    public boolean getBooleanValue(String key){
        SharedPreferences mSharedPreferences=mContext.getSharedPreferences(MY_SHARED_PRE,Context.MODE_PRIVATE);
        return mSharedPreferences.getBoolean(key,false);
    }

    public void putStringValue(String key,String value){
        SharedPreferences mSharedPreferences=mContext.getSharedPreferences(MY_SHARED_PRE,Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor=mSharedPreferences.edit();
        mEditor.putString(key,value);
        mEditor.apply();
    }

    public String getStringValue(String key){
        SharedPreferences mSharedPreferences=mContext.getSharedPreferences(MY_SHARED_PRE,Context.MODE_PRIVATE);
        return mSharedPreferences.getString(key,"");
    }
}
