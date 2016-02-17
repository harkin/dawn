package com.harkin.textreader;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextViewHolder> {
    private final List<String> strings;
    private final LayoutInflater inflater;

    public TextAdapter(List<String> strings, LayoutInflater inflater) {
        this.strings = strings;
        this.inflater = inflater;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TextViewHolder(inflater.inflate(R.layout.row, parent, false));
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        holder.set(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }
}
