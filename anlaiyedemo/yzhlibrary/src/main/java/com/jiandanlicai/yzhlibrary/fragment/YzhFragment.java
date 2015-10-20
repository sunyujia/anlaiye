package com.jiandanlicai.yzhlibrary.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jiandanlicai.yzhlibrary.R;

public class YzhFragment extends BaseFragment {

    private boolean mIsLogin;

    public static YzhFragment newInstance(boolean isLogin) {
        YzhFragment fragment = new YzhFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("login", isLogin);
        fragment.setArguments(bundle);
        return fragment;
    }

    public YzhFragment() {
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
        if (getArguments() != null) {
            mIsLogin = getArguments().getBoolean("login");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yzh, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_content_yzh);
        if (mIsLogin) {
            imageView.setImageResource(R.drawable.yunzhanghu);
        } else {
            imageView.setImageResource(R.drawable.yunzhanghu_unlogin);
        }
        imageView.setOnClickListener(this);
        return view;
    }

}
