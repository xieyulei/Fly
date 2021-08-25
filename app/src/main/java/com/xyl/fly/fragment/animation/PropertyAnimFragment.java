package com.xyl.fly.fragment.animation;

import android.animation.ValueAnimator;

import com.blankj.utilcode.util.ToastUtils;
import com.xyl.fly.R;
import com.xyl.fly.base.BaseFragment;
import com.xyl.fly.databinding.PropertyFragmentBinding;

/**
 * PropertyAnimFragment:属性动画练习页
 *
 * @author xyl
 * @date 2021-08-20
 */
public class PropertyAnimFragment extends BaseFragment<PropertyFragmentBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.property_fragment;
    }

    @Override
    protected void initListener() {
        mDataBinding.btnOfInt.setOnClickListener(v -> startAnimByValueOfInt());
        mDataBinding.btnOfFloat.setOnClickListener(v -> startAnimByValueOfFloat());
        mDataBinding.btnOfObject.setOnClickListener(v -> startAnimByValueOfObject());
    }

    private void startAnimByValueOfInt() {
        // 1.设置属性的初始值&结束值
        ValueAnimator animator = ValueAnimator.ofInt(mDataBinding.ivProperty.getLayoutParams().width, 800);

        // 2.设置动画的运行时长
        animator.setDuration(2000);

        // 3.设置动画延迟播放的时间
        animator.setStartDelay(10);

        // 4.设置播放次数
        animator.setRepeatCount(2);

        // 5.设置播放顺序
        animator.setRepeatMode(ValueAnimator.REVERSE);

        // 6.将属性数值手动赋值给对象的属性，此处是将值赋值给按钮的宽度，设置更新监听器，每次数值发生变化更新都会调用此方法
        animator.addUpdateListener(animation -> {
            // 7.每次值发生变化时，将值手动赋值给对象的属性
            mDataBinding.ivProperty.getLayoutParams().width = (int) animation.getAnimatedValue();

            // 8.刷新视图，重新绘制
            mDataBinding.ivProperty.requestLayout();
        });
        // 9.启动动画
        animator.start();
    }

    /**
     * 与ofInt的区别在于value是float类型与int类型，其余都一样
     */
    private void startAnimByValueOfFloat() {
        // 1.设置属性的初始值&结束值
        ValueAnimator animator = ValueAnimator.ofInt(mDataBinding.ivProperty.getLayoutParams().width, 0);

        // 2.设置动画的运行时长
        animator.setDuration(2000);

        // 3.设置动画延迟播放的时间
        animator.setStartDelay(10);

        // 4.设置播放次数
        animator.setRepeatCount(2);

        // 5.设置播放顺序
        animator.setRepeatMode(ValueAnimator.REVERSE);

        // 6.将属性数值手动赋值给对象的属性，此处是将值赋值给按钮的宽度，设置更新监听器，每次数值发生变化更新都会调用此方法
        animator.addUpdateListener(animation -> {
            // 7.每次值发生变化时，将值手动赋值给对象的属性
            mDataBinding.ivProperty.getLayoutParams().width = (int) animation.getAnimatedValue();

            // 8.刷新视图，重新绘制
            mDataBinding.ivProperty.requestLayout();
        });
        // 9.启动动画
        animator.start();
    }

    /**
     * 1.定义对象类:Point
     * 2.自定义估值器:CircleEvaluator
     * 3.将属性动画作用到自定义View
     * 4.布局文件中加入自定义View
     * 5.在主代码中设置显示视图
     */
    private void startAnimByValueOfObject() {
        ToastUtils.showShort(R.string.IDS_PROPERTY_ANIM_VALUE_OF_OBJECT_DEMO);
    }
}
