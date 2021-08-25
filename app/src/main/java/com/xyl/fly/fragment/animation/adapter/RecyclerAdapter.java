package com.xyl.fly.fragment.animation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xyl.fly.R;
import com.xyl.fly.fragment.animation.listener.RecyclerItemCallback;
import com.xyl.fly.fragment.animation.model.TextItem;

import java.util.List;

/**
 * RecyclerAdapter
 *
 * @author xyl
 * @date 2021-08-25
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private final List<TextItem> mItemList;
    private final RecyclerItemCallback mItemCallback;

    public RecyclerAdapter(Context context, List<TextItem> list, RecyclerItemCallback itemCallback) {
        mContext = context;
        mItemList = list;
        mItemCallback = itemCallback;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_text_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mItemList.get(position).getValue());
        holder.itemView.setOnClickListener(v -> {
            if (mItemCallback != null) {
                mItemCallback.onItemClick(mItemList.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.rv_item_text);
        }
    }
}
