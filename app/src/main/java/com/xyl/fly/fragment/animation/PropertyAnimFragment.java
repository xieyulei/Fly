package com.xyl.fly.fragment.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.blankj.utilcode.util.ToastUtils;
import com.xyl.fly.R;
import com.xyl.fly.base.BaseFragment;
import com.xyl.fly.databinding.PropertyFragmentBinding;
import com.xyl.fly.fragment.animation.adapter.RecyclerAdapter;
import com.xyl.fly.fragment.animation.listener.RecyclerItemCallback;
import com.xyl.fly.fragment.animation.model.TextItem;
import com.xyl.fly.fragment.animation.ofobject.CircleSetEvaluator;
import com.xyl.fly.util.AppUtils;
import com.xyl.fly.util.ArrayUtils;

import java.util.List;

/**
 * PropertyAnimFragment:属性动画练习页
 *
 * @author xyl
 * @date 2021-08-20
 */
public class PropertyAnimFragment extends BaseFragment<PropertyFragmentBinding> implements RecyclerItemCallback {

    private static final String TAG = "PropertyAnimFragment";

    @Override
    protected int getLayoutResId() {
        return R.layout.property_fragment;
    }

    @Override
    protected void initListener() {
        List<TextItem> valueAnimList = ArrayUtils.getPropertyAnimList(requireContext(), R.array.value_anim_list_values);
        List<TextItem> objectAnimList = ArrayUtils.getPropertyAnimList(requireContext(), R.array.object_anim_list_values);

        RecyclerAdapter valueAnimAdapter = new RecyclerAdapter(requireActivity(), valueAnimList, this);
        mDataBinding.propertyValueAnimatorRv.setLayoutManager(new LinearLayoutManager(requireContext()));
        mDataBinding.propertyValueAnimatorRv.setAdapter(valueAnimAdapter);

        RecyclerAdapter objectAnimAdapter = new RecyclerAdapter(requireActivity(), objectAnimList, this);
        mDataBinding.propertyObjectAnimatorRv.setLayoutManager(new LinearLayoutManager(requireContext()));
        mDataBinding.propertyObjectAnimatorRv.setAdapter(objectAnimAdapter);

        mDataBinding.btnViewWrapper.setOnClickListener(v -> startAnimByObjectWrapperAnimator());
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onItemClick(int resId) {
        switch (resId) {
            case R.string.IDS_PROPERTY_ANIM_VALUE_OF_INT:
                startAnimByValueOfInt();
                break;
            case R.string.IDS_PROPERTY_ANIM_VALUE_OF_FLOAT:
                startAnimByValueOfFloat();
                break;
            case R.string.IDS_PROPERTY_ANIM_VALUE_OF_OBJECT:
                startAnimByValueOfObject();
                break;
            case R.string.IDS_PROPERTY_ANIM_OBJECT:
                startAnimByObjectAnimator();
                break;
            case R.string.IDS_PROPERTY_ANIM_VIEW_PROPERTY:
                startAnimByViewProperty();
                break;
            case R.string.IDS_TWEEN_ANIM_SET:
                startAnimatorSet();
                break;
            case R.string.IDS_ANIM_TRANSLATE_TYPE:
                startTranslateByPropertyAnim();
                break;
            case R.string.IDS_ANIM_ROTATE_TYPE:
                startRotateByPropertyAnim();
                break;
            case R.string.IDS_ANIM_SCALE_TYPE:
                startScaleByPropertyAnim();
                break;
            case R.string.IDS_ANIM_ALPHA_TYPE:
                startAlphaByPropertyAnim();
                break;
            default:
                break;
        }
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

    /**
     * 1.设置自定义对象、背景颜色、属性、估值器
     * 2.根据颜色估值器不断的改变值
     * 3.调用set设置背景颜色的属性值
     * 4.调用invalidate刷新视图，即调用onDraw重新绘制，从而实现动画效果
     */
    private void startAnimByObjectAnimator() {
        ObjectAnimator animator = ObjectAnimator.ofObject(mDataBinding.circleSetView, "color", new CircleSetEvaluator(),
                "#0000FF", "#FF0000");
        animator.setDuration(3000);
        animator.start();
    }

    /**
     * 当view的set方法不是设置属性或者根本就没有set、get方法时使用
     * 给类包装原始对象，通过包装原始动画对象，间接给对象加上该属性的get、set方法
     * 本质上是采用了设计模式中的装饰模式，即通过包装类从而扩展对象的功能
     */
    public void startAnimByObjectWrapperAnimator() {
        ViewWrapper viewWrapper = new ViewWrapper(mDataBinding.btnViewWrapper);
        ObjectAnimator.ofInt(viewWrapper, "width", 200, 400, 800, 1000).setDuration(3000).start();
    }

    /**
     * 组合动画
     * 单一动画实现效果有限，更多情况下是同时使用多种动画组合
     * 实现类：AnimatorSet
     * AnimatorSet.play(Animator anim):播放当前动画
     * AnimatorSet.after(long delay):将现有动画延迟x毫秒后执行
     * AnimatorSet.with(Animator anim):将现有动画和传入的动画同时执行
     * AnimatorSet.after(Animator anim):将现有动画插入到传入的动画之后执行
     * AnimatorSet.before(Animator anim):将现有动画插入到传入的动画之前执行
     */
    private void startAnimatorSet() {
        AnimatorSet animatorSet;
        if (AppUtils.coinOfDestiny()) {
            float curTranslationX = mDataBinding.btnViewWrapper.getTranslationX();
            ObjectAnimator translation = ObjectAnimator.ofFloat(mDataBinding.btnViewWrapper, "translationX", curTranslationX, 300, curTranslationX);
            ObjectAnimator rotate = ObjectAnimator.ofFloat(mDataBinding.btnViewWrapper, "rotation", 0f, 360f);
            ObjectAnimator alpha = ObjectAnimator.ofFloat(mDataBinding.btnViewWrapper, "alpha", 1.0f, 0.0f, 1.0f);

            animatorSet = new AnimatorSet();
            animatorSet.play(translation).with(rotate).before(alpha);
            animatorSet.setDuration(4000);
        } else {
            animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(requireContext(), R.animator.set_animator);
            animatorSet.setTarget(mDataBinding.btnViewWrapper);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                Log.e(TAG, "AnimatorSet Start");
            }
        });
        animatorSet.start();
    }

