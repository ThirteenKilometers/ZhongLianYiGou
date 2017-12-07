package com.mitime.modules.menu.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.library.widgets.ui_base.BaseFragment;
import com.mitime.R;
import com.mitime.databinding.FragmentMainBinding;
import com.mitime.modules.menu.CommFragment;
import com.mitime.modules.menu.comm_sub.HomePageFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 该页面为首页页面<br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/1 16:04<br/>
 * 邮箱：1050629507@qq.com
 */
public class MainFragment extends BaseFragment<MainViewModel> {
    FragmentMainBinding mBinding;


    String[] tabs = {"男装", "电器", "手机", "鞋包", "服饰", "美食", "首页", "首页", "首页", "首页", "首页"};

    List<BaseFragment> fragments = new ArrayList<>();

    {
        fragments.add(HomePageFragment.newInstance());
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        MainViewModel.Command command = mViewModel.getCommand();
        mBinding.setCommand(command);
        mViewModel.setBinding(mBinding);
        initViews();
        return mBinding.getRoot();

    }

    @Override
    protected MainViewModel createViewModel() {
        return new MainViewModel();
    }

    private void initViews() {
        for (String tab : tabs) {
            fragments.add(CommFragment.newInstance(tab));
            TabLayout.Tab mTab = mBinding.mTabLayout.newTab();
            mTab.setText(tab);
            mBinding.mTabLayout.addTab(mTab);
        }
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "首页" : tabs[position - 1];
            }
        };
        mBinding.mTabLayout.setTabTextColors(ContextCompat.getColor(getContext(), R.color.color_666),
                ContextCompat.getColor(getContext(), R.color.colorAccent));
        mBinding.mTabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        mBinding.mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mBinding.mViewPager.setAdapter(mAdapter);
        mBinding.mTabLayout.setupWithViewPager(mBinding.mViewPager);
        reflex(mBinding.mTabLayout);

    }

    public void reflex(final TabLayout tabLayout) {
        //了解源码得知 线的宽度是根据 tabView的宽度来设置的
        tabLayout.post(() -> {
            try {
                setIndicator(tabLayout);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

    }

    private void setIndicator(TabLayout tabLayout) throws NoSuchFieldException, IllegalAccessException {
        //拿到tabLayout的mTabStrip属性
        LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);

        int dp10 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getContext().getResources().getDisplayMetrics());

        for (int i = 0; i < mTabStrip.getChildCount(); i++) {
            View tabView = mTabStrip.getChildAt(i);

            //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
            Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
            mTextViewField.setAccessible(true);

            TextView mTextView = (TextView) mTextViewField.get(tabView);

            tabView.setPadding(0, 0, 0, 0);

            //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
            int width = 0;
            width = mTextView.getWidth();
            if (width == 0) {
                mTextView.measure(0, 0);
                width = mTextView.getMeasuredWidth();
            }

            //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
            params.width = width;
            params.leftMargin = dp10;
            params.rightMargin = dp10;
            tabView.setLayoutParams(params);

            tabView.invalidate();
        }
    }


}
