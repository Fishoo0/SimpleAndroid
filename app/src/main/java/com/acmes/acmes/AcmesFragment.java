package com.acmes.acmes;

import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.acmes.simpleandroid.mvc.SimpleApplication;
import com.acmes.simpleandroid.mvc.SimpleFragment;
import com.acmes.simpleandroid.mvc.model.SimpleRequest;
import com.acmes.simpleandroid.mvc.model.SimpleResponse;

/**
 * Created by fishyu on 2018/2/26.
 */

public abstract class AcmesFragment extends SimpleFragment {

    private SwipeRefreshLayout mSwipeRefreshLayout = null;

    private void initSwipeRefreshLayout() {
        if (mSwipeRefreshLayout == null) {
            View view = null;
            if (getView() != null) {
                view = getView().findViewById(R.id.swipe_refresh_layout);
            }
            if (view instanceof SwipeRefreshLayout) {
                mSwipeRefreshLayout = (SwipeRefreshLayout) view;
            } else {
                Log.e(TAG, "Find no SwipeRefreshLayout !");
                mSwipeRefreshLayout = null;
            }
        }
    }

    /**
     * Getting swipe refresh layout
     *
     * @return
     */
    protected SwipeRefreshLayout getSwipeRefreshLayout() {
        initSwipeRefreshLayout();
        return mSwipeRefreshLayout;
    }

    @Override
    public void onRequestStart(SimpleRequest request) {
        super.onRequestStart(request);
        getSwipeRefreshLayout().setRefreshing(true);
    }

    @Override
    public void onFailure(SimpleRequest request, Throwable exception) {
        super.onFailure(request, exception);
        Log.e(TAG, exception.getMessage());
        Toast.makeText(SimpleApplication.getInstance(), exception.getMessage(), Toast.LENGTH_SHORT).show();

        getSwipeRefreshLayout().setRefreshing(false);
    }

    @Override
    public void onResponse(SimpleRequest request, SimpleResponse response) {
        super.onResponse(request, response);

        getSwipeRefreshLayout().setRefreshing(false);
    }
}
