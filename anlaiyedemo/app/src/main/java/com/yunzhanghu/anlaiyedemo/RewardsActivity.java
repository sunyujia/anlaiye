package com.yunzhanghu.anlaiyedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiandanlicai.yzhlibrary.YzhActivity;

import static com.yunzhanghu.anlaiyedemo.R.id.iv_content_money;

public class RewardsActivity extends FragmentActivity implements View.OnClickListener {

    private ImageView mIvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_zero_pay);
        ImageView ivBack = (ImageView) findViewById(R.id.iv_return);
        mIvContent = (ImageView) findViewById(iv_content_money);
        TextView tvTitle = (TextView) findViewById(R.id.tv_title);
        ivBack.setOnClickListener(this);
        mIvContent.setOnClickListener(this);
        tvTitle.setText("我的积分");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_return) {
            finish();
        } else {
            startActivityForResult(new Intent(this, FreeRewardsActivity.class), 1001);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == RESULT_OK) {
            //替换成50积分的图片
            Toast.makeText(this, "reward", Toast.LENGTH_SHORT).show();
        }
    }
}
