package com.example.vetas.test.views.content;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;

/**
 * Created by _vetas on 20.09.2016.
 */
public interface IContentPresenter extends MvpPresenter<IContentView> {

    ContentHolder getContent();
}
