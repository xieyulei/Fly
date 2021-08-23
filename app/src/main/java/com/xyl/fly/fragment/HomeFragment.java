package com.xyl.fly.fragment;

import androidx.navigation.Navigation;

import com.xyl.fly.R;
import com.xyl.fly.base.BaseFragment;
import com.xyl.fly.databinding.HomeFragmentBinding;

/**
 * HomeFragment:主页面
 *
 * @author xyl
 * @date 2021-08-20
 */
public class HomeFragment extends BaseFragment<HomeFragmentBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initListener() {
        mDataBinding.btnHomeToAnim.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_baseAnimFragment));
    }
}
