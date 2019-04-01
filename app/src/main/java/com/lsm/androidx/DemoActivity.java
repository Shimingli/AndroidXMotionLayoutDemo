package com.lsm.androidx;

import android.os.Bundle;
import android.view.View;

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
public class DemoActivity  extends AppCompatActivity {

    private MotionLayout mMotionLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getIntent().getIntExtra("layout_file_id",R.layout.motion_01_basic));

        mMotionLayout = findViewById(R.id.motionLayout);
        // 是否显示路径
        boolean showPaths = getIntent().getBooleanExtra("showPaths", false);
        if (showPaths){
            mMotionLayout.setDebugMode(MotionLayout.DEBUG_SHOW_PATH);
        }else{
            mMotionLayout.setDebugMode(MotionLayout.DEBUG_SHOW_NONE);
        }


    }
}
