package com.xiaoxing.hide;

import android.util.SparseArray;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @Description: 描述
 * @Author: qushaohua
 * @CreateDate: 2022/2/17 10:03 上午
 */
public abstract class MyViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews = new SparseArray<>();

    @SuppressWarnings("unchecked")
    public <T extends View> T findViewById(int viewId){
        View view = mViews.get(viewId);
        if (view == null){
            view = itemView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    public MyViewHolder(View view) {
        super(view);
    }

    public abstract View getView();
}
