package com.yunzhanghu.anlaiyedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by max on 15/10/12.
 */
public class UserInfoFragment extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_userinfo, null);
        rootView.findViewById(R.id.layout_money).setOnClickListener(this);
        rootView.findViewById(R.id.layout_reward).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.layout_money) {
            startActivity(new Intent(getActivity(), ZeroPayActivity.class));
        } else {
            startActivity(new Intent(getActivity(), RewardsActivity.class));
        }
    }
}
