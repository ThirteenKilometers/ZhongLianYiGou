package com.mitime.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.library.utils.ToastUtil;
import com.library.widgets.views.banner.BannerView;
import com.library.widgets.views.banner.holders.ViewHolder;
import com.mitime.R;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    BannerView mBannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        List<Integer> banners = new ArrayList<>();
        banners.add(R.mipmap.banner1);
        banners.add(R.mipmap.banner2);
        banners.add(R.mipmap.banner3);
        banners.add(R.mipmap.banner4);
        banners.add(R.mipmap.banner5);
        mBannerView = findViewById(R.id.mBannerView);
        mBannerView.setPages(banners, () -> new BannerViewHolders());
        mBannerView.setBannerPageClickListener((view, position) -> ToastUtil.INSTANCE.show(this, "你单击了第 " + position + "张Banner"));

    }

    @Override
    protected void onStart() {
        super.onStart();
        mBannerView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBannerView.pause();
    }


    public static class BannerViewHolders implements ViewHolder<Integer> {
        private ImageView mImageView;

        @Override
        public View createView(Context mContext) {
            View mRoot = LayoutInflater.from(mContext).inflate(R.layout.banner_item01, null);
            mImageView = mRoot.findViewById(R.id.mImageView);
            return mRoot;
        }

        @Override
        public void onBind(Context mContext, int position, Integer data) {
            mImageView.setImageResource(data);
        }
    }
}

