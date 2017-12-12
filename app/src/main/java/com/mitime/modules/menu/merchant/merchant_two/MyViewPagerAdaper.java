package com.mitime.modules.menu.merchant.merchant_two;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 * QQ: 2366081200
 * Created by pc1 on 2017/12/12.
 */

 public class MyViewPagerAdaper extends FragmentPagerAdapter {
    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> fragmentTitles = new ArrayList<>();
    public MyViewPagerAdaper(FragmentManager fm) {
        super(fm);
    }
    public void addFragment(Fragment fragment, String title){
        mFragments.add(fragment);
        fragmentTitles.add(title);
    }
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }
    @Override
    public int getCount() {
        return mFragments.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        //这里返回的标题就是TabLayout的标题
        return fragmentTitles.get(position);
    }
}


