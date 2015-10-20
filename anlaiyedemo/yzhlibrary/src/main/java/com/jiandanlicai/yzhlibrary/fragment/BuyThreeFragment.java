package com.jiandanlicai.yzhlibrary.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jiandanlicai.yzhlibrary.R;

public class BuyThreeFragment extends BaseFragment {


    public static BuyThreeFragment newInstance() {
        return new BuyThreeFragment();
    }

    public BuyThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public void myOnClick(View view) {
        if (mCallback != null) {
            mCallback.onViewClick(view);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy3, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_content_buy3);
        imageView.setOnClickListener(this);
        return view;
    }

}