    /**
     * 属性动画的本质是对值操作，但java是面向对象的，使用ViewPropertyAnimator
     * 可认为是属性动画的一种简写方式
     * 注意：这种方式，动画会自动启动，无需调用start方法，因为新接口中使用了隐式启动动画的功能
     * 只要将动画定义完成后，动画就会自动启动，该机制对于组合动画也同样有效，只要不断得连续点缀新的方法，
     * 动画就不会立刻执行，等到所有在ViewPropertyAnimator上设置的方法都执行完毕后，动画就会自动启动
     * 如果不想使用这一默认机制，也可以显式的调用start方法来启动动画
     */
    private void startAnimByViewProperty() {
        mDataBinding.btnViewWrapper.animate().alpha(0f).x(500).y(500).alpha(1.0f).translationX(-500f).rotation(360);
    }

    private void startTranslateByPropertyAnim() {
        float currentX = mDataBinding.ivProperty.getX();
        ObjectAnimator animator = ObjectAnimator.ofFloat(mDataBinding.ivProperty, "translationX", currentX, 800, currentX);
        animator.setDuration(3000);
        animator.start();
    }

    private void startRotateByPropertyAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mDataBinding.ivProperty, "rotation", 0f, 360f);
        animator.setDuration(3000);
        animator.start();
    }

    private void startScaleByPropertyAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mDataBinding.ivProperty, "scaleX", 1f, 3f, 1f);
        animator.setDuration(3000);
        animator.start();
    }

    private void startAlphaByPropertyAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mDataBinding.ivProperty, "alpha", 1.0f, 0.0f, 1.0f);
        animator.setDuration(3000);
        animator.start();
    }

    public static class ViewWrapper {
        private final View mTarget;

        public ViewWrapper(View target) {
            mTarget = target;
        }

        public int getWidth() {
            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width) {
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }
    }
}
