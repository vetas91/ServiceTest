package com.example.vetas.test.views.content;

import com.example.vetas.test.views.content.items.BaseContentItemFragment;
import com.example.vetas.test.views.content.items.ColorContentItem;
import com.example.vetas.test.views.content.items.TimeContentItem;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by _vetas on 20.09.2016.
 */
public class ContentPresenter
        extends MvpBasePresenter<IContentView>
        implements IContentPresenter {
    @Override
    public ContentHolder getContent() {
        List<BaseContentItemFragment> fragments = new ArrayList<>(2);
        fragments.add(new ColorContentItem());
        fragments.add(new TimeContentItem());
        return new ContentHolder(fragments);
    }
}
