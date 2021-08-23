package com.xyl.fly.fragment.animation;

import android.graphics.drawable.AnimationDrawable;

import com.xyl.fly.R;
import com.xyl.fly.base.BaseFragment;
import com.xyl.fly.databinding.FrameFragmentBinding;

/**
 * FrameAnimFragment
 *
 * @author xyl
 * @date 2021-08-23
 */
public class FrameAnimFragment extends BaseFragment<FrameFragmentBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.frame_fragment;
    }

    @Override
    protected void initListener() {
        mDataBinding.btnStartFrame.setOnClickListener(v -> setFrameAnimation(true));

        mDataBinding.btnStopFrame.setOnClickListener(v -> {
            mDataBinding.ivFrame.setImageResource(R.drawable.frame_anim);

            setFrameAnimation(false);
        });
    }

    /**
     * 逐帧动画虽然可以在代码中生成，但是由于要循环遍历取出每一张图，然后添加，所以不建议这样做
     * 尽量使用xml定义drawable的方式，然后设置到控件中，然后开启动画即可。
     *
     * @param isStart:true表示开始动画，false表示停止动画
     */
    private void setFrameAnimation(boolean isStart) {
        mDataBinding.ivFrame.setImageResource(R.drawable.frame_anim);
        AnimationDrawable animationDrawable = (AnimationDrawable) mDataBinding.ivFrame.getDrawable();
        if (isStart) {
            animationDrawable.start();
        } else {
            animationDrawable.stop();
        }
    }
}
