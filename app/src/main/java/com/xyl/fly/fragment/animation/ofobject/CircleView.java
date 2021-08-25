package com.xyl.fly.fragment.animation.ofobject;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * CircleView
 *
 * @author xyl
 * @date 2021-08-25
 */
public class CircleView extends View {

    private static final float RADIUS = 60f;
    private final Paint mPaint;
    private Point mCurrentPoint;


    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        // 设定画笔颜色
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mCurrentPoint == null) {

            // 创建一个点对象（70，70）
            mCurrentPoint = new Point(RADIUS, RADIUS);

            // 根据点对象画一个圆
            float x = mCurrentPoint.getX();
            float y = mCurrentPoint.getY();
            canvas.drawCircle(x, y, RADIUS, mPaint);

            // 将属性动画应用到View中
            Point startPoint = new Point(RADIUS, RADIUS);
            Point endPoint = new Point(1035, 480);

            @SuppressLint("Recycle") ValueAnimator animator = ValueAnimator.ofObject(new CircleEvaluator(), startPoint, endPoint);
            animator.setDuration(3000);

            animator.addUpdateListener(animation -> {
                mCurrentPoint = (Point) animation.getAnimatedValue();
                invalidate();
            });
            animator.start();
        } else {
            float x = mCurrentPoint.getX();
            float y = mCurrentPoint.getY();
            canvas.drawCircle(x, y, RADIUS, mPaint);
        }
    }
}
