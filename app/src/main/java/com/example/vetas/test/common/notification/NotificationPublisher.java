package com.example.vetas.test.common.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by _vetas on 21.09.2016.
 */

public class NotificationPublisher {

    private static final int DEFAULT_NOTIICATION_ID = 0;

    public static void publish(@NonNull Context context, @NonNull Notification notification) {
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(DEFAULT_NOTIICATION_ID, notification);
    }
}
