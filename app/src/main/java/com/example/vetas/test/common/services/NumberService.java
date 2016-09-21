package com.example.vetas.test.common.services;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.vetas.test.common.Constant;
import com.example.vetas.test.common.notification.NotificationCreator;
import com.example.vetas.test.common.notification.NotificationPublisher;
import com.example.vetas.test.views.numbers.detail.LastNumberActivity;

import java.util.Random;

/**
 * Created by _vetas on 21.09.2016.
 */
public class NumberService extends Service {

    public static final int REQUEST_CODE = 1001;
    private static final String TAG = NumberService.class.getName();

    private Repeater repeater;
    private NumbersBinder numbersBinder = new NumbersBinder(this);
    private boolean isUiActive;
    private Runnable runnableAction = new Runnable() {
        @Override
        public void run() {
            notifyUi();
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        isUiActive = true;
        return numbersBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        isUiActive = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        checkRepeater();
        repeater.startDelayed();
        isUiActive = true;
        return super.onStartCommand(intent, flags, startId);
    }


    private void notifyUi() {
        final int generatedValue = generateNumber();
        Log.i(TAG, "Result -> " + generatedValue);
        if (isUiActive) {
            // TODO: 22.09.2016
            numbersBinder.updateValue(generatedValue);
        } else {
            Notification notification = NotificationCreator.create(this,
                    LastNumberActivity.class, generatedValue);
            NotificationPublisher.publish(this, notification);
        }
    }

    private void checkRepeater() {
        if (repeater == null) {
            repeater = new Repeater(runnableAction, Constant.Config.MESSAGE_TIMEOUT)
                    .init();
        }
    }


    @Override
    public void onDestroy() {
        repeater.stop();
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        isUiActive = false;
        return super.onUnbind(intent);
    }

    private int generateNumber() {
        return new Random().nextInt(Constant.Config.NUMBER_INTERVAL);
    }


    public void setUiActive(boolean uiActive) {
        isUiActive = uiActive;
    }
}