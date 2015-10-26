package com.yunzhanghu.anlaiyedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiandanlicai.yzhlibrary.YzhActivity;

/**
 * Created by max on 15/10/12.
 */
public class UserInfoFragment extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_userinfo, null);
        rootView.findViewById(R.id.order1_layout).setOnClickListener(this);
        rootView.findViewById(R.id.order2_layout).setOnClickListener(this);
        rootView.findViewById(R.id.layout_anlaiye_financial).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onClick(View v) {
        int fromTag = 0;
        switch (v.getId()) {
            case R.id.layout_anlaiye_financial:
                Intent intent = new Intent(getActivity(), YzhActivity.class);
                intent.putExtra(YzhActivity.EXTRA_FROM, YzhActivity.GO_TO_YZH);
                startActivity(intent);
                break;
            case R.id.order1_layout://代付款
//                fromTag = 0;
//                Intent intent1 = new Intent(getActivity(), MyOrderActivity.class);
//                intent1.putExtra("from", fromTag);
//                startActivity(intent1);
                break;
            case R.id.order2_layout://待抢单
                fromTag = 1;
                Intent intent2 = new Intent(getActivity(), MyOrderActivity.class);
                intent2.putExtra("from", fromTag);
                startActivity(intent2);
                break;
        }
    }
}
