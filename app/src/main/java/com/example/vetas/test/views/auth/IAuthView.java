package com.example.vetas.test.views.auth;

import android.content.Intent;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by _vetas on 20.09.2016.
 */
public interface IAuthView extends MvpView {

    void openSignInIntent(Intent intent);

    void onSuccess(String name);

    void onError();
}
