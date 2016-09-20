package com.example.vetas.test.views.content;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by _vetas on 21.09.2016.
 */
public class ContentViewPagerAdapte extends FragmentStatePagerAdapter {

    private final ContentHolder contentHolder;

    public ContentViewPagerAdapte(FragmentManager fm, ContentHolder contentHolder) {
        super(fm);
        this.contentHolder = contentHolder;
    }

    @Override
    public Fragment getItem(int position) {
        return contentHolder.getItem(position);
    }

    @Override
    public int getCount() {
        return contentHolder.getCount();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return contentHolder.getTitle(position);
    }
}
