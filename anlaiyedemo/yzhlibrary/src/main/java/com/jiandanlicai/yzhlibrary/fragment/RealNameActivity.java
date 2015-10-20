package com.jiandanlicai.yzhlibrary.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.jiandanlicai.yzhlibrary.MyApplication;
import com.jiandanlicai.yzhlibrary.OnViewClickListener;
import com.jiandanlicai.yzhlibrary.R;

public class RealNameActivity extends FragmentActivity implements OnViewClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_name);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content, RegisterFragment.newInstance()).commit();
        }
    }

    @Override
    public void onViewClick(View view) {
        Fragment fragment = null;
        int i = view.getId();
        if (i == R.id.iv_content_register1) {
            fragment = Register2Fragment.newInstance();
        } else if (i == R.id.iv_content_register2) {
            fragment = Register3Fragment.newInstance();
        } else if (i == R.id.iv_content_register3) {
            showDialog();
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content, fragment).commit();
        }
    }


    private void showDialog() {
        final Dialog dialog = new Dialog(this, R.style.MyDialogStyle);
        dialog.show();
        View rootView = LayoutInflater.from(this).inflate(
                R.layout.tip_dialog, null);
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        int screenWidth = getScreenWidth(this);
        float width = screenWidth * 0.9f;
        params.width = (int) width;
        params.height = dip2px(this, 185);
        dialog.getWindow().setAttributes(params);
        dialog.setContentView(rootView);
        dialog.findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
        dialog.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
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
