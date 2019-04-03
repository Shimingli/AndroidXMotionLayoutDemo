package com.lsm.androidx.viewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.lsm.androidx.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

/**
 * <p>
 * LottieAnimationView  这个动画的结合
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/3 11:21
 */
public class ViewPagerActivity2 extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabs;
    private MotionLayout mMotionLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motion_23_viewpager);
        FragmentManager supportFragmentManager = getSupportFragmentManager();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(supportFragmentManager);
        viewPagerAdapter.addPage("第一", R.layout.motion_16_viewpager_page1);
        viewPagerAdapter.addPage("第二", R.layout.motion_16_viewpager_page2);
        viewPagerAdapter.addPage("第三", R.layout.motion_16_viewpager_page3);


        mViewPager = findViewById(R.id.pager);
        //新特性的布局 头部
        mTabs = findViewById(R.id.tabs);


        mViewPager.setAdapter(viewPagerAdapter);
        mTabs.setupWithViewPager(mViewPager);

       //我们肯定知道这个id找出来是这个类
        mMotionLayout = findViewById(R.id.motionLayout);

        if (mMotionLayout!=null){
            //直接回调到我们这个类中去，实现这个监听
            if (mMotionLayout instanceof  ViewPager.OnPageChangeListener)
            mViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener) mMotionLayout);
        }

        boolean showPaths = getIntent().getBooleanExtra("showPaths", false);
        if (showPaths){
            mMotionLayout.setDebugMode(MotionLayout.DEBUG_SHOW_PATH);
        }else {
            mMotionLayout.setDebugMode(MotionLayout.DEBUG_SHOW_NONE);
        }

    }
}
