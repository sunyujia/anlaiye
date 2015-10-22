package com.yunzhanghu.anlaiyedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.jiandanlicai.yzhlibrary.RegisterActivity;

/**
 * Created by yyyy on 15/10/20.
 */
public class RuleActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_rule);
        findViewById(R.id.btn_oepn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        Toast.makeText(this, "开通", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, 1002);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1002) {
            setResult(RESULT_OK);
            finish();
        }
    }
}
