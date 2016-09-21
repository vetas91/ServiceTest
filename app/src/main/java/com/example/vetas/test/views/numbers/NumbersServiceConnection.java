package com.example.vetas.test.views.numbers;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.example.vetas.test.common.listeners.IResultListener;
import com.example.vetas.test.common.services.NumbersBinder;

/**
 * Created by _vetas on 22.09.2016.
 */

public class NumbersServiceConnection implements ServiceConnection {

    private NumbersBinder binder;
    private boolean bound;
    private IResultListener<Integer> listener;

    @Override
    public void onServiceConnected(ComponentName className,
                                   IBinder service) {
        binder = (NumbersBinder) service;
        binder.get().setUiActive(true);
        binder.setListener(listener);
        bound = true;
    }

    @Override
    public void onServiceDisconnected(ComponentName arg0) {
        // clean listener and activity reference
        binder.setListener(null);
        binder.get().setUiActive(false);
        bound = false;
    }


    public void setListener(IResultListener<Integer> listener) {
        this.listener = listener;
        if (binder != null) {
            binder.setListener(listener);
        }
    }

    public boolean isBound() {
        return bound;
    }

    public void setBound(boolean bound) {
        this.bound = bound;
        if (binder != null) {
            binder.get().setUiActive(false);
        }
    }

}
