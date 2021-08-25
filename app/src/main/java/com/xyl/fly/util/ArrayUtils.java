package com.xyl.fly.util;

import android.content.Context;
import android.content.res.TypedArray;

import com.xyl.fly.fragment.animation.model.TextItem;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayUtils:获取数组列表工具类
 *
 * @author xul
 * @date 2021-08-25
 */
public class ArrayUtils {

    public static List<TextItem> getPropertyAnimList(Context context, int arrayValues) {
        List<TextItem> list = new ArrayList<>();
        String[] stringArray = context.getResources().getStringArray(arrayValues);
        TypedArray ta = context.getResources().obtainTypedArray(arrayValues);
        for (int i = 0; i < stringArray.length; i++) {
            int id = ta.getResourceId(i, -1);
            list.add(new TextItem(id, stringArray[i]));
        }
        ta.recycle();
        return list;
    }
}
