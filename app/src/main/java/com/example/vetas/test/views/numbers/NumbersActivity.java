package com.example.vetas.test.views.numbers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.example.vetas.test.R;
import com.example.vetas.test.common.listeners.IResultListener;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by _vetas on 20.09.2016.
 */
public class NumbersActivity
        extends MvpActivity<INumbersView, INumbersPresenter>
        implements INumbersView {


    @BindView(R.id.tv_numbers_view_indicator)
    protected TextView tvIndicator;

    private NumbersServiceConnection localConnection;

    @NonNull
    @Override
    public INumbersPresenter createPresenter() {
        return new NumbersPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ButterKnife.bind(this);
        localConnection = new NumbersServiceConnection();
        localConnection.setListener(new IResultListener<Integer>() {
            @Override
            public void onResult(Integer result) {
                update(result);
            }
        });
        startService();
    }

    public void startService() {
        presenter.startService(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        presenter.cancel(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!localConnection.isBound()) {
            Intent serviceIntent = presenter.getServiceIntent(this);
            bindService(
                    serviceIntent,
                    localConnection,
                    BIND_ADJUST_WITH_ACTIVITY);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (localConnection.isBound()) {
            unbindService(localConnection);
            localConnection.setBound(false);
        }
    }

    @Override
    protected void onDestroy() {
        localConnection.setListener(null);
        super.onDestroy();
    }

    private void update(Integer value) {
        tvIndicator.setText(getString(R.string.number_service_notification_massage,
                value != null ? value.toString() : " - "));
    }
}

