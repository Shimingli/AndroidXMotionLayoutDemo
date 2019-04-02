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
        //左右移动 ，然后慢慢的滚回到远点
        adapterItemBeans.add(new AdapterItemBean("基本示例（1/2）","使用引用的ConstraintLayout文件的基本运动示例",R.layout.motion_01_basic));
        // 左右移动，另外的一种的实现的方式 ，可以改变小球的大小
        adapterItemBeans.add(new AdapterItemBean("基本示例（2/2）","使用在MotionScene文件中定义的约束集的基本运动示例",R.layout.motion_02_basic));
        //左右移动，颜色渐变，大小渐变，在中间，我个人感觉是两个颜色的重叠，注意在布局中的颜色其实设置没有什么作用
        adapterItemBeans.add(new AdapterItemBean("自定义属性","显示颜色插值（自定义属性）",R.layout.motion_03_custom_attribute));
        //使用IamgeFilterView 两张图片的重合，左右滑动，可以不断的切换图片 在两张图片之间做的淡入淡出 (cross-fade) 效果
        adapterItemBeans.add(new AdapterItemBean("ImageFilterView（1/2）","显示图像交叉淡入度（使用ml的imagefilterview+自定义属性）",R.layout.motion_04_imagefilter));
        // ImageFilterView 也提供了更多的功能:饱和度
        // saturation : 0 = grayscale, 1 = original, 2 = hyper
        // saturated
        //对比度    contrast : 1 = unchanged, 0 = gray, 2 = high contrast
        //色温       warmth : 1 = neutral, 2 = warm (red tint), 0.5 = cold (blue tint)
        //淡入淡出   crossfade (with app:altSrc)
        // Saturation 饱和度的意思  图片在上下位移的时候 ，动态改变饱和度    motion:attributeName="Saturation" 从1变为0
        // 什么是图像的饱和度？饱和度指的是图像的颜色的浓度，饱和度越高，颜色越饱满，饱和度越低，颜色就会显示的陈旧和惨淡，饱和度为0，图像就是灰色的图像
        adapterItemBeans.add(new AdapterItemBean("ImageFilterView（2/2）","显示图像饱和度转换（使用ml的imagefilterview+自定义属性）",R.layout.motion_05_imagefilter));

        //Keyframe Position
        //关键帧 (position keyframes)，这里指定了在过渡进行到 50% 的时候，位置在屏幕高度的 25%处。 设置关键帧在进行到 50%的地方 ，y轴偏移为 往下为+ 往上是-
        adapterItemBeans.add(new AdapterItemBean("关键帧位置（1/3）","使用简单的关键帧更改插值运动",R.layout.motion_06_keyframe));

        //关键帧 (2/2), 属性(attribute)，加上了自身的旋转
        adapterItemBeans.add(new AdapterItemBean("关键帧插值（2/3）","更复杂的关键帧，添加旋转插值",R.layout.motion_07_keyframe));

        //关键帧 使用了抛物线的轨迹
        adapterItemBeans.add(new AdapterItemBean("关键帧周期（3/3）","使用关键帧周期的基本示例",R.layout.motion_08_cycle));


        //CoordinatorLayout Demo
        // NestedScrollView 即 支持嵌套滑动的 ScrollView。比如一个 ScrollView 内部包裹一个 RecyclerView，那么就会产生滑动冲突，这个问题就需要你自己去解决。而如果使用 NestedScrollView 包裹 RecyclerView，嵌套滑动天然支持，你无需做什么就可以实现前面想要实现的功能了。
         //CollapsibleToolbar 是把位移的监听 直接放到自己的类来了，可以很方便的节约性能，这种方式定义自定义控件有很好的效果
        adapterItemBeans.add(new AdapterItemBean("coordinatorlayout示例（1/3）","使用motion layout而不是appbarlayout的基本示例",R.layout.motion_09_coordinatorlayout));
        //      app:fontFamily="cursive" 字体的设置
        // layout_constraintBaseline_toBaselineOf 我个人理解就是这个文字要和 label 这一行在同一行
        //             layout_constraint（本组件的部位）_to（建立连接的组件部位）Of：（建立连接的id）
        adapterItemBeans.add(new AdapterItemBean("coordinatorlayout 示例（2/3）","用多个元素和视差背景替换appbarlayout的稍复杂的motion layout示例",R.layout.motion_10_coordinatorlayout));


        // 使用drawable的xml文件和View.setClipToOutline()制作圆形ImageView  但是要谨慎的使用
        adapterItemBeans.add(new AdapterItemBean("coordinatorlayout示例（3/3）","另一个 AppBarLayout 替换示例",R.layout.motion_11_coordinatorlayout));

        // 抽屉布局 记得往右拉动，一个很复杂的布局动画 牛逼
        adapterItemBeans.add(new AdapterItemBean("drawerlayout示例（1/2）","DrawerLayout MotionLayout",R.layout.motion_12_drawerlayout));
        // 这个动画做的不太一样，从旋转的方向看不一样
        adapterItemBeans.add(new AdapterItemBean("drawerlayout示例（2/2）","Advanced DrawerLayout with motionlayout",R.layout.motion_13_drawerlayout));

        // 侧板的信息栏，这里是可以展示侧边的抽屉框。但是不知道有什么用处 MockView MockView
        adapterItemBeans.add(new AdapterItemBean("侧面板示例","侧面板，仅与motion layout一起实现",R.layout.motion_14_side_panel));

        //
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
