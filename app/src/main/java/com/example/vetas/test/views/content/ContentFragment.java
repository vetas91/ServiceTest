package com.example.vetas.test.views.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vetas.test.R;
import com.hannesdorfmann.mosby.mvp.MvpFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by _vetas on 20.09.2016.
 */
public class ContentFragment
        extends MvpFragment<IContentView, IContentPresenter>
        implements IContentView {

    @BindView(R.id.vp_content)
    ViewPager vp;

    @BindView(R.id.pts_content)
    PagerTabStrip tabStrips;


    @Override
    public IContentPresenter createPresenter() {
        return new ContentPresenter();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initViews();
    }


    private void initViews() {
        PagerAdapter adapter = new ContentViewPagerAdapte(getChildFragmentManager(),
                presenter.getContent());
        vp.setAdapter(adapter);
        // fix of https://code.google.com/p/android/issues/detail?id=183127
        vp.setCurrentItem(1, false);
        vp.postDelayed(new Runnable() {
            @Override
            public void run() {
                vp.setCurrentItem(0, false);
            }
        }, 10);
    }
}
