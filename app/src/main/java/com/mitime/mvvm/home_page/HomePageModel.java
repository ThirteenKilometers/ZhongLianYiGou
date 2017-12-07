package com.mitime.mvvm.home_page;

import android.content.Context;

import com.library.widgets.mvvm_base.Model;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/4 21:37<br/>
 * 邮箱：1050629507@qq.com
 */
class HomePageModel extends Model {



    protected HomePageModel(Context mContext) {
        super(mContext);
    }

    @Override
    protected void onCreate() {

    }

    @Override
    protected void onDestroy() {

    }

    public Observable<Long> getDatas() {
       return   Observable.timer(4, TimeUnit.SECONDS)
               .subscribeOn(Schedulers.io())
               .unsubscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());
    }
}
