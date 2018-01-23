package com.thailife.app.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thailife.app.R;
import com.thailife.app.databinding.HolderEventBinding;

/**
 * Created by PromptNow5 on 12/8/2017.
 */

public class EventRecyclerAdapter extends RecyclerView.Adapter<EventRecyclerAdapter.EventViewHolder> {

    HolderEventBinding binding;

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.holder_event,parent,false);
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

        HolderEventBinding binding;

        public EventViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            EventItemRecyclerAdapter recyclerAdapter = new EventItemRecyclerAdapter();
            binding.recyclerEventMonth.setAdapter(recyclerAdapter);
            binding.recyclerEventMonth.setLayoutManager(new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.VERTICAL,false));
        }
    }
}
