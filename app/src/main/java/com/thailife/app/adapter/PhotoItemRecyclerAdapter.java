package com.thailife.app.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thailife.app.databinding.HolderPhotoItemBinding;

/**
 * Created by PromptNow5 on 12/20/2017.
 */

public class PhotoItemRecyclerAdapter extends RecyclerView.Adapter<PhotoItemRecyclerAdapter.PhotoViewHolder> {

    HolderPhotoItemBinding binding;

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = HolderPhotoItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PhotoViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {

        HolderPhotoItemBinding binding;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
