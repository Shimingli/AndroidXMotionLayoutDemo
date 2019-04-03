package com.lsm.androidx.fragment;

import android.os.Bundle;
import android.view.View;

import com.lsm.androidx.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/3 19:55
 */
public class FragmentExampleActivity extends AppCompatActivity implements MotionLayout.TransitionListener {

    private MotionLayout mMotionLayout;

    private Fragment mFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_example_layout);
        // 蛤蟆皮啊  你这里判断一定要是null啊，走不到if判断中去，那么mFragment永远是null
        if (savedInstanceState==null){
            mFragment = MainFragment.newInstance();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,
                            mFragment).commitNow();
        }
        mMotionLayout = findViewById(R.id.motionLayout);
        mMotionLayout.setTransitionListener(this);

    }

    @Override
    public void onTransitionStarted(MotionLayout motionLayout, int i, int i1) {

    }
    private float lastProgress=0f;


    @Override
    public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {
        if (v > lastProgress) {
            boolean atEnd=Math.abs(v-1f)<0.1f;
            //如果mFragment永远是null的 这个判断就不会成立了的嘛  瞎几把乱搞
            if (atEnd&& mFragment instanceof MainFragment){
                FragmentTransaction fragmentTransaction =
                        getSupportFragmentManager().beginTransaction();
                //animator 和 anim的区别？？？？？？ todo
                 fragmentTransaction.setCustomAnimations(R.animator.show,0);

               // 这是第二个Fragment
                mFragment = SecondFragment.newInstance();
                //animator 和 anim的区别？？？？？？ todo
                fragmentTransaction.setCustomAnimations(R.animator.show,0);
                fragmentTransaction.replace(R.id.container,mFragment).commitNow();

            }

        }else {
            if (v<0.9f){
                if (mFragment instanceof SecondFragment){
                    FragmentTransaction fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    //animator 和 anim的区别？？？？？？ todo
                    fragmentTransaction.setCustomAnimations(0,R.animator.hide);

                    mFragment = MainFragment.newInstance();
                    fragmentTransaction
                            .replace(R.id.container,mFragment)
                            .commitNow();
                }
            }
        }

        lastProgress = v;
    }

    @Override
    public void onTransitionCompleted(MotionLayout motionLayout, int i) {

    }

    @Override
    public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean b, float v) {

    }
}
