package com.example.vetas.test.models.google;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by _vetas on 20.09.2016.
 */
public class Authenticator implements GoogleApiClient.OnConnectionFailedListener {

    private final AppCompatActivity activity;
    private final GoogleApiClient.OnConnectionFailedListener failedListener;
    private GoogleApiClient client;

    private Authenticator(
            @NonNull AppCompatActivity activity,
            @Nullable GoogleApiClient.OnConnectionFailedListener failedListener) {
        this.activity = activity;
        this.failedListener = failedListener;
    }

    public static Authenticator with(
            @NonNull AppCompatActivity activity,
            @Nullable GoogleApiClient.OnConnectionFailedListener failedListener) {
        Authenticator authentificator = new Authenticator(activity, failedListener);
        authentificator.prepare();
        return authentificator;
    }


    private void prepare() {
        GoogleSignInOptions options = createOptions();
        client = getClient(options, this);
    }


    private GoogleApiClient getClient(
            @NonNull GoogleSignInOptions options,
            @NonNull GoogleApiClient.OnConnectionFailedListener failedListener) {
        GoogleApiClient client = new GoogleApiClient.Builder(activity)
                .enableAutoManage(activity, failedListener)
                .addApi(Auth.GOOGLE_SIGN_IN_API, options)
                .build();
        return client;
    }

    public GoogleApiClient getClient() {
        return client;
    }

    private GoogleSignInOptions createOptions() {
        GoogleSignInOptions options =
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .build();
        return options;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        if (failedListener != null) {
            failedListener.onConnectionFailed(connectionResult);
        }
    }
}
