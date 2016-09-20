package com.example.vetas.test.views.content;


import android.support.v4.app.Fragment;

import com.example.vetas.test.views.content.items.BaseContentItemFragment;

import java.util.List;

/**
 * Created by _vetas on 21.09.2016.
 */
public class ContentHolder {


    private List<BaseContentItemFragment> fragments;


    public ContentHolder(List<BaseContentItemFragment> fragments) {
        this.fragments = fragments;
    }

    public Fragment getItem(int position) {
        return fragments != null ? fragments.get(position) : null;
    }

    public int getCount() {
        return fragments != null ? fragments.size() : 0;
    }

    public String getTitle(int position) {
        return fragments != null ? fragments.get(position).getName() : "";
    }
}
