package com.mitime.mvvm.menu;

import android.annotation.SuppressLint;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.library.utils.ToastUtil;
import com.library.widgets.mvvm_base.ViewModel;
import com.mitime.R;
import com.mitime.databinding.ActivityMenuBinding;
import com.mitime.modules.event_msg.MenuMessage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/5 11:46<br/>
 * 邮箱：1050629507@qq.com
 */
public class MenuViewModel extends ViewModel {


    ActivityMenuBinding mBinding;

    int mIndext = -1;

    public Command getCommand() {
        return new Command();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (!EventBus.getDefault().isRegistered(this)) EventBus.getDefault().register(this);

        Observable.timer(5, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> EventBus.getDefault().post(new MenuMessage())
                );

    }

    public void setBinding(ActivityMenuBinding binding) {
        this.mBinding = binding;
    }

    @Override
    public void onStop() {
        super.onStop();
        if (!EventBus.getDefault().isRegistered(this)) EventBus.getDefault().unregister(this);
    }

    public class Command {
        public void onClick(View view, int indext) {

            if (indext == mIndext) {
                //用户重复单击
                ToastUtil.INSTANCE.show(mContext, "用户重复单击 " + indext);

            } else {
                setViewStatus(indext);
            }
        }


    }

    @SuppressLint("ResourceAsColor")
    private void setViewStatus(int indext) {
        clearViewStart();
        this.mIndext = indext;
        mBinding.mViewPager.setCurrentItem(indext);
        switch (indext) {
            case 0:
                mBinding.mInclude.mImageMain.setImageResource(R.mipmap.shouye_xzh);
                mBinding.mInclude.mTextMain.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
                break;
            case 1:
                mBinding.mInclude.mImageClassify.setImageResource(R.mipmap.feilei_xzh);
                mBinding.mInclude.mTextClassify.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
                break;
            case 2:
                mBinding.mInclude.mImageMerchant.setImageResource(R.mipmap.shangjia_xzh);
                mBinding.mInclude.mTextMerchant.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));

                break;
            case 3:
                mBinding.mInclude.mImageShoppingCart.setImageResource(R.mipmap.gouwuche_xzh);
                mBinding.mInclude.mTextShoppingCart.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
                break;
            case 4:
                mBinding.mInclude.mImageMe.setImageResource(R.mipmap.my_xzh);
                mBinding.mInclude.mTexteMe.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
                break;
        }


    }

    private void clearViewStart() {
        mBinding.mInclude.mImageMain.setImageResource(R.mipmap.shouye_wxzh);
        mBinding.mInclude.mImageClassify.setImageResource(R.mipmap.feilei_wxzh);
        mBinding.mInclude.mImageMerchant.setImageResource(R.mipmap.shangjia_wxzh);
        mBinding.mInclude.mImageShoppingCart.setImageResource(R.mipmap.gouwuche_wxzh);
        mBinding.mInclude.mImageMe.setImageResource(R.mipmap.my_wxzh);

        mBinding.mInclude.mTextMain.setTextColor(ContextCompat.getColor(mContext, R.color.color_666));
        mBinding.mInclude.mTextClassify.setTextColor(ContextCompat.getColor(mContext, R.color.color_666));
        mBinding.mInclude.mTextMerchant.setTextColor(ContextCompat.getColor(mContext, R.color.color_666));
        mBinding.mInclude.mTextShoppingCart.setTextColor(ContextCompat.getColor(mContext, R.color.color_666));
        mBinding.mInclude.mTexteMe.setTextColor(ContextCompat.getColor(mContext, R.color.color_666));
    }

    @Subscribe
    public void onMessageEvent(MenuMessage event) {
        mBinding.mInclude.mImageShowMsg.setVisibility(View.VISIBLE);
    }

}
