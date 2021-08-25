package com.xyl.fly.fragment.animation.ofobject;

import android.animation.TypeEvaluator;

/**
 * CircleEvaluator:圆形图标的估值器
 *
 * @author xyl
 * @date 2021-08-25
 */
public class CircleEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;

        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        return new Point(x, y);
    }
}
