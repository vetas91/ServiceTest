package com.example.vetas.test.views.numbers.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.vetas.test.R;
import com.example.vetas.test.common.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by _vetas on 20.09.2016.
 */
public class LastNumberActivity extends AppCompatActivity {


    @BindView(R.id.tv_numbers_view_indicator)
    protected TextView tvIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_last_detail);
        ButterKnife.bind(this);
        handle(getIntent());
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handle(intent);
    }

    private void handle(@Nullable Intent intent) {
        if (intent != null && intent.hasExtra(Constant.Keys.lastValue)) {
            int lastValue = intent.getExtras().getInt(Constant.Keys.lastValue, 0);
            update(lastValue);
        }
    }

    private void update(Integer value) {
        tvIndicator.setText(getString(R.string.number_service_notification_massage,
                value != null ? value.toString() : " - "));
    }
}

