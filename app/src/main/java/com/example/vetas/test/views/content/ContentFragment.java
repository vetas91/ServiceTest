package com.example.vetas.test.views.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vetas.test.R;
import com.hannesdorfmann.mosby.mvp.MvpFragment;

/**
 * Created by _vetas on 20.09.2016.
 */
public class ContentFragment
        extends MvpFragment<IContentView, IContentPresenter>
        implements IContentView {

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
    }
}
