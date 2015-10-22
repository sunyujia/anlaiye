package com.jiandanlicai.yzhlibrary;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.jiandanlicai.yzhlibrary.fragment.RegisterFragment;

public class RealNameActivity extends FragmentActivity implements OnViewClickListener {

    private String mFlagStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_real_name);
        mFlagStr = getIntent().getStringExtra("from");
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content, RegisterFragment.newInstance()).commit();
        }
    }

    @Override
    public void onViewClick(View view) {
        int i = view.getId();
        if (i == R.id.iv_content_register) {
            if (!TextUtils.isEmpty(mFlagStr) && mFlagStr.equals("fruit")) {
                returnCartDialog();
            } else {
                showInvestDialog();
            }
        }
    }


    private void returnCartDialog() {
        final Dialog dialog = new Dialog(this, R.style.MyDialogStyle);
        dialog.show();
        View rootView = LayoutInflater.from(this).inflate(
                R.layout.fruit_dialog, null);
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        int screenWidth = getScreenWidth(this);
        float width = screenWidth * 0.9f;
        params.width = (int) width;
        params.height = dip2px(this, 185);
        dialog.getWindow().setAttributes(params);
        dialog.setContentView(rootView);
        dialog.findViewById(R.id.btn_return_cart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                dialog.dismiss();
                finish();
            }
        });
    }

    private void showInvestDialog() {
        final Dialog dialog = new Dialog(this, R.style.MyDialogStyle);
        dialog.show();
        View rootView = LayoutInflater.from(this).inflate(
                R.layout.invest_dialog, null);
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        int screenWidth = getScreenWidth(this);
        float width = screenWidth * 0.9f;
        params.width = (int) width;
        params.height = dip2px(this, 185);
        dialog.getWindow().setAttributes(params);
        dialog.setContentView(rootView);
        dialog.findViewById(R.id.btn_invest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(RealNameActivity.this, YzhActivity.class);
                intent.putExtra("from", 4);
                startActivityForResult(intent, 10001);
            }
        });
        dialog.findViewById(R.id.btn_return_cart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                dialog.dismiss();
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10001) {
            setResult(RESULT_OK);
            finish();
        }
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
