package com.library.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.library.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Toast 辅助工具类，不管连续点击弹出多少个 toast，
 * 都在最后一个弹出后3秒后消失，不会一个接着一个显示<br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/4 16:39<br/>
 * 邮箱：1050629507@qq.com
 */
public enum ToastUtil {
    INSTANCE;// 实现单例
    private Toast mToast;
    private TextView mTvToast;

    public void show(Context mContext, String msg) {
        if (TextUtils.isEmpty(msg.trim())) return;
        if (mToast == null) {
            mToast = new Toast(mContext);
            mToast.setGravity(Gravity.CENTER, 0, 0);//设置toast显示的位置，这是居中
            mToast.setDuration(Toast.LENGTH_SHORT);//设置toast显示的时长
            View _root = LayoutInflater.from(mContext).inflate(R.layout.layout_toast, null);//自定义样式，自定义布局文件
            mTvToast = _root.findViewById(R.id.mTextShowMSG);
            mToast.setView(_root);//设置自定义的view
        }
        mTvToast.setText(msg);//设置文本
        mToast.show();//展示toast
        Observable.timer(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> cancelToast());
    }

    public void show(@NonNull Context mContext, @StringRes int msgId) {
        show(mContext, mContext.getString(msgId));
    }

    public void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
            mTvToast = null;
        }
    }


}
