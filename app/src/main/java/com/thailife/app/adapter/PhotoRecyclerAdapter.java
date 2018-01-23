package com.thailife.app.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thailife.app.R;
import com.thailife.app.databinding.HolderPhotoBinding;

/**
 * Created by PromptNow5 on 12/20/2017.
 */

public class PhotoRecyclerAdapter extends RecyclerView.Adapter<PhotoRecyclerAdapter.PhotoViewHolder> {

    HolderPhotoBinding binding;

    @Override
    public PhotoRecyclerAdapter.PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.holder_event,parent,false);
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

        HolderPhotoBinding binding;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            PhotoItemRecyclerAdapter recyclerAdapter = new PhotoItemRecyclerAdapter();
            binding.recyclerPhoto.setAdapter(recyclerAdapter);
            binding.recyclerPhoto.setLayoutManager(new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.VERTICAL,false));
        }
    }
}
