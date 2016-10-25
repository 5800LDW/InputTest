package com.nuaa.inputtest;

import android.content.Context;

/**
 * Created by time++ on 2016/10/15 22:23.
 * Email:873438791@qq.com
 */
public class CommonUtil {
    /**
     * 根据手机的分辨率从dp转为px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
    public static int getStatusHeight(Context context){

        int status_height = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            status_height = context.getResources().getDimensionPixelSize(resourceId);
        }
        return status_height;
    }
}
