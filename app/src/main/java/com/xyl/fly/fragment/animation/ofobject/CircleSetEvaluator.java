package com.xyl.fly.fragment.animation.ofobject;

import android.animation.TypeEvaluator;

/**
 * CircleSetEvaluator
 *
 * @author xyl
 * @date 2021-08-25
 */
public class CircleSetEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        // 获取颜色的初始值和结束值
        String startColor = (String) startValue;
        String endColor = (String) endValue;

        // 通过字符串截取的方式将初始化颜色分为RGB三个部分，并将RGB的值转换成十进制数字，那么每个颜色的取值范围为0-255
        int startRed = Integer.parseInt(startColor.substring(1, 3), 16);
        int startGreen = Integer.parseInt(startColor.substring(3, 5), 16);
        int startBlue = Integer.parseInt(startColor.substring(5, 7), 16);

        int endRed = Integer.parseInt(endColor.substring(1, 3), 16);
        int endGreen = Integer.parseInt(endColor.substring(3, 5), 16);
        int endBlue = Integer.parseInt(endColor.substring(5, 7), 16);

        // 将初始化颜色的值定义为当前需要操作的颜色值
        int currentRed = startRed;
        int currentGreen = startGreen;
        int currentBlue = startBlue;

        // 计算初始颜色和结束颜色的差值，该差值决定着颜色的变化快慢：颜色相近就变化缓慢，否则就会变化很快

        int redDiff = Math.abs(startRed - endRed);
        int greenDiff = Math.abs(startGreen - endGreen);
        int blueDiff = Math.abs(startBlue - endBlue);
        int colorDiff = redDiff + greenDiff + blueDiff;

        if (currentRed != endRed) {
            currentRed = getCurrentColor(startRed, endRed, colorDiff, fraction);
        } else if (currentGreen != endGreen) {
            currentGreen = getCurrentColor(startGreen, endGreen, colorDiff, fraction);
        } else if (currentBlue != endBlue) {
            currentBlue = getCurrentColor(startBlue, endBlue, colorDiff, fraction);
        }

        // 将计算出的当前颜色值组装返回
        return "#" + getHexString(currentRed) + getHexString(currentGreen) + getHexString(currentBlue);
    }

    private int getCurrentColor(int startColor, int endColor, int colorDiff, float fraction) {
        int currentColor;
        if (startColor > endColor) {
            currentColor = (int) (startColor - (fraction * colorDiff - 0));
            if (currentColor < endColor) {
                currentColor = endColor;
            }
        } else {
            currentColor = (int) (startColor + (fraction * colorDiff - 0));
            if (currentColor > endColor) {
                currentColor = endColor;
            }
        }
        return currentColor;
    }

    private String getHexString(int value) {
        String hexString = Integer.toHexString(value);
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        return hexString;
    }
}
