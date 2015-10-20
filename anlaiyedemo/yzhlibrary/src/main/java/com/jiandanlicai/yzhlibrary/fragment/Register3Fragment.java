package com.jiandanlicai.yzhlibrary.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jiandanlicai.yzhlibrary.R;

public class Register3Fragment extends BaseFragment {


    public static Register3Fragment newInstance() {
        return new Register3Fragment();
    }

    public Register3Fragment() {
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
        View view = inflater.inflate(R.layout.fragment_register3, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_content_register3);
        imageView.setOnClickListener(this);
        return view;
    }

}
