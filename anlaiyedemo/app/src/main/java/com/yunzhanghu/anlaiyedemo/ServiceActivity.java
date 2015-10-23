package com.yunzhanghu.anlaiyedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.jiandanlicai.yzhlibrary.RegisterActivity;

public class ServiceActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        findViewById(R.id.btn_oepn).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.putExtra(RegisterActivity.EXTRA_REGISTER, RegisterActivity.EXTRA_BIND_CARD);
        startActivityForResult(intent, RegisterActivity.REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RegisterActivity.REQUEST_CODE && resultCode == RESULT_OK) {
            setResult(resultCode);
            finish();
        }
    }

}
