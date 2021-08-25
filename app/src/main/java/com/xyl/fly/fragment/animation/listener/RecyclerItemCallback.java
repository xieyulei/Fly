package com.xyl.fly.fragment.animation.listener;

/**
 * @author xyl
 * @date 2021-08-25
 */
public interface RecyclerItemCallback {
    /**
     * RecyclerView的子项点击返回资源id
     *
     * @param resId 资源id
     */
    void onItemClick(int resId);
}
