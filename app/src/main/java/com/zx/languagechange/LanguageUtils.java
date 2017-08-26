package com.zx.languagechange;

import java.util.Locale;

/**
 * 多语言适配的工具类
 * <p>
 * 作者： 周旭 on 2017年8月26日 0026.
 * 邮箱：374952705@qq.com
 * 博客：http://www.jianshu.com/u/56db5d78044d
 */

public class LanguageUtils {

    /**
     * 语言的缩写 如：zh_CN、zh_TW、en
     *
     * @param language
     * @return
     */
    public static Locale getLocal(String language) {
        switch (language) {
            case "zh_CN":
                //中文
                return Locale.CHINA;
            case "zh_TW":
                //繁体中文
                return Locale.TRADITIONAL_CHINESE;
            case "en":
                return Locale.ENGLISH;
            default:
                //默认中文
                return Locale.CHINA;
        }
    }
}
