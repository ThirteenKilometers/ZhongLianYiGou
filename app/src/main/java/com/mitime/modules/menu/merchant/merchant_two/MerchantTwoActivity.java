package com.mitime.modules.menu.merchant.merchant_two;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.mitime.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 商家2级分类
 */
public class MerchantTwoActivity extends AppCompatActivity {

    @BindView(R.id.tool_bar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_page)
    ViewPager viewPage;
    @BindView(R.id.activity_main)
    CoordinatorLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_two);
        ButterKnife.bind(this);
        initUiAndData();
    }
    /** *
     初始化话界面和数据
     */
    private void initUiAndData() {
        /*toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);*/
        //初始化ViewPager的 Aapter 代码会在后面贴
        MyViewPagerAdaper adapter = new MyViewPagerAdaper(getSupportFragmentManager());
        //为Adapter添加Aapter和标题
        adapter.addFragment(new MyFragment(),"附近");
        adapter.addFragment(new MyFragment(),"美食");
        adapter.addFragment(new MyFragment(),"智能排序");
        //为ViewPager绑定Adapter
        viewPage.setAdapter(adapter);
        /*//为TabLayout添加标签，注意这里我们传入了标签名称，但demo运行时显示的标签名称并不是我们添加的，那么为什么呢？卖个官子...
        tabLayout.addTab(tabLayout.newTab().setText("one_"));
        tabLayout.addTab(tabLayout.newTab().setText("two_"));
        tabLayout.addTab(tabLayout.newTab().setText("three_"));
        tabLayout.addTab(tabLayout.newTab().setText("three_"));*/
        //给tabLayout设置ViewPage，如果设置关联了Viewpage，那么ViewpagAdapter中getPageTitle返回的就是Tab上标题(上面疑问的回答)
        //为ViewPager 和Tablelayout进行绑定，从而实现滑动标签切换Fragment的目的
        tabLayout.setupWithViewPager(viewPage);
    }


}
