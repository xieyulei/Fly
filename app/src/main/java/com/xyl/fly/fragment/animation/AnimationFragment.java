package com.xyl.fly.fragment.animation;

import androidx.navigation.Navigation;

import com.xyl.fly.R;
import com.xyl.fly.base.BaseFragment;
import com.xyl.fly.databinding.AnimationFragmentBinding;

/**
 * BaseAnimFragment:动画练习内容列表页
 *
 * @author xyl
 * @date 2021-08-20
 */
public class AnimationFragment extends BaseFragment<AnimationFragmentBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.animation_fragment;
    }

    @Override
    protected void initListener() {
        mDataBinding.btnBaseAnimToTween.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_baseAnimFragment_to_tweenAnimFragment));

        mDataBinding.btnBaseAnimToFrame.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_baseAnimFragment_to_frameAnimFragment));

        mDataBinding.btnBaseAnimToProperty.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_baseAnimFragment_to_propertyAnimFragment));
    }
}