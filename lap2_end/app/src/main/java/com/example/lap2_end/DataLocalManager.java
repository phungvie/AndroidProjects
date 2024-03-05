package com.example.lap2_end;

import android.content.Context;

public class DataLocalManager {
    private static final String PREF_FIRST_INTSTALL = "PREF_FIRST_INTSTALL";
    private static final String TOKEN_VALUE = "TOKEN_VALUE";
    private static final String NAME_VALUE = "NAME_VALUE";
    private static DataLocalManager instance;
    private MySharedPreferences mySharedPreferences;

    private DataLocalManager() {
    }

    ;

    public static void init(Context context) {
        instance = new DataLocalManager();
        instance.mySharedPreferences = new MySharedPreferences(context);
    }

    public static DataLocalManager getInstance() {
        if (instance == null) {
            instance = new DataLocalManager();
        }
        return instance;
    }

    public void setFirstIntstalled(boolean isFirst) {
        DataLocalManager.getInstance().mySharedPreferences.putBooleanValue(PREF_FIRST_INTSTALL, isFirst);
    }


    public boolean getFirstIntstalled() {
        return DataLocalManager.getInstance().mySharedPreferences.getBooleanValue(PREF_FIRST_INTSTALL);
    }

    public void setToken(String token) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(TOKEN_VALUE, token);
    }

    public String getToken() {
        return DataLocalManager.getInstance().mySharedPreferences.getStringValue(TOKEN_VALUE);
    }

    public void setName(String name) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(NAME_VALUE, name);
    }

    public String getName() {
        return DataLocalManager.getInstance().mySharedPreferences.getStringValue(NAME_VALUE);
    }
}
