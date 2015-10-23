package com.jiandanlicai.yzhlibrary.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jiandanlicai.yzhlibrary.R;

public class RegisterFragment extends BaseFragment {

    private int mFromFlag;

    public static RegisterFragment newInstance(int fromFlag) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("flag", fromFlag);
        fragment.setArguments(bundle);
        return fragment;
    }

    public RegisterFragment() {
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
            mFromFlag = getArguments().getInt("flag");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_content_register);
        if (mFromFlag == 1) {
            imageView.setImageResource(R.drawable.register_1_no);
        } else {
            imageView.setImageResource(R.drawable.register_1);
        }
        imageView.setOnClickListener(this);
        return view;
    }

}
