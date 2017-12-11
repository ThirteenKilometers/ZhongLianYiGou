package com.mitime.modules.menu.main;

import android.view.View;

import com.library.utils.ToastUtil;
import com.library.widgets.mvvm_base.ViewModel;
import com.mitime.databinding.FragmentMainBinding;
import com.mitime.modules.event_msg.MenuMessage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/4 11:37<br/>
 * 邮箱：1050629507@qq.com
 */
public class MainViewModel extends ViewModel {
    FragmentMainBinding mBinding;


    @Override
    public void onCreate() {
        super.onCreate();
        if (!EventBus.getDefault().isRegistered(this)) EventBus.getDefault().register(this);

    }

    @Override
    public void onStop() {
        super.onStop();
        if (!EventBus.getDefault().isRegistered(this)) EventBus.getDefault().unregister(this);

    }

    public Command getCommand() {
        return new Command();
    }

    @Subscribe
    public void onMessageEvent(MenuMessage event) {
        mBinding.mInclude.mImageShowMsg.setVisibility(View.VISIBLE);
    }

    public void setBinding(FragmentMainBinding binding) {
        this.mBinding = binding;
    }

    public class Command {
        public void onClickRichScan(View view) {
            //单击了扫一扫
            ToastUtil.INSTANCE.show(mContext, "单击了扫一扫");
        }

        public void onClickSearch(View view) {
            //单击了搜索
            ToastUtil.INSTANCE.show(mContext, "单击了搜索");
        }

        public void onClickMessage(View view) {
            //单击了消息
            ToastUtil.INSTANCE.show(mContext, "单击了消息");
        }
    }
}
