# MotionLayout和ConstraintLayout的Demo（AndroidX&Java版本）
* **欢迎关注我的公众号**
![公众号](https://upload-images.jianshu.io/upload_images/5363507-0a0cf2e5fd8f843d.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



* **App完成的效果图**
![QQ视频20190425102024.gif](https://upload-images.jianshu.io/upload_images/5363507-48816c817df2337e.gif?imageMogr2/auto-orient/strip)

![QQ视频20190425102021.gif](https://upload-images.jianshu.io/upload_images/5363507-ae83ba161882fa9d.gif?imageMogr2/auto-orient/strip)

![QQ视频20190425102004.gif](https://upload-images.jianshu.io/upload_images/5363507-1fae39a8be3e1c86.gif?imageMogr2/auto-orient/strip)

![QQ视频20190425101839.gif](https://upload-images.jianshu.io/upload_images/5363507-391549c3dfb8fc7f.gif?imageMogr2/auto-orient/strip)

* 欢迎下载体验
![image.png](https://upload-images.jianshu.io/upload_images/5363507-634702040b7d14bc.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

*   **本文代码的地址：[AndroidXMotionLayoutDemo（求star）](https://github.com/Shimingli/AndroidXMotionLayoutDemo)**


####  MotionLayout是什么？
![image.png](https://upload-images.jianshu.io/upload_images/5363507-6e5cd93cf4e8a2bd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
* MotionLayout 继承ConstraintLayout 实现 NestedScrollingParent2 ，是谷歌的一个新的Layout！能实现上面有趣的效果

* **1、基本示例1/2 左右移动 ，然后慢慢的滚回到远点**
     *  使用引用的ConstraintLayout文件的基本运动示
      设置MotionLayout的`app:layoutDescription="@xml/scene_01"` 左右移动 ，然后慢慢的滚回到远点
![image.png](https://upload-images.jianshu.io/upload_images/5363507-aafc9300acf911b4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


* **2、基本示例2/2 左右移动，另外的一种的实现的方式 ，可以改变小球的大小**
     *  使用在MotionScene文件中定义的约束集的基本运动示例
 tools:layout_editor_absoluteX="147dp"  表示此控件在布局中X轴的绝对坐标点。 tools:layout_editor_absoluteY="230dp" 表示此控件在布局中X轴的绝对坐标点。
![image.png](https://upload-images.jianshu.io/upload_images/5363507-51fb944aea7c4f8b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


* **3、自定义属性**
         *  左右移动，颜色渐变，大小渐变，在中间，我个人感觉是两个颜色的重叠，注意在布局中的颜色其实设置没有什么作用
![image.png](https://upload-images.jianshu.io/upload_images/5363507-457ca8a3c737166e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image.png](https://upload-images.jianshu.io/upload_images/5363507-b0f77d2b94bc7c1e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image.png](https://upload-images.jianshu.io/upload_images/5363507-84e7d4c3f7c4ff56.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* **4、ImageFilterView1/2**
     *  使用IamgeFilterView 两张图片的重合，左右滑动，可以不断的切换图片 在两张图片之间做的淡入淡出 (cross-fade) 效果
![image.png](https://upload-images.jianshu.io/upload_images/5363507-9799c762bd01e78e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image.png](https://upload-images.jianshu.io/upload_images/5363507-8e4bcdd74123b0e2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image.png](https://upload-images.jianshu.io/upload_images/5363507-48f3869f8b46689f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* **5、ImageFilterView2/2**
     * 显示图像饱和度转换（使用ml的imagefilterview+自定义属性）
![image.png](https://upload-images.jianshu.io/upload_images/5363507-e040661ed396ae1e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/5363507-579f522c47ac6b81.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* Saturation 饱和度的意思  图片在上下位移的时候 ，动态改变饱和度    motion:attributeName="Saturation" 从1变为0
* 什么是图像的饱和度？饱和度指的是图像的颜色的浓度，饱和度越高，颜色越饱满，饱和度越低，颜色就会显示的陈旧和惨淡，饱和度为0，图像就是灰色的图像


* **6、关键帧位置（1/3）**
     * 使用简单的关键帧更改插值运动
![image.png](https://upload-images.jianshu.io/upload_images/5363507-0be87acdb9e3f710.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/5363507-2de864cd16dafe55.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


* **7、关键帧插值（2/3）**
     * 更复杂的关键帧，添加旋转插值,加上了自身的旋转

![image.png](https://upload-images.jianshu.io/upload_images/5363507-d2bb3ce2e04b88c1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/5363507-64c1e36ade899e0b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image.png](https://upload-images.jianshu.io/upload_images/5363507-eb0424e12dbc84d4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* **8、关键帧周期（3/3）**
     * 关键帧 使用了抛物线的轨迹
![image.png](https://upload-images.jianshu.io/upload_images/5363507-d80536354b0166d8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/5363507-b39ae378a22f82f3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


* **9、CoordinatorLayout示例（1/3）**
     * 使用motionlayout+appbarlayout的基本示例
![image.png](https://upload-images.jianshu.io/upload_images/5363507-2fe6f45bae855c97.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
     * CollapsibleToolbar 是把位移的监听 直接放到自己的类来了，可以很方便的节约性能，这种方式定义自定义控件有很好的效果
![image.png](https://upload-images.jianshu.io/upload_images/5363507-56d9a1386b865f28.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


* **10、CoordinatorLayout示例示例（2/3**
     * 用多个元素和视差背景替换appbarlayout的稍复杂的motionlayout示例
     * app:fontFamily="cursive" 字体的设置
layout_constraintBaseline_toBaselineOf 我个人理解就是这个文字要和 label 这一行在同一行: layout_constraint（本组件的部位）_to（建立连接的组件部位）Of：（建立连接的id）
![image.png](https://upload-images.jianshu.io/upload_images/5363507-6b5284be79c0d0b6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


* **11、CoordinatorLayout示例3/3**
     * 另一个 AppBarLayout 替换示例
![image.png](https://upload-images.jianshu.io/upload_images/5363507-db1d75870d840b3d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/5363507-3971a1ac42317a24.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* **12、drawerlayout示例（1/2）**
     * 抽屉布局 记得往右拉动，一个很复杂的布局动画 牛逼
![image.png](https://upload-images.jianshu.io/upload_images/5363507-5bab01593a4c65df.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/5363507-ffce2aea91d6158d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* **13、drawerlayout示例（2/2）**
     *  这个动画做的不太一样，从旋转的方向看不一样
![image.png](https://upload-images.jianshu.io/upload_images/5363507-bcd83a73c6d0da20.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


* **14、侧面板示例**
     * 侧面板，与motionlayout一起实现,侧板的信息栏，这里是可以展示侧边的抽屉框。但是不知道有什么用处 MockView MockView(新特性的布局)

![image.png](https://upload-images.jianshu.io/upload_images/5363507-4e3c8dbd618e1e56.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/5363507-589eccd7d0c973a3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* **15、视差示例**
     * 就是使用 新的特性控制下，拖拽的效果，背景有个变大的效果

![image.png](https://upload-images.jianshu.io/upload_images/5363507-e28840ba33d652c2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/5363507-3f88c7d4abf98049.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* **16、ViewPagerActivit和Viewpager使用的实例**
  ![image.png](https://upload-images.jianshu.io/upload_images/5363507-f8f44ea8319426a9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/5363507-0abcc06c110766e5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image.png](https://upload-images.jianshu.io/upload_images/5363507-1c3c5fdf67996114.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


* **17、ViewPager Lottie Example**
     * lottie是一个面向Android和iOS的移动库，它解析导出为带有bodymovin的json格式的Adobe After Effects动画，并在移动设备上进行本地渲染！
      *   第一次，设计师可以创造和发送美丽的动画，而无需一个工程师刻意用手重新创造。他们说一张图片值1000个字，所以这里有13000个：

![image.png](https://upload-images.jianshu.io/upload_images/5363507-0a304e6b981abcfe.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image.png](https://upload-images.jianshu.io/upload_images/5363507-0816c34698e8de5b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


* **18、复杂运动示例（1/4）**
     * 其实就是给一个图形花了一个对角线的东西
![image.png](https://upload-images.jianshu.io/upload_images/5363507-dcfe2ee23d4ad7f3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


* **19、复杂运动示例（2/4）**
     * 配合着 FloatingActionButton 使用 这个控件的动画是由谁来控制的呢？是由secen_18 控制的

![image.png](https://upload-images.jianshu.io/upload_images/5363507-44944660892f2255.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* **20、复杂运动示例（3/4）**
     * 高级协调布局类似行为（添加FAB），视图调整了大小
     *  配合着 FloatingActionButton 使用  视图发生了放大的效果


* **21、复杂运动示例（4/4）"**
     * 高级同步reval运动+助手（反弹），这个动画比较炫酷哦

![image.png](https://upload-images.jianshu.io/upload_images/5363507-2b4411c9a479aff7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* **22、Fragment转换示例（1/2）**
     * 这种新的特性我一定要利用起来啊

![image.png](https://upload-images.jianshu.io/upload_images/5363507-87c6817e44c68ac9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image.png](https://upload-images.jianshu.io/upload_images/5363507-223e0aaccd25d8b4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


* **23、Fragment转换示例（2/2）**
     * 使用动画，开启一个fragment 然后这个fragment中有一个list条目，点击这item，开启itemfragment，然后呢，中间这个listFragment就自动关闭了，慢慢的拖动，也可以返回到上一个fragment，下一个使用这个效果，很有意思哦
    谷歌的Demo有两处的错误 ，我提了 issues
    https://github.com/googlesamples/android-ConstraintLayoutExamples/issues/76
   https://github.com/googlesamples/android-ConstraintLayoutExamples/issues/75


* **24、YouTube类运动示例**
     * 显示像YouTube一样的过渡示例
    *  BottomNavigationView 这个导航栏的使用，复杂的动画效果

![image.png](https://upload-images.jianshu.io/upload_images/5363507-e1c0be81368e3d77.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)








#### 感谢Google官方的Demo给与我的帮助，再次感谢
*   **Google官方的Demo：[Google Samples](https://github.com/googlesamples)**
*   **Google官方的Demo：[ConstraintLayoutExamples](https://github.com/googlesamples/android-ConstraintLayoutExamples**

