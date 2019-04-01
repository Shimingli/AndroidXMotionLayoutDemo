package com.lsm.androidx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private RecyclerView mRecyclerView;
    private Switch mShowPaths;
    private boolean doShowPaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        ArrayList<AdapterItemBean> adapterItemBeans = new ArrayList<>();
        adapterItemBeans.add(new AdapterItemBean("基本示例（1/2）","使用引用的ConstraintLayout文件的基本运动示例",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("基本示例（2/2）","使用在MotionScene文件中定义的约束集的基本运动示例",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("自定义属性","显示颜色插值（自定义属性）",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("imagefilterview（1/2）","显示图像交叉淡入度（使用ml的imagefilterview+自定义属性）",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("imagefilterview（2/2）","显示图像饱和度转换（使用ml的imagefilterview+自定义属性）",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("关键帧位置（1/3）","使用简单的关键帧更改插值运动",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("关键帧插值（2/3）","更复杂的关键帧，添加旋转插值",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("关键帧周期（3/3）","使用关键帧周期的基本示例",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("coordinatorlayout示例（1/3）","使用motion layout而不是appbarlayout的基本示例",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("coordinatorlayout example（2/3）","用多个元素和视差背景替换appbarlayout的稍复杂的motion layout示例",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("coordinatorlayout示例（3/3）","另一个appbarlayout替换示例",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("drawerlayout示例（1/2","带motion layout的基本drawerlayout",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("drawerlayout示例（2/2）","高级drawerlayout with motion layout",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("侧面板示例","侧面板，仅与motion layout一起实现",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("视差示例","视差背景”。拖动汽车。",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("VIEWPGER示例","Using MotionLayout with ViewPager",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("ViewPager Lottie Example","Using MotionLayout and Lottie with ViewPager",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("复杂运动示例（1/4）","基本协调布局类行为。仅使用motionlayout实现，使用移动指南。注意，视图没有调整大小。",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("复杂运动示例（2/4）","高级协调布局类似行为（添加FAB）”。仅使用motionlayout实现，使用移动指南。注意，视图没有调整大小。",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("复杂运动示例（3/4）","高级协调布局类似行为（添加FAB）",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("复杂运动示例（4/4）","高级同步reval运动+助手（反弹）",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("片段转换示例（1/2）","显示MODISPLAY布局中的转换片段”的示例",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("片段转换示例（2/2）","显示MODISPLAY布局中的转换片段”的示例",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("YouTube类运动示例","显示像YouTube一样的过渡示例",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("使用keytrigger的示例","使用keytrigger调用方法的示例",R.layout.motion_01_basic));
        adapterItemBeans.add(new AdapterItemBean("使用多状态的示例","在多状态之间转换的示例",R.layout.motion_01_basic));

        DemosAdapter demosAdapter = new DemosAdapter(adapterItemBeans);
        mRecyclerView.setAdapter(demosAdapter);

    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerview);
        mShowPaths = findViewById(R.id.showPaths);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);


        mShowPaths.setOnCheckedChangeListener(this);


        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ConstraintLayoutActivityDemo.class));
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        doShowPaths = isChecked;
    }

    public void start(Class v, int layoutFileId) {
        Intent intent = new Intent(MainActivity.this, v);
        intent.putExtra("layout_file_id", layoutFileId);
        intent.putExtra("showPaths", doShowPaths);
        startActivity(intent);
    }
}
