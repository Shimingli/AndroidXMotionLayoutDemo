package com.lsm.androidx.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/3 19:22
 */
public class BoundsImageView extends ImageView {

    Paint mPaint=new Paint();

    public BoundsImageView(Context context) {
        this(context,null);
    }

    public BoundsImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setARGB(255,200,0,0);
        mPaint.setStrokeWidth(4);
    }

    /**
     * 当这个View的ondraw的时候 其实就是花了两个对角线
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0f,0f,getWidth(),getHeight(),mPaint);
        canvas.drawLine(0f,getHeight(),getWidth(),0f,mPaint);
    }
}
