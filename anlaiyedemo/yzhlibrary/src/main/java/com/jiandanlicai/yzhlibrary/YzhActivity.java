package com.jiandanlicai.yzhlibrary;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jiandanlicai.yzhlibrary.fragment.BuyOneFragment;
import com.jiandanlicai.yzhlibrary.fragment.BuyThreeFragment;
import com.jiandanlicai.yzhlibrary.fragment.BuyTwoFragment;
import com.jiandanlicai.yzhlibrary.fragment.FinancingDetailFragment;
import com.jiandanlicai.yzhlibrary.fragment.FinancingFragment;
import com.jiandanlicai.yzhlibrary.fragment.PersonalFragment;
import com.jiandanlicai.yzhlibrary.fragment.PayPwdFragment;
import com.jiandanlicai.yzhlibrary.fragment.BindCardFragment;
import com.jiandanlicai.yzhlibrary.fragment.RegisterFragment;
import com.jiandanlicai.yzhlibrary.fragment.YzhFragment;

public class YzhActivity extends FragmentActivity implements View.OnClickListener, OnViewClickListener {

    private int mTabTag = 1;

    private RadioButton mRB;

    private int mFromFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
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
            }
        } else if (i == R.id.iv_content_register) {
            fragment = PayPwdFragment.newInstance();
        } else if (i == R.id.iv_content_pay_pwd) {
            fragment = BindCardFragment.newInstance();
        } else if (i == R.id.iv_content_bind_card) {
            MyApplication.sIsLogin = true;
            if (mFromFlag == 4) {
                fragment = BuyOneFragment.newInstance();
            } else if (mFromFlag == 0) {
                fragment = YzhFragment.newInstance(true);
            } else {
                fragment = FinancingFragment.newInstance();
            }
        } else if (i == R.id.btn_buy) {
            if (mFromFlag == 4 && !MyApplication.sIsLogin) {
                fragment = PayPwdFragment.newInstance();
            } else {
                fragment = BuyOneFragment.newInstance();
            }
        } else if (i == R.id.iv_content_buy) {
            fragment = BuyTwoFragment.newInstance();
        } else if (i == R.id.iv_content_buy2) {
            fragment = BuyThreeFragment.newInstance();
            if (mFromFlag == 3) {
                //弹出对话框
                showRewardDialog();
            }
            if (mFromFlag == 4) {
                showCashDialog();
            }
        } else if (i == R.id.iv_content_buy3) {
            if (mFromFlag == 3) {
                setResult(RESULT_OK);
            }
            if (mTabTag == 2) {
                mRB.setChecked(true);
            }
            fragment = YzhFragment.newInstance(MyApplication.sIsLogin);
            mFromFlag = 0;
        } else if (i == R.id.iv_content_financing) {
            mTabTag = 2;
            if (mFromFlag == 4) {
                fragment = FinancingDetailFragment.newInstance();
            } else if (!MyApplication.sIsLogin) {
                fragment = RegisterFragment.newInstance();
            } else {
                fragment = FinancingDetailFragment.newInstance();
            }
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content, fragment).commit();
        }
    }

    private void showCashDialog() {
        final Dialog dialog = new Dialog(this, R.style.MyDialogStyle);
        dialog.show();
        View rootView = LayoutInflater.from(this).inflate(
                R.layout.cash_dialog, null);
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        int screenWidth = getScreenWidth(this);
        float width = screenWidth * 0.9f;
        params.width = (int) width;
        params.height = dip2px(this, 185);
        dialog.getWindow().setAttributes(params);
        dialog.setContentView(rootView);
        dialog.findViewById(R.id.btn_return_detail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                dialog.dismiss();
                finish();
            }
        });
        dialog.findViewById(R.id.btn_i_know).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void showRewardDialog() {
        final Dialog dialog = new Dialog(this, R.style.MyDialogStyle);
        dialog.show();
        View rootView = LayoutInflater.from(this).inflate(
                R.layout.reward_dialog, null);
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        int screenWidth = getScreenWidth(this);
        float width = screenWidth * 0.9f;
        params.width = (int) width;
        params.height = dip2px(this, 185);
        dialog.getWindow().setAttributes(params);
        dialog.setContentView(rootView);
        dialog.findViewById(R.id.btn_check_reward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
        dialog.findViewById(R.id.btn_got_it).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    private int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
