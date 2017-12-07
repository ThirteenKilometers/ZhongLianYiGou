package com.library.utils.gilde;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.library.R;

public class GlideUtils {
    public static String TAG = GlideUtils.class.getSimpleName();
    public static void loader(Context mContext, String url, ImageView img) {
        loader(mContext,url, R.mipmap.jzsb_xqdt,R.mipmap.zwtu_xqdt,img);
    }
    public static void loader(Context mContext, String url, int erroImg, int emptyImg, ImageView img) {
        GlideApp.with(mContext)
                .load(url)
                .placeholder(emptyImg)
                .error(erroImg)
                .transition(DrawableTransitionOptions.withCrossFade())
                .thumbnail(0.25f)
                .fitCenter()
                .thumbnail(0.3f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        com.orhanobut.logger.Logger.t(TAG).e("图片地址 ： " + url + "\n\r" + e.getMessage());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                }).into(img);
    }
}