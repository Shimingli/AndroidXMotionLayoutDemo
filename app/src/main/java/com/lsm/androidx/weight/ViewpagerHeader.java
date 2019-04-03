package com.lsm.androidx.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewParent;

import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.viewpager.widget.ViewPager;

/**
 * <p>
 *  实现 就具有拖拽的能力了
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/3 11:08
 */
public class ViewpagerHeader extends MotionLayout implements ViewPager.OnPageChangeListener {
    public ViewpagerHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewpagerHeader(Context context) {
        this(context,null);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
         int numPages=3;
         setProgress((position+positionOffset)/(numPages-1));

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
