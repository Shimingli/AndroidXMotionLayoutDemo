package com.lsm.androidx.fragment;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import com.lsm.androidx.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/7 11:49
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    private final ArrayList<User> mData;

    public CustomAdapter(ArrayList<User> data) {
        mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,
                parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
      holder.mTxtName.setText(mData.get(position).getName());
      holder.mTxtTitle.setText(mData.get(position).getTitle());

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //1 ConstraintLayout 2 TouchFrameLayout 3 TouchFrameLayout 4 MotionLayout
              ViewParent parent = v.getParent().getParent().getParent().getParent();
              if (parent instanceof MotionLayout){

                  //Android的Rect类是形成一个矩形的区域，区域在Android整个界面中的位置由left,top,right,bottom数值来控制，下面的图介绍了这四个值的意思。
                  Rect rect = new Rect();
                  System.out.println("shiming start"+rect.bottom);
                  //赋值
                  // 获取View的绘制范围，即左、上、右、下边界相对于此View的左顶点的距离（偏移量），即0、0、View的宽、View的高
                  ((MotionLayout) parent).getDrawingRect(rect);
                  System.out.println("shiming end"+rect.bottom);// end1792
                  System.out.println("shiming end"+rect.top);//0
                  System.out.println("shiming end"+rect.left);//0
                  System.out.println("shiming end"+rect.right);//end1080


                  //我们手动减小一下往下偏移的距离
                  rect.bottom=rect.bottom-500;
                  rect.set(0,0,rect.right,rect.bottom-1000);
                  // 通过输出得到，这4个值 其实就是我们手机的屏幕 ，然后移动过去藏起来

                  //*偏移位于后代坐标中的矩形
                  //*空间进入我们的坐标空间。
                  // 理解就是让 将后代坐标空间中的矩形偏移到坐标空间中。
                  //通过上面的实验，其实发现这样代码是没有用处的
//                  ((MotionLayout) parent).offsetDescendantRectToMyCoords(v,rect);
                  if (v.getContext() instanceof AppCompatActivity){
                      //当点击到这里来了，就是上面有位置了，我们这个itemfragment需要到的矩形中去
                      FragmentTransaction fragmentTransaction =
                              ((AppCompatActivity) v.getContext()).getSupportFragmentManager().beginTransaction();
                      ItemFragment instance = ItemFragment.getInstance();
                      fragmentTransaction.replace(R.id.container,instance);
                      fragmentTransaction.commitNow();
                      instance.update(holder);
                      ((MotionLayout) parent).transitionToEnd();

                  }

              }
          }
      });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView mTxtName;
        public final TextView mTxtTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxtName = itemView.findViewById(R.id.txtName);
            mTxtTitle = itemView.findViewById(R.id.txtTitle);

        }
    }
}
