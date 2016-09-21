package com.example.vetas.test.views.numbers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.vetas.test.common.Constant;
import com.example.vetas.test.common.services.NumberService;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

/**
 * Created by _vetas on 20.09.2016.
 */
public class NumbersPresenter
        extends MvpBasePresenter<INumbersView>
        implements INumbersPresenter {

    private AlarmManager alarmManager;
    private PendingIntent pi;

    @Override
    public void startService(AppCompatActivity activity) {
        alarmManager = (AlarmManager) activity.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(activity, NumberService.class);
        pi = PendingIntent.getService(activity, Constant.Config.MESSAGE_TIMEOUT,
                i, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                Constant.Config.MESSAGE_TIMEOUT,
                Constant.Config.MESSAGE_TIMEOUT,
                pi);
    }


    @Override
    public void cancel() {
        if (alarmManager != null) {
            alarmManager.cancel(pi);
        }
    }
}
