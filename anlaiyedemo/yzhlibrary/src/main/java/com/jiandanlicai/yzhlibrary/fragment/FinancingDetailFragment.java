package com.jiandanlicai.yzhlibrary.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiandanlicai.yzhlibrary.R;

public class FinancingDetailFragment extends BaseFragment {


    public static FinancingDetailFragment newInstance() {
        return new FinancingDetailFragment();
    }

    public FinancingDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_financing_detail, container, false);
        view.findViewById(R.id.btn_buy).setOnClickListener(this);
        return view;
    }


    @Override
    public void myOnClick(View view) {
        if (mCallback != null) {
            mCallback.onViewClick(view);
        }
    }
}
