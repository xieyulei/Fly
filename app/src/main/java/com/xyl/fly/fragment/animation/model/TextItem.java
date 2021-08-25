package com.xyl.fly.fragment.animation.model;

/**
 * @author xyl
 * @date 2021-08-25
 */
public class TextItem {
    private final int mId;
    private final String mValue;

    public TextItem(int id, String textValue) {
        this.mId = id;
        this.mValue = textValue;
    }

    public int getId() {
        return mId;
    }

    public String getValue() {
        return mValue;
    }
}
