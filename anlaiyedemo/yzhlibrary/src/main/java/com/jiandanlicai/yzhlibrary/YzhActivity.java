package com.jiandanlicai.yzhlibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jiandanlicai.yzhlibrary.fragment.BindCardFragment;
import com.jiandanlicai.yzhlibrary.fragment.BuyOneFragment;
import com.jiandanlicai.yzhlibrary.fragment.BuyThreeFragment;
import com.jiandanlicai.yzhlibrary.fragment.BuyTwoFragment;
import com.jiandanlicai.yzhlibrary.fragment.FinancingDetailFragment;
import com.jiandanlicai.yzhlibrary.fragment.FinancingFragment;
import com.jiandanlicai.yzhlibrary.fragment.PayPwdFragment;
import com.jiandanlicai.yzhlibrary.fragment.PersonalFragment;
import com.jiandanlicai.yzhlibrary.fragment.RegisterFragment;
import com.jiandanlicai.yzhlibrary.fragment.YzhFragment;

public class YzhActivity extends FragmentActivity implements View.OnClickListener, OnViewClickListener {

    private int mFromFlag = 0;

    public static final int GO_TO_FINANCING = 2;

    public static final int GO_TO_YZH = 0;

    public static final String EXTRA_FROM = "extra_from";

    private ImageView mIvIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_yzh);
        mFromFlag = getIntent().getIntExtra(EXTRA_FROM, 0);
        TextView tvBack = (TextView) findViewById(R.id.tv_back);
        tvBack.setOnClickListener(this);
        mIvIntro = (ImageView) findViewById(R.id.iv_yzh_intro);
        mIvIntro.setOnClickListener(this);
        if (savedInstanceState == null) {
            MyApplication.sIsLogin = false;
            if (mFromFlag == GO_TO_YZH) {
                mIvIntro.setVisibility(View.VISIBLE);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_content, YzhFragment.newInstance(MyApplication.sIsLogin)).commit();
            } else if (mFromFlag == GO_TO_FINANCING) {
                mIvIntro.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_content, FinancingFragment.newInstance()).commit();
                RadioButton mRB2 = (RadioButton) findViewById(R.id.rb_financing);
                mRB2.setChecked(true);
            }
        }
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.tab_rg);
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
            fragment = FinancingDetailFragment.newInstance();
        } else if (i == R.id.iv_content_register) {
            fragment = PayPwdFragment.newInstance();
        } else if (i == R.id.iv_content_pay_pwd) {
            fragment = BindCardFragment.newInstance();
        } else if (i == R.id.iv_content_bind_card) {
            MyApplication.sIsLogin = true;
            fragment = BuyOneFragment.newInstance();
        } else if (i == R.id.btn_buy) {
            if (MyApplication.sIsLogin) {
                fragment = BuyOneFragment.newInstance();
            } else {
                fragment = RegisterFragment.newInstance();
            }
        } else if (i == R.id.iv_content_buy) {
            fragment = BuyTwoFragment.newInstance();
        } else if (i == R.id.iv_content_buy2) {
            fragment = BuyThreeFragment.newInstance();
            if (mFromFlag == 2) {
                Utils.showCashDialog(this, "恭喜您已获得4次减免服务费资格，可在结算时自动使用");
            }
        } else if (i == R.id.iv_content_buy3) {
            fragment = YzhFragment.newInstance(MyApplication.sIsLogin);
            mFromFlag = 0;
        } else if (i == R.id.iv_content_financing) {
            fragment = FinancingDetailFragment.newInstance();
        } else if (i == R.id.iv_yzh_intro) {
            mIvIntro.setVisibility(View.GONE);
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content, fragment).commit();
        }
    }
}
