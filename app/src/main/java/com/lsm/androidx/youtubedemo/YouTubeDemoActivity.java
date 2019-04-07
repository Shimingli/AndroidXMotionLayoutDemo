package com.lsm.androidx.youtubedemo;

import android.os.Bundle;
import android.view.View;

import com.lsm.androidx.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/7 13:44
 */
public class YouTubeDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motion_24_youtube);

        MotionLayout motionLayout = findViewById(R.id.motionLayout);


        RecyclerView recyclerView = findViewById(R.id.recyclerview_front);

        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FrontPhotosAdapter());

        boolean showPaths = getIntent().getBooleanExtra("showPaths", false);
         if (showPaths){
             motionLayout.setDebugMode(MotionLayout.DEBUG_SHOW_PATH);
        } else {
             motionLayout.setDebugMode(MotionLayout.DEBUG_SHOW_NONE);
        }


    }
}
