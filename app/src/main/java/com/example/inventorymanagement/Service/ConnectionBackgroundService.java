package com.example.inventorymanagement.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.Toast;

import com.example.inventorymanagement.DataAccess.Interface.IServiceDao;
import com.example.inventorymanagement.DataAccess.ServiceDao;


public class ConnectionBackgroundService extends Service {

    public Context context = this;
    private IServiceDao _serviceDao;
    private Handler _handler;
    private Runnable _runnable;
    private boolean _isStarted;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        _serviceDao = new ServiceDao();


        _handler = new Handler();
        _runnable = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context,Boolean.toString(_serviceDao.IsConnectionActive()),Toast.LENGTH_LONG).show();
                _handler.postDelayed(_runnable, 10000);
            }
        };

        _handler.postDelayed(_runnable, 15000);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!_isStarted){
            _isStarted = true;
            HandleTimerCallback();
        }
        return Service.START_NOT_STICKY;
    }

    void HandleTimerCallback()
    {
        _handler = new Handler(Looper.myLooper());


        _runnable = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context,Boolean.toString(_serviceDao.IsConnectionActive()),Toast.LENGTH_LONG).show();
                _handler.postDelayed(_runnable, 10000);
            }
        };

        _handler.postDelayed(_runnable, 15000);

    }

}
