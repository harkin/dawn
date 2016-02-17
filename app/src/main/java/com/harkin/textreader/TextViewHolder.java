package com.harkin.textreader;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class TextViewHolder extends RecyclerView.ViewHolder {
    private final TextView text;

    public TextViewHolder(View itemView) {
        super(itemView);
        text = (TextView) itemView;
    }

    public void set(String string) {
        text.setText(string);
    }
}
