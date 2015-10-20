package com.jiandanlicai.yzhlibrary.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jiandanlicai.yzhlibrary.OnViewClickListener;
import com.jiandanlicai.yzhlibrary.R;

public class Register2Fragment extends BaseFragment {


    public static Register2Fragment newInstance() {
        return new Register2Fragment();
    }

    public Register2Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private OnViewClickListener mCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnViewClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnViewClickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register2, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_content_register2);
        imageView.setOnClickListener(this);
        return view;
    }


    @Override
    public void myOnClick(View view) {
        if (mCallback != null) {
            mCallback.onViewClick(view);
        }
    }
}
