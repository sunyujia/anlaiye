package com.jiandanlicai.yzhlibrary.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiandanlicai.yzhlibrary.R;

public class PersonalFragment extends BaseFragment {


    public static PersonalFragment newInstance() {
        return new PersonalFragment();
    }

    public PersonalFragment() {
        // Required empty public constructor
    }

    @Override
    public void myOnClick(View view) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_center, container, false);
        return view;
    }

}
