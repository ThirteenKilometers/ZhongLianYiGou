package com.mitime.modules.menu;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.KeyEvent;

import com.library.utils.StatusBarUtil;
import com.library.utils.ToastUtil;
import com.library.widgets.ui_base.BaseActivity;
import com.library.widgets.ui_base.BaseFragment;
import com.library.widgets.views.viewpager.PageTransformer.DepthPageTransformer;
import com.mitime.R;
import com.mitime.databinding.ActivityMenuBinding;
import com.mitime.modules.menu.classify.ClassificationFragment;
import com.mitime.modules.menu.main.MainFragment;
import com.mitime.modules.menu.merchant.MerchantFragment;
import com.mitime.mvvm.menu.MenuViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 该应用菜单主页面 <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/11/27 16:11<br/>
 * 邮箱：1050629507@qq.com
 */
public class MenuActivity extends BaseActivity <MenuViewModel>{
    ActivityMenuBinding mBinding;
    List<BaseFragment> fragments = new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_menu);
        mBinding.setCommand(mViewModel.getCommand());
        mViewModel.setBinding(mBinding);
        initViews();
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this, null);
    }

    @Override
    protected MenuViewModel createViewModel() {
        return new MenuViewModel();
    }

    private void initViews() {
        mBinding.mViewPager.setAdapter(new FragmentPagerAdapter(this.getSupportFragmentManager()) {

            {
                fragments.add(MainFragment.newInstance());
                fragments.add(new ClassificationFragment());
                fragments.add(new MerchantFragment());//商家
                fragments.add(CommFragment.newInstance("购物车"));
                fragments.add(CommFragment.newInstance("我的"));
            }
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        mBinding.mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mBinding.mViewPager.setOffscreenPageLimit(fragments.size());
    }
    private long firstTime = 0l;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        long secondTime = System.currentTimeMillis();
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ( secondTime - firstTime < 1000) {
                System.exit(0);
            } else {
                ToastUtil.INSTANCE.show(this, "再按一次退出程序");
                firstTime = System.currentTimeMillis();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
