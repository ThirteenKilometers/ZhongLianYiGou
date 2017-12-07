package com.library.utils;

/**
 * 常用功能包<br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/5 17:44<br/>
 * 邮箱：1050629507@qq.com
 */
public class Utils {

    /**
     * 防止连续点击的时间间隔
     */
    private static final long INTERVAL = 500L;
    /**
     * 上一次点击的时间
     */
    private static long lastClickTime = 0L;

    /**
     * 是否在 连续点击
     *
     * @return
     */
    public static boolean isContinuous() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < INTERVAL) {       //0.5秒内按钮无效，这样可以控制快速点击，自己调整频率
            return true;
        }
        lastClickTime = time;
        return false;
    }

}
