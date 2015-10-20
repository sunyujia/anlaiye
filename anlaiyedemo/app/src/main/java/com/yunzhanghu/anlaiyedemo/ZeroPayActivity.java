package com.yunzhanghu.anlaiyedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiandanlicai.yzhlibrary.YzhActivity;

import static com.yunzhanghu.anlaiyedemo.R.id.iv_content_money;

public class ZeroPayActivity extends FragmentActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_zero_pay);
        ImageView ivBack = (ImageView) findViewById(R.id.iv_return);
        ImageView ivContent = (ImageView) findViewById(iv_content_money);
        TextView tvTitle = (TextView) findViewById(R.id.tv_title);
        ivBack.setOnClickListener(this);
        ivContent.setOnClickListener(this);
        tvTitle.setText("俺有金");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_return) {
            finish();
        } else {
            startActivity(new Intent(this, YzhActivity.class));
        }
    }
}
