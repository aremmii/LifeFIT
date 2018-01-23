package com.thailife.app.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thailife.app.databinding.HolderEventItemBinding;

/**
 * Created by PromptNow5 on 12/8/2017.
 */

public class EventItemRecyclerAdapter extends RecyclerView.Adapter<EventItemRecyclerAdapter.EventViewHolder> {

    HolderEventItemBinding binding;

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = HolderEventItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new EventViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {

        HolderEventItemBinding binding;

        public EventViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
