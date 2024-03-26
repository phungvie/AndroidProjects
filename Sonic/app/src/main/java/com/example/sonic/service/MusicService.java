package com.example.sonic.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.sonic.MainActivity;
import com.example.sonic.MyApplication;
import com.example.sonic.R;

public class MusicService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("viet Service","onCreate");
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String stringDataIntent=intent.getStringExtra("key_data_intent");
        sendNotification(stringDataIntent);
        return START_NOT_STICKY;
    }

    private void sendNotification(String stringDataIntent) {
        Intent intent=new Intent(this, MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification=new Notification.Builder(this, MyApplication.CHANNEL_ID)
                .setContentTitle("Title viet dz")
                .setContentText(stringDataIntent)
                .setSmallIcon(R.drawable.ic_bars_sort)
                .build();
        startForeground(1,notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
