package com.example.vetas.test.views.auth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.example.vetas.test.models.google.Authenticator;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

/**
 * Created by _vetas on 20.09.2016.
 */
public class AuthPresenter
        extends MvpBasePresenter<IAuthView>
        implements IAuthPresenter, GoogleApiClient.OnConnectionFailedListener {

    private Authenticator authenticator;

    public void signIn(@NonNull AppCompatActivity activity) {
        checkAuthenticator(activity);
        if (getView() != null) {
            getView().openSignInIntent(Auth.GoogleSignInApi.getSignInIntent(authenticator.getClient()));
        }
    }


    public void handleResult(@NonNull Intent data) {
        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
        boolean status = result.isSuccess();
        if (getView() != null) {
            if (status) {
                GoogleSignInAccount account = result.getSignInAccount();
                getView().onSuccess(account.getDisplayName());
            } else {
                getView().onError();
            }
        }
    }

    private void checkAuthenticator(AppCompatActivity activity) {
        if (authenticator == null) {
            authenticator = Authenticator.with(activity, this);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        if (getView() != null) {
            getView().onError();
        }
    }
}
