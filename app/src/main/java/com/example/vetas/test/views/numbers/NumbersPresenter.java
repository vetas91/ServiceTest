package com.example.vetas.test.views.numbers;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.example.vetas.test.common.services.NumberService;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

/**
 * Created by _vetas on 20.09.2016.
 */
public class NumbersPresenter
        extends MvpBasePresenter<INumbersView>
        implements INumbersPresenter {

    // didn't use AlarmManager cause to large min timeout (1 min)
//    private AlarmManager alarmManager;

    @Override
    public void startService(@NonNull AppCompatActivity activity) {
        // stop old
        cancel(activity);
        // start new one
        activity.startService(getServiceIntent(activity));
//        alarmManager = (AlarmManager) activity.getSystemService(Context.ALARM_SERVICE);

//        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
//                Constant.Config.MESSAGE_TIMEOUT,
//                getPendingIntent(activity));
    }

    private PendingIntent getPendingIntent(@NonNull AppCompatActivity activity) {
        Intent i = new Intent(activity, NumberService.class);
        return PendingIntent.getService(activity, NumberService.REQUEST_CODE,
                i, PendingIntent.FLAG_UPDATE_CURRENT);
    }


    @Override
    public void cancel(AppCompatActivity activity) {
        // stop alarm manager
//        if (alarmManager != null) {
//            alarmManager.cancel(getPendingIntent(activity));
//        }
        // stop service
        activity.stopService(getServiceIntent(activity));
    }

    @Override
    public Intent getServiceIntent(@NonNull Context context) {
        return new Intent(context, NumberService.class);
    }
}
