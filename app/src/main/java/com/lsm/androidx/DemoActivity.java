package com.lsm.androidx;

import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/1 15:37
 */
public class DemoActivity extends AppCompatActivity {

    private View mMotionLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layout_file_id = getIntent().getIntExtra("layout_file_id", R.layout.motion_01_basic);

        setContentView(layout_file_id);
         //coordinatorlayout示例（3/3） 是这个的Demo
        if (layout_file_id==R.layout.motion_11_coordinatorlayout){
//            头像
            ImageView icon = findViewById(R.id.icon);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //通过view.setClipToOutline(true)方法来开启组件的裁剪功能；
                icon.setClipToOutline(true);
            }
        }

        mMotionLayout = findViewById(R.id.motionLayout);
        // 是否显示路径
        boolean showPaths = getIntent().getBooleanExtra("showPaths", false);
        if (mMotionLayout instanceof MotionLayout) {
            if (showPaths) {
                ((MotionLayout) mMotionLayout).setDebugMode(MotionLayout.DEBUG_SHOW_PATH);
            } else {
                ((MotionLayout) mMotionLayout).setDebugMode(MotionLayout.DEBUG_SHOW_NONE);
            }
        }

        View viewById = findViewById(R.id.imageButton2);
        // 复杂运动示例（4/4） 这是这个的点击事件
        if (viewById!=null){
            viewById.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mMotionLayout instanceof MotionLayout){
                        float progress = ((MotionLayout) mMotionLayout).getProgress();
                        if (progress>0.5f){
                            ((MotionLayout) mMotionLayout).transitionToStart();
                        }else{
                            ((MotionLayout) mMotionLayout).transitionToEnd();
                        }
                    }
                }
            });
        }

    }


    /**
     *
     */
    public void changeState(){

    }
}
