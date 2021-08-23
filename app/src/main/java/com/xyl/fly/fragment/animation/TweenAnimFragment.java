package com.xyl.fly.fragment.animation;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.blankj.utilcode.util.ScreenUtils;
import com.xyl.fly.R;
import com.xyl.fly.Utils;
import com.xyl.fly.base.BaseFragment;
import com.xyl.fly.databinding.TweenFragmentBinding;

/**
 * TweenAnimFragment:补间动画练习页
 *
 * @author xyl
 * @date 2021-08-20
 */
public class TweenAnimFragment extends BaseFragment<TweenFragmentBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.tween_fragment;
    }

    @Override
    protected void initListener() {
        mDataBinding.btnTranlate.setOnClickListener(v -> startTranlateAnimation());
        mDataBinding.btnRotate.setOnClickListener(v -> startRotateAnimation());
        mDataBinding.btnScale.setOnClickListener(v -> startScaleAnimation());
        mDataBinding.btnAlpha.setOnClickListener(v -> startAlphaAnimation());
    }

    /**
     * 平移动画
     * <p>
     * 通用属性：
     * duration:动画持续时间
     * startOffset:动画延迟开始时间
     * fillBefore:播放完毕是否停留在动画开始的状态，默认true
     * fillAfter:播放完毕是否停留在动画结束的状态，优先于fillBefore,默认为false
     * fillEnabled:是否应用fillBefore值，对fillAfter无影响，默认为true
     * repeatCount:重放次数，播放次数的repeatCount+1
     * repeatMode:重复播放模式，reverse表示倒序，restart表示正序，默认restart
     * interpolator:插值器，影响动画的播放速度
     * Utils.coinOfDestiny():随机概率使用XML或者Code方式产生动画
     * <p>
     * fromXDelta:视图在水平X轴方向开始移动的起始值
     * toXDelta:视图在水平X轴方向开始移动的结束值
     * fromYDelta:视图在竖直Y轴方向开始移动的起始值
     * toYDelta:视图在竖直Y轴方向开始移动的结束值
     */
    private void startTranlateAnimation() {
        Animation translateAnimation;
        if (Utils.coinOfDestiny()) {
            translateAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.translate_anim);
        } else {
            translateAnimation = new TranslateAnimation(10, ScreenUtils.getScreenWidth(), 10, 10);
            translateAnimation.setRepeatMode(Animation.REVERSE);
            translateAnimation.setRepeatCount(2);
            translateAnimation.setDuration(300);
        }
        mDataBinding.testIv.startAnimation(translateAnimation);
    }

    /**
     * 旋转动画
     * <p>
     * fromDegress:旋转开始角度，正数顺时针，负数逆时针
     * toDegress:旋转结束时的角度，正数顺时针，负数逆时针
     * pivotX:旋转轴的x坐标
     * povotY:旋转轴的y坐标
     * <p>
     * pivotX pivotY,可取值为数字，百分比，或者百分比p
     * 设置为数字时（如50），轴点为View的左上角的原点在x方向和y方向加上50px的点。在Java代码里面设置这个参数的对应参数是Animation.ABSOLUTE。
     * 设置为百分比时（如50%），轴点为View的左上角的原点在x方向加上自身宽度50%和y方向自身高度50%的点。在Java代码里面设置这个参数的对应参数是Animation.RELATIVE_TO_SELF。
     * 设置为百分比p时（如50%p），轴点为View的左上角的原点在x方向加上父控件宽度50%和y方向父控件高度50%的点。在Java代码里面设置这个参数的对应参数是Animation.RELATIVE_TO_PARENT
     * 两个50%表示动画从自身中间开始
     */
    private void startRotateAnimation() {
        Animation rotateAnimation;
        if (Utils.coinOfDestiny()) {
            rotateAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate_anim);
        } else {
            rotateAnimation = new RotateAnimation(0, 360, mDataBinding.testIv.getPivotX(), mDataBinding.testIv.getPivotY());
            rotateAnimation.setDuration(300);
            rotateAnimation.setRepeatMode(Animation.RESTART);
            rotateAnimation.setRepeatCount(2);
        }
        mDataBinding.testIv.startAnimation(rotateAnimation);
    }

    /**
     * 缩放动画
     * fromXScale：x轴起始缩放倍数
     * toXScale:y轴结束播放倍数(0.0表示收缩到没有；1.0表示正常无伸缩，值小于1.0表示收缩；值大于1.0表示放大)
     * fromYScale:y轴起始缩放倍数
     * toYScale:y轴结束缩放倍数
     */
    private void startScaleAnimation() {
        Animation scaleAnimation;
        if (Utils.coinOfDestiny()) {
            scaleAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.scale_anim);
        } else {
            scaleAnimation = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f, 0, 0);
            scaleAnimation.setRepeatCount(2);
            scaleAnimation.setRepeatMode(Animation.REVERSE);
            scaleAnimation.setDuration(300);
        }
        mDataBinding.testIv.startAnimation(scaleAnimation);
    }

    /**
     * 透明动画
     * <p>
     * fromX:动画在水平方向X的开始播放倍速
     * toX:动画在水平方向X的结束缩放倍数
     * fromY:动画在竖直方向Y的开始播放倍速
     * toY:动画在竖直方向Y的结束缩放倍数
     * pivotYType：旋转轴点的y坐标的模式
     * pivotXValue：旋转轴点x坐标的相对值
     * pivotYValue：旋转轴点y坐标的相对值
     * <p>
     * pivotXType = Animation.ABSOLUTE:缩放轴点的x坐标 =  View左上角的原点 在x方向 加上 pivotXValue数值的点(y方向同理)
     * pivotXType = Animation.RELATIVE_TO_SELF:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 自身宽度乘上pivotXValue数值的值(y方向同理)
     * pivotXType = Animation.RELATIVE_TO_PARENT:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 父控件宽度乘上pivotXValue数值的值 (y方向同理)
     */
    private void startAlphaAnimation() {
        Animation alphaAnimation;
        if (Utils.coinOfDestiny()) {
            alphaAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.alpha_anim);
        } else {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300);
            alphaAnimation.setRepeatMode(Animation.RESTART);
            alphaAnimation.setRepeatCount(2);
        }
        mDataBinding.testIv.startAnimation(alphaAnimation);
    }
}
