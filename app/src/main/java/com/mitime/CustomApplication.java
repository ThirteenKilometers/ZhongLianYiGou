package com.mitime;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/11/27 13:48<br/>
 * 邮箱：1050629507@qq.com
 */
public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();

    }

    private void init() {
        //初始化日志过滤器
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
