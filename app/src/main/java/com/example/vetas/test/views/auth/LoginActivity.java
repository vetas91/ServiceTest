package com.example.vetas.test.views.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.vetas.test.R;
import com.example.vetas.test.base.Constant;
import com.example.vetas.test.views.numbers.NumbersActivity;
import com.google.android.gms.common.SignInButton;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity
        extends MvpActivity<IAuthView, AuthPresenter>
        implements IAuthView {

    @BindView(R.id.btn_auth_view_sign_in)
    protected SignInButton btnSigIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @NonNull
    @Override
    public AuthPresenter createPresenter() {
        return new AuthPresenter();
    }


    @OnClick(R.id.btn_auth_view_sign_in)
    protected void signInClick() {
        presenter.signIn(this);
    }

    @Override
    public void openSignInIntent(Intent intent) {
        startActivityForResult(intent, Constant.Keys.googleSignInRequestCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.Keys.googleSignInRequestCode) {
            presenter.handleResult(data);
        }
    }


    @Override
    public void onSuccess(@NonNull String name) {
        showMessage(getString(R.string.auth_view_sign_in_success, name));
        Intent intent = new Intent(this, NumbersActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onError() {
        showMessage(getString(R.string.auth_view_sign_in_error));
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
