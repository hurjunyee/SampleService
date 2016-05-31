package com.example.administrator.sampleservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016-05-31.
 */
public class MyService extends Service implements Runnable {

    public static final String TAG = "MyService";
    private int count = 0;

    public void onCreate() {
        Log.d(TAG, "onCreate 서비스");
        super.onCreate();

        Thread myThread = new Thread(this);
        myThread.run();
    }

    @Override
    public void run() {
        while(true) {
            try {
                Log.i(TAG, "my service called #" + count);
                count++;

                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Log.e(TAG, e.toString());
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
