package com.jiandanlicai.yzhlibrary;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by max on 15/10/22.
 */
public class Utils {
    public static void showCashDialog(Activity context, String msg) {
        final Dialog dialog = new Dialog(context, R.style.MyDialogStyle);
        dialog.show();
        View rootView = LayoutInflater.from(context).inflate(
                R.layout.cash_dialog, null);
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        int screenWidth = getScreenWidth(context);
        float width = screenWidth * 0.9f;
        params.width = (int) width;
        params.height = dip2px(context, 185);
        dialog.getWindow().setAttributes(params);
        dialog.setContentView(rootView);
        dialog.findViewById(R.id.btn_return_detail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.btn_i_know).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
