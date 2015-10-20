package com.jiandanlicai.yzhlibrary.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.jiandanlicai.yzhlibrary.OnViewClickListener;

/**
 * BaseFragment
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    OnViewClickListener mCallback;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            mCallback = (OnViewClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnViewClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    @Override
    public void onClick(View v) {
        myOnClick(v);
    }

    public abstract void myOnClick(View view);

}
