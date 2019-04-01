package com.lsm.androidx.weight;

import android.content.Context;
import android.util.AttributeSet;

import com.google.android.material.appbar.AppBarLayout;

import androidx.constraintlayout.motion.widget.MotionLayout;

/**
 * <p>
 * 自定义MotionLayout和 AppBarLayout互相结合着使用
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

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        //设置进度在哪里
        setProgress((float)-verticalOffset/appBarLayout.getTotalScrollRange());
    }
}
