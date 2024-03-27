package com.example.sonic.service;

import android.app.ForegroundServiceTypeException;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;

import com.example.sonic.MainActivity;
import com.example.sonic.MyApplication;
import com.example.sonic.R;
import com.example.sonic.network.model.SongDTO;

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
        Bundle bundle=intent.getExtras();
        if(bundle!=null){
            SongDTO songDTO= (SongDTO) bundle.get("ob_song");
            sendNotification(songDTO);
        }

        return START_NOT_STICKY;
    }

    private void sendNotification(SongDTO song) {
        Intent intent=new Intent(this, MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);


        //
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.images);
        //

        //
        RemoteViews remoteViews=new RemoteViews(getPackageName(),R.layout.layout_custom_notification);
        remoteViews.setTextViewText(R.id.tv_title_song,song.getName());
        remoteViews.setTextViewText(R.id.tv_single_song,song.getArtistName());
        remoteViews.setImageViewBitmap(R.id.imageViewSong,bitmap);
        //
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
