package com.jiandanlicai.yzhlibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jiandanlicai.yzhlibrary.fragment.BuyOneFragment;
import com.jiandanlicai.yzhlibrary.fragment.BuyThreeFragment;
import com.jiandanlicai.yzhlibrary.fragment.BuyTwoFragment;
import com.jiandanlicai.yzhlibrary.fragment.FinancingDetailFragment;
import com.jiandanlicai.yzhlibrary.fragment.FinancingFragment;
import com.jiandanlicai.yzhlibrary.fragment.PersonalFragment;
import com.jiandanlicai.yzhlibrary.fragment.Register2Fragment;
import com.jiandanlicai.yzhlibrary.fragment.Register3Fragment;
import com.jiandanlicai.yzhlibrary.fragment.RegisterFragment;
import com.jiandanlicai.yzhlibrary.fragment.YzhFragment;

public class YzhActivity extends FragmentActivity implements View.OnClickListener, OnViewClickListener {

    private int mTabTag = 1;

    private RadioButton mRB;

    private int mFromFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yzh);
        mFromFlag = getIntent().getIntExtra("from", 0);
        TextView tvBack = (TextView) findViewById(R.id.tv_back);
        tvBack.setOnClickListener(this);
        if (savedInstanceState == null) {
            MyApplication.sIsLogin = false;
            if (mFromFlag == 0) {
                getSupportFragmentManager().beginTransaction().replace(R.id.main_content, YzhFragment.newInstance(MyApplication.sIsLogin)).commit();
            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.main_content, FinancingFragment.newInstance()).commit();
                RadioButton mRB2 = (RadioButton) findViewById(R.id.rb_financing);
                mRB2.setChecked(true);
            }
        }
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.tab_rg);
        mRB = (RadioButton) findViewById(R.id.rb_yzh);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                changeContent(checkedId);
            }
        });
    }

    private void changeContent(int checkedId) {
        Fragment fragment = null;
        if (checkedId == R.id.rb_yzh) {
            fragment = YzhFragment.newInstance(MyApplication.sIsLogin);
        } else if (checkedId == R.id.rb_financing) {
            fragment = FinancingFragment.newInstance();
        } else if (checkedId == R.id.rb_personal) {
            fragment = PersonalFragment.newInstance();
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content, fragment).commit();
        }
    }

    @Override
    public void onClick(View v) {
        onViewClick(v);
    }

    @Override
    public void onViewClick(View view) {
        Fragment fragment = null;
        int i = view.getId();
        if (i == R.id.tv_back) {
            finish();
        } else if (i == R.id.iv_content_yzh) {
            if (MyApplication.sIsLogin) {//已登录
                fragment = FinancingDetailFragment.newInstance();
            } else {//未登录
                fragment = RegisterFragment.newInstance();
                //修改后进入授权页面
//                fragment = AuthorizeFragment.newInstance();
            }
        }
// else if (i == R.id.iv_content_authorize) {
//            点击授权后续操作
//            MyApplication.sIsLogin = true;
//            fragment = YzhFragment.newInstance(true);
//        }
        else if (i == R.id.iv_content_register1) {
            fragment = Register2Fragment.newInstance();
        } else if (i == R.id.iv_content_register2) {
            fragment = Register3Fragment.newInstance();
        } else if (i == R.id.iv_content_register3) {
            MyApplication.sIsLogin = true;
            if (mFromFlag == 0) {
                fragment = YzhFragment.newInstance(true);
            } else {
                fragment = FinancingFragment.newInstance();
            }
        } else if (i == R.id.btn_buy) {
            fragment = BuyOneFragment.newInstance();
        } else if (i == R.id.iv_content_buy) {
            fragment = BuyTwoFragment.newInstance();
        } else if (i == R.id.iv_content_buy2) {
            fragment = BuyThreeFragment.newInstance();
        } else if (i == R.id.iv_content_buy3) {
            if (mTabTag == 2) {
                mRB.setChecked(true);
            }
            fragment = YzhFragment.newInstance(MyApplication.sIsLogin);
        } else if (i == R.id.iv_content_financing) {
            mTabTag = 2;
            if (!MyApplication.sIsLogin) {
                fragment = RegisterFragment.newInstance();
            } else {
                fragment = FinancingDetailFragment.newInstance();
            }
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content, fragment).commit();
        }
    }
}
