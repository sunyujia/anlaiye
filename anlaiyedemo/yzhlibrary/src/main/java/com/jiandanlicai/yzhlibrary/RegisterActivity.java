package com.jiandanlicai.yzhlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;

import com.jiandanlicai.yzhlibrary.fragment.RegisterFragment;

public class RegisterActivity extends FragmentActivity implements OnViewClickListener {

    private String mFlagStr;

    public static final String EXTRA_REGISTER = "register";

    public static final int REQUEST_CODE = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        mFlagStr = getIntent().getStringExtra(EXTRA_REGISTER);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content, RegisterFragment.newInstance()).commit();
        }
    }

    @Override
    public void onViewClick(View view) {
        int i = view.getId();
        if (i == R.id.iv_content_register) {
            if (!TextUtils.isEmpty(mFlagStr) && mFlagStr.equals(EXTRA_REGISTER)) {
                Utils.showCashDialog(this, "");
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10001) {
            setResult(RESULT_OK);
            finish();
        }
    }
}
