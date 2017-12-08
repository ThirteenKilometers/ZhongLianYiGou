package com.mitime.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.library.widgets.views.banner.BannerView;
import com.library.widgets.views.banner.BannerViewHolder;
import com.mitime.R;

public class TestActivity extends AppCompatActivity {

    BannerView mBannerView;

    public static final int []BANNER = new int[]{R.mipmap.banner1,R.mipmap.banner2,R.mipmap.banner3,R.mipmap.banner4,R.mipmap.banner5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mBannerView = findViewById(R.id.mBannerView);




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


    public static class BannerViewHolders implements BannerViewHolder<Integer> {
        private ImageView mImageView;
        @Override
        public View createView(Context mContext) {
            View mRoot = LayoutInflater.from(mContext).inflate(R.layout.banner_item01, null);
            return null;
        }

        @Override
        public void onBind(Context mContext, int position, Integer data) {

        }
    }
}

