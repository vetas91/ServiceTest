package com.example.vetas.test.common.services;

import android.os.Handler;

/**
 * Simple action repeater. Used for small periods of time, less than 1 minute.
 * In Lollipop minimum {@link android.app.AlarmManager} repeating delay is 1 minute.
 * <p></p>
 * Created by _vetas on 21.09.2016.
 */
public class Repeater {

    private final Runnable runnable;
    private final int timeout;
    private Runnable repeatingRunnable;
    private Handler handler;
    private boolean isStarted;

    public Repeater(Runnable runnable, int timeout) {
        this.runnable = runnable;
        this.timeout = timeout;
    }

    public Repeater init() {
        handler = new Handler();
        repeatingRunnable = new Runnable() {
            @Override
            public void run() {
                if (runnable != null) runnable.run();
                handler.postDelayed(repeatingRunnable, timeout);
            }
        };
        isStarted = false;
        return this;
    }


    public void start() {
        if (!isStarted) {
            handler.post(repeatingRunnable);
            isStarted = true;
        }
    }

    public void startDelayed() {
        if (!isStarted) {
            handler.postDelayed(repeatingRunnable, timeout);
            isStarted = true;
        }
    }


    public void stop() {
        handler.removeCallbacks(repeatingRunnable);
        isStarted = false;
    }
}
