package com.example.vetas.test.common.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.vetas.test.R;
import com.example.vetas.test.common.Constant;

/**
 * Created by _vetas on 21.09.2016.
 */

public class NotificationCreator {

    public static Notification create(@NonNull Context context, int value) {
        return create(context, null, value);
    }

    public static Notification create(@NonNull Context context, @Nullable Class clazz, int value) {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(context.getString(R.string.number_service_notification_title));
        String message = context.getString(R.string.number_service_notification_massage, String.valueOf(value));
        builder.setContentText(message);
        builder.setSmallIcon(R.drawable.ic_stat_name);
        if (clazz != null) {
            Intent resultIntent = new Intent(context, clazz);
            resultIntent.putExtra(Constant.Keys.lastValue, value);
            PendingIntent target = getTargetIntent(context, resultIntent);
            builder.setContentIntent(target);
        }
        return builder.build();
    }


    public static PendingIntent getTargetIntent(Context context, Intent resultIntent) {

        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        return resultPendingIntent;
    }

}