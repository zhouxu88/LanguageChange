package com.zx.languagechange;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.RadioGroup;

import java.util.Locale;

public class LanguageSettingActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private static final String TAG = "LanguageSetting";
    private RadioGroup radioGroup;
    private String language; //当前设置的语言

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_setting);


        radioGroup = (RadioGroup) findViewById(R.id.language_rg);
        radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i) {
            case R.id.auto_rb:
                //跟随系统
                language = Locale.getDefault().toString();
                break;
            case R.id.zh_rb:
                //简体中文
                language = Locale.SIMPLIFIED_CHINESE.toString();
                break;
            case R.id.multi_zh_rb:
                //繁体中文
                language = Locale.TRADITIONAL_CHINESE.toString();
                break;
            case R.id.en_rb:
                //英文
                language = Locale.ENGLISH.toString();
                break;
        }
        Log.i(TAG, "language:--------->" + language);
        updateActivity(language);
    }

    /**
     * 刷新语言
     */
    public void updateActivity(String language) {
        //在本地保存当前选择的语言
        SharedPrefUtils.writeString(this, MainConstant.LANGUAGE_RUN, language);
        Locale local = LanguageUtils.getLocal(language);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = local;
        res.updateConfiguration(conf, dm);
        Intent intent = new Intent(this, MainActivity.class);
        //清空任务栈确保当前打开activit为前台任务栈栈顶
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
