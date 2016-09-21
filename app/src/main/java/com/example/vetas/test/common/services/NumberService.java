package com.example.vetas.test.common.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.example.vetas.test.common.Constant;

import java.util.Random;

/**
 * Created by _vetas on 21.09.2016.
 */
public class NumberService extends IntentService {

    private static final String TAG = NumberService.class.getName();

    public NumberService() {
        super(TAG);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "Result -> " + generateNumber());
    }


    private int generateNumber() {
        return new Random().nextInt(Constant.Config.NUMBER_INTERVAL);
    }


}