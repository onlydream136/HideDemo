package com.xiaoxing.testdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.autofill.AutofillManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.autofill.HintConstants;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 自动填充
 * @Author: qushaohua
 * @CreateDate: 2022/2/28 11:17 上午
 */
public class AutoFillActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int TYPE_ACCOUNT = 1;
    public static final int TYPE_EMAIL = 2;
    public static final int TYPE_USERNAME = 3;
    private EditText edtUserName;
    private EditText edtPassword;
    private int type;

    public static void actionStart(Activity activity, int type){
        Intent intent = new Intent(activity,AutoFillActivity.class);
        intent.putExtra("type",type);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_fill);
        initView();
        initData();
    }

    private void  initView(){
        type = getIntent().getIntExtra("type",1);
        edtPassword = findViewById(R.id.password);
        edtUserName = findViewById(R.id.userndfdame);
        findViewById(R.id.tv_button).setOnClickListener(this);
    }

    private void initData(){
//        edtUserName.setAutofillHints(HintConstants.AUTOFILL_HINT_NEW_USERNAME);
//        edtPassword.setAutofillHints(HintConstants.AUTOFILL_HINT_NEW_PASSWORD);
        Long time = System.currentTimeMillis();
        Date date = new Date(time - 365L *24*60*60*1000);
        Log.d("print",time + "----->" + new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    private void startEnableService(AutofillManager mAutofillManager) {
        if (mAutofillManager != null && !mAutofillManager.hasEnabledAutofillServices()) {
            Intent intent = new Intent(Settings.ACTION_REQUEST_SET_AUTOFILL_SERVICE);
            intent.setData(Uri.parse("package:com.example.android.autofill.service"));
            startActivityForResult(intent, 0x11);
        }
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
