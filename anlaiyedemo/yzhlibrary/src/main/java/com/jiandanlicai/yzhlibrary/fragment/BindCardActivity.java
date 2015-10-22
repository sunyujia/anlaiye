package com.jiandanlicai.yzhlibrary.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.jiandanlicai.yzhlibrary.OnViewClickListener;
import com.jiandanlicai.yzhlibrary.R;

public class BindCardActivity extends FragmentActivity implements OnViewClickListener {

    public static final int REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bind_bank);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content, RegisterFragment.newInstance()).commit();
        }
    }

    @Override
    public void onViewClick(View view) {
        int i = view.getId();
        if (i == R.id.iv_content_register) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content, BindCardFragment.newInstance()).commit();
        }
        if (i == R.id.iv_content_bind_card) {
            //弹出对话框
            Toast.makeText(this, "弹出对话框", Toast.LENGTH_SHORT).show();
        }
    }


    private void showReturnDialog() {
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
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
