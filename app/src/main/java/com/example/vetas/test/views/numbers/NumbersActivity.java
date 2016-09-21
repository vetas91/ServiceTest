package com.example.vetas.test.views.numbers;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.vetas.test.R;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

/**
 * Created by _vetas on 20.09.2016.
 */
public class NumbersActivity
        extends MvpActivity<INumbersView, INumbersPresenter>
        implements INumbersView {

    @NonNull
    @Override
    public INumbersPresenter createPresenter() {
        return new NumbersPresenter();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        startService();
    }


    public void startService() {
        presenter.startService(this);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        presenter.cancel();
    }
}
