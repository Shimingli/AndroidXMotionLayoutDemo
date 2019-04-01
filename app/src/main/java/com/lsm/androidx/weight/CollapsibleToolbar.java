package com.lsm.androidx.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import com.google.android.material.appbar.AppBarLayout;

import androidx.constraintlayout.motion.widget.MotionLayout;

/**
 * <p>
 * 自定义MotionLayout和 AppBarLayout互相结合着使用
 * 这种自定义空控件的方法很有意思
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/1 19:35
 */
public class CollapsibleToolbar extends MotionLayout implements AppBarLayout.OnOffsetChangedListener {

    public CollapsibleToolbar(Context context) {
        this(context,null);
    }

    public CollapsibleToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 刚附着到窗体上
     */
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        //如果判断是在 AppBarLayout中使用的话
        if(getParent() instanceof AppBarLayout){
            ((AppBarLayout) getParent()).addOnOffsetChangedListener(this);
        }
    }

    /**
     * 接口中的方法
     * @param appBarLayout appBarLayout对象
     * @param verticalOffset 偏移量，手机屏幕往下滚动的话，这个为负数  在最顶部的时候， verticalOffset为 0
     */
    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        //设置MotionLayout 进度在哪里
        setProgress((float)-verticalOffset/appBarLayout.getTotalScrollRange());
        Log.d("CollapsibleToolbar","appBarLayout.getTotalScrollRange()="+appBarLayout.getTotalScrollRange());
        Log.d("CollapsibleToolbar","verticalOffset="+verticalOffset);

    }
}
