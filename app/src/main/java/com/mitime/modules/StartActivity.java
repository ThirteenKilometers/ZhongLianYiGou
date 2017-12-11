package com.mitime.modules;

import android.content.Intent;
import android.os.Bundle;

import com.library.utils.StatusBarUtil;
import com.library.widgets.ui_base.BaseActivity;
import com.mitime.R;
import com.mitime.modules.menu.MenuActivity;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 该页面为APP 启动页面<br/>
 * 作者：LZHS<br/>
 * 时间： 2017/10/31 13:41<br/>
 * 邮箱：1050629507@qq.com
 */
public class StartActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initViews();
    }


    private void initViews() {
        Observable.timer(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    Logger.t(TAG).d("该页面为APP 启动页面");
                    startActivity(new Intent(this, MenuActivity.class));
                    this.finish();
                });


    }

}
