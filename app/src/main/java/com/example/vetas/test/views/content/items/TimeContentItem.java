package com.example.vetas.test.views.content.items;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vetas.test.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by _vetas on 21.09.2016.
 */
public class TimeContentItem
        extends BaseContentItemFragment {

    @BindView(R.id.tv_content_item)
    protected TextView tv;


    @Override
    protected int getTitleRes() {
        return R.string.content_item_title_time;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content_item_color, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }


    @Override
    public void onResume() {
        super.onResume();
        tv.setText(DateFormat.getTimeFormat(getActivity()).format(Calendar.getInstance().getTime()));
    }
}
