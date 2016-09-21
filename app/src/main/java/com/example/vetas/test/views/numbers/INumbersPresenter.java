package com.example.vetas.test.views.numbers;

import android.support.v7.app.AppCompatActivity;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;

/**
 * Created by _vetas on 20.09.2016.
 */
public interface INumbersPresenter extends MvpPresenter<INumbersView> {


    void startService(AppCompatActivity activity);

    void cancel();

}
