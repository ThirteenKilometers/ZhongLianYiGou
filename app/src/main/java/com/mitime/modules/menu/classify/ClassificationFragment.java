package com.mitime.modules.menu.classify;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.library.widgets.ui_base.BaseFragment;
import com.library.widgets.views.verticalview.QTabView;
import com.library.widgets.views.verticalview.TabAdapter;
import com.library.widgets.views.verticalview.TabView;
import com.library.widgets.views.verticalview.VerticalTabLayout;
import com.library.widgets.views.verticalview.VerticalViewPager;
import com.mitime.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassificationFragment extends BaseFragment {


    public ClassificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_classification, container, false);
        VerticalViewPager verticalViewPager= view.findViewById(R.id.verticalviewpager);
        VerticalTabLayout tablayout = view.findViewById(R.id.tablayout);
        tablayout.setTabAdapter(new MyTabAdapter());
        tablayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                verticalViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });
        verticalViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tablayout.setTabSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        verticalViewPager.setAdapter(new ClassificationAdapter(getFragmentManager()));
        verticalViewPager.setPageMargin(getResources().
                getDimensionPixelSize(R.dimen.fab_margin));
        return view;
    }
    public class ClassificationAdapter extends FragmentPagerAdapter {
        List<SameCategoryFragment> fragments = new ArrayList<>();

        public ClassificationAdapter(FragmentManager fm) {
            super(fm);

            for (int i = 0; i < 17; i++) {
                fragments.add(SameCategoryFragment.newInstance(i));
            }
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a SameCategoryFragment (defined as a static inner class below).
            //return SameCategoryFragment.newInstance(position + 1);
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 17;
        }

     /*   @Override
         public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "PAGE 0";
                case 1:
                    return "PAGE 1";
                case 2:
                    return "PAGE 2";
                case 3:
                    return "PAGE 3";
                case 4:
                    return "PAGE 4";
            }
            return null;
        }*/
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class SameCategoryFragment extends Fragment {
        private  ArrayList<String> itemList=null;//图文混排中的文字
        private LinearLayout.LayoutParams content_gradeview = null;
        private LinearLayout.LayoutParams title_tv = null;
        private  LinearLayout.LayoutParams title_icon=null;
        private LinearLayout llayout_main = null;//ScollerView 的linearlayout布局
        GDAdapter adapter;



        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static SameCategoryFragment newInstance(int sectionNumber) {
            SameCategoryFragment fragment = new SameCategoryFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public SameCategoryFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_layout, container, false);
            llayout_main = (LinearLayout) rootView.findViewById(R.id.llayout_jd_frg_main);//linearlayout 布局
            Log.d("Debug", "creating fragment "
                    + getArguments().getInt(ARG_SECTION_NUMBER));

            // TODO: 2017/12/5   模拟数据
            for (int i=0;i<4;i++){
                setData();
            }
            /* 对 对应的Tablayout进行响应
            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 0:
                    break;

                case 1:
                    rootView.setBackgroundColor(Color.BLACK);
                    break;

                case 2:
                    rootView.setBackgroundColor(Color.BLUE);
                    break;

                case 3:
                    rootView.setBackgroundColor(Color.GREEN);
                    break;

                case 4:
                    rootView.setBackgroundColor(Color.RED);
                    break;

            }*/
            return rootView;
        }

        @TargetApi(Build.VERSION_CODES.M)
        private void setData() {

            if (itemList==null){
                itemList=new ArrayList<>();
                for (int i = 1; i < 11; i++) {
                    itemList.add("选项"+i);
                }
            }

            //高度60dp+行距8dp = 68dp
            int heightUnit = (int)TypedValue
                    .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 68, getResources().getDisplayMetrics());
            int height;

            //计算Gridview总高度
            if(itemList.size() % 3 == 0)
            {
                height = (itemList.size()/3 + 2)*heightUnit;
            }
            else{
                height = (itemList.size()/3 + 1)*heightUnit;
            }

            if(content_gradeview == null)
                content_gradeview = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);

            if(title_tv == null)
                title_tv = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
                        ,ViewGroup.LayoutParams.WRAP_CONTENT);
            if (title_icon==null){
                title_icon=new LinearLayout.LayoutParams(10,10);
                title_icon.setMargins(20,0,10,0);
            }


            //图片和大分类下类型名称和小圆点
            LinearLayout mlin=new LinearLayout(getActivity());
            mlin.setOrientation(LinearLayout.HORIZONTAL);
            mlin.setGravity(Gravity.CENTER_VERTICAL);

            ImageView img_title=new ImageView(getActivity());

            img_title.setImageResource(R.mipmap.ic_launcher);
            mlin.addView(img_title,title_icon);

            TextView tv_title = new TextView(getActivity());
            tv_title.setTextColor(Color.GRAY);
            tv_title.setTextSize(16);
            tv_title.setText("中外名酒");
            mlin.addView(tv_title,title_tv);

            llayout_main.addView(mlin);

            GridView gridView = new GridView(getActivity());
            gridView.setNumColumns(3);
            gridView.setVerticalSpacing(8);
            gridView.setLayoutParams(content_gradeview);

            adapter=new GDAdapter(getActivity(),itemList,R.mipmap.ic_launcher);
            gridView.setAdapter(adapter);
            llayout_main.addView(gridView);
        }
    }
    /**
     * 右侧Adaptert
     */
    static  class  GDAdapter extends BaseAdapter{
        private Context context;
        private List<String> results;
        private int imageId;
        private ViewHolder holder;

        public GDAdapter(Context context, List<String> results, int imageId) {
            this.context = context;
            this.results = results;
            this.imageId = imageId;
        }

        @Override
        public int getCount() {
            return results.size();
        }

        @Override
        public Object getItem(int i) {
            return results.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            String c= (String) getItem(i);
            if (convertView==null){
                holder=new ViewHolder();
                convertView=LayoutInflater.from(context).inflate(R.layout.jd_item,null);
                holder.tv = (TextView) convertView.findViewById(R.id.tv_jd_item);
                holder.imv = (ImageView) convertView.findViewById(R.id.imv_jd_item);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            convertView.setTag(holder);
            holder.tv.setText(c);
            holder.imv.setImageResource(imageId);
            return convertView;
        }

        class ViewHolder{
            TextView tv;
            ImageView imv;
        }
    }
    /**
     * 左侧Adapter
     */
    class MyTabAdapter implements TabAdapter {

        List<String> titles;
        Context context;

        {
            titles = new ArrayList<>();
            Collections.addAll(titles, "酒类", "数码", "厨具", "家用电器", "玩具乐器","礼品箱包","食品饮料","电脑办公","医疗保健","家装建材","汽车用品","美妆个护","家纺家居","家居","户外运动","手机","母婴"
            );
        }

        @Override
        public int getCount() {
            return 17;
        }

        @Override
        public int getBadge(int position) {
            if (position == 17) return position;
            return 0;
        }

        @Override
        public QTabView.TabIcon getIcon(int position) {
            return null;
        }

        @Override
        public QTabView.TabTitle getTitle(int position) {
            return new QTabView.TabTitle.Builder(getContext())
                    .setContent(titles.get(position))
                    .setTextColor(Color.RED, Color.GRAY)
                    .setTextSize(16)
                    .build();
        }

        @Override
        public int getBackground(int position) {
            return 0;
        }
        /*public  View getTabView (int position){
            View view =LayoutInflater.from(context).inflate(R.layout.tab_left_item,null );
            // View line_tab=(View) view.findViewById(R.id.line_tab);
            TextView tv_tab=(TextView) view.findViewById(R.id.tv_tab);
            tv_tab.setText(titles.get(position));
            return  view;
        }*/
    }


}
