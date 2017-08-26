package com.zx.languagechange;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * 作者： 周旭 on 2017年8月26日 0026.
 * 邮箱：374952705@qq.com
 * 博客：http://www.jianshu.com/u/56db5d78044d
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        setCurrLanguageMode();
    }

    //设置当前APP的语言模式
    private void setCurrLanguageMode() {
        String language = SharedPrefUtils.getString(this, MainConstant.LANGUAGE_RUN, "");
        Locale local = LanguageUtils.getLocal(language);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = local;
        res.updateConfiguration(conf, dm);
    }
}
