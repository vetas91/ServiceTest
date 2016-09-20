package com.example.vetas.test.views.content.items;

import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

/**
 * Created by _vetas on 21.09.2016.
 */
public abstract class BaseContentItemFragment extends Fragment {

    public String getName() {
        if (getActivity() != null) {
            return getString(getTitleRes());
        }
        return "";
    }

    @StringRes
    protected abstract int getTitleRes();
}
