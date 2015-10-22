package com.yunzhanghu.anlaiyedemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioGroup;

/**
 * Created by max on 15/10/12.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private ChangeContentListener mCallback;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, null);
        ListView homeLeftList = (ListView) rootView.findViewById(R.id.lv_home_left);
        HomeLeftListAdapter adapter = new HomeLeftListAdapter(getActivity());
        homeLeftList.setAdapter(adapter);
//        旧的入口
        rootView.findViewById(R.id.iv_goods).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (ChangeContentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement ChangeContentListener");
        }
    }

    @Override
    public void onClick(View v) {
//        旧的入口
//        mCallback.onContentClickListener(v);
    }

    public interface ChangeContentListener {
        void changeContent(RadioGroup group, int checkedId);

        void onContentClickListener(View v);
    }

}
