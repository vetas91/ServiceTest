package com.example.vetas.test.common.services;

import android.os.Binder;
import android.support.annotation.NonNull;

import com.example.vetas.test.common.listeners.IResultListener;

/**
 * Created by _vetas on 22.09.2016.
 */

public class NumbersBinder extends Binder {

    private final NumberService service;

    private IResultListener<Integer> listener;

    public NumbersBinder(@NonNull NumberService service) {
        this.service = service;
    }

    public NumberService get() {
        return service;
    }

    public void updateValue(int value) {
        if (listener != null) {
            listener.onResult(value);
        }
    }

    public void setListener(IResultListener<Integer> listener) {
        this.listener = listener;
    }
}
