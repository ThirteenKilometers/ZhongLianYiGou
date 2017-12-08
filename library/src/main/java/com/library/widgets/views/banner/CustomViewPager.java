package com.library.widgets.views.banner;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/7 13:50<br/>
 * 邮箱：1050629507@qq.com
 */
public class CustomViewPager extends ViewPager {
    private ArrayList<Integer> childCenterXAbs = new ArrayList<>();
    private SparseArray<Integer> childIndex = new SparseArray<>();

    public CustomViewPager(Context context) {
        this(context, null);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setClipToPadding(false);
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        if (i == 0 && childIndex.size() != childCount) {
            childCenterXAbs.clear();
            childIndex.clear();
            int viewCenterX = getViewCenterX(this);
            for (int i1 = 0; i1 < childCount; i1++) {
                int indexAbs = Math.abs(viewCenterX - getViewCenterX(getChildAt(i1)));
                //两个距离相同，后来的那个做自增，从而保持abs 不同
                if(childIndex.get(indexAbs)!=null) ++indexAbs;
                childCenterXAbs.add(indexAbs);
                childIndex.append(indexAbs,i1);
            }
            Collections.sort(childCenterXAbs);
        }
        //哪个Item距离中心点远一些，就先Draw它。（最近的就是中间放大的Item，最后draw）
        return childIndex.get(childCenterXAbs.get(childCount-1-i));
    }

    private int getViewCenterX(View view) {
        int[] array = new int[2];
        view.getLocationOnScreen(array);
        return array[0] / view.getWidth() / 2;
    }
}
