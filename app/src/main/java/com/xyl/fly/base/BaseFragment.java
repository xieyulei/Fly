package com.xyl.fly.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

/**
 * BaseFragment
 *
 * @author xyl
 * @date 2021-08-20
 */
public abstract class BaseFragment<VM extends ViewDataBinding> extends Fragment {

    protected VM mDataBinding;

    /**
     * 为碎片创建视图（加载布局）时调用
     *
     * @param inflater:相当于findViewById,寻找res/layout目录下的xml布局文件
     * @param container:容器
     * @param savedInstanceState:保存当前的状态
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
    }

    /**
     * 返回布局资源
     *
     * @return 布局资源id
     */
    protected abstract int getLayoutResId();

    /**
     * 为页面View添加事件监听
     */
    protected abstract void initListener();
}
