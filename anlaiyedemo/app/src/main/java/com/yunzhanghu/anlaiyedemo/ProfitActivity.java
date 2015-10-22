package com.yunzhanghu.anlaiyedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jiandanlicai.yzhlibrary.RealNameActivity;

public class ProfitActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        findViewById(R.id.btn_verify).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this, RealNameActivity.class);
//        intent.putExtra("from", "fruit");
        startActivityForResult(intent, 1000);

    }
}
