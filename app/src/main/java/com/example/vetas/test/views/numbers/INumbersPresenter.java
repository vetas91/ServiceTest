package com.example.vetas.test.views.numbers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.example.vetas.test.common.services.NumberService;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

/**
 * Created by _vetas on 20.09.2016.
 */
public interface INumbersPresenter extends MvpPresenter<INumbersView> {


    void startService(@NonNull AppCompatActivity activity);

    void cancel(@NonNull AppCompatActivity activity);

    Intent getServiceIntent(@NonNull Context context);

}
