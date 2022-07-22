package com.example.test;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private final IBinder iBinder = new LocalBinder(4);
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("younes", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("younes", "onStartCommand");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    Log.d("younes", String.valueOf(i));
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d("younes", "onDestroy");
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    class LocalBinder extends Binder {
        int number;
        LocalBinder(int number) {
            this.number = number;
        }
    }
}