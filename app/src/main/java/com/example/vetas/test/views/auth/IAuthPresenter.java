package com.example.vetas.test.views.auth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;

/**
 * Created by _vetas on 20.09.2016.
 */
public interface IAuthPresenter extends MvpPresenter<IAuthView> {

    void signIn(@NonNull AppCompatActivity activity);

    void handleResult(@NonNull Intent data);

}
