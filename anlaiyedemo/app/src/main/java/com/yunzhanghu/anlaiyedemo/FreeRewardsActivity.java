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

public class FreeRewardsActivity extends FragmentActivity implements View.OnClickListener {

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
        tvTitle.setText("免费送积分");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_return) {
            finish();
        } else {
            Intent intent = new Intent(this, YzhActivity.class);
            intent.putExtra("from", 3);
            startActivityForResult(intent, 1002);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1002 && resultCode == RESULT_OK) {
            Toast.makeText(this, "Free", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
            finish();
        }
    }
}
