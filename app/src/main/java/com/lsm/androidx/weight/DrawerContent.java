package com.lsm.androidx.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.drawerlayout.widget.DrawerLayout;

/**
 * <p>
 * 最牛逼的是 这个坚挺的调用的过程 减少代码量
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/2 17:14
 */
public class DrawerContent extends MotionLayout implements DrawerLayout.DrawerListener {

    public DrawerContent(Context context) {
        this(context,null);
    }

    public DrawerContent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 刚附着到布局上的时候
     * Android——自带侧滑菜单DrawerLayout的使用方法
     */
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof DrawerLayout){
            ((DrawerLayout) getParent()).addDrawerListener(this);
        }
    }

    @Override
    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
         setProgress(slideOffset);
    }

    @Override
    public void onDrawerOpened(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerClosed(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
