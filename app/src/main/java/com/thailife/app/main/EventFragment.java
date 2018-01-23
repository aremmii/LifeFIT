package com.thailife.app.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thailife.app.R;
import com.thailife.app.adapter.EventRecyclerAdapter;
import com.thailife.app.databinding.FragmentEventBinding;

/**
 * Created by PromptNow on 10/11/2560.
 */

public class EventFragment extends Fragment implements View.OnClickListener {

    FragmentEventBinding binding;
    MainActivity mainActivity;
    EventRecyclerAdapter recyclerAdapter;

    public static EventFragment newInstance() {

        Bundle args = new Bundle();

        EventFragment fragment = new EventFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_event,container,false);
        mainActivity = (MainActivity) getActivity();
        mainActivity.getBinding().customToolbar.setToolbarText("Activity");

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInstance();

    }

    private void initInstance() {
        recyclerAdapter = new EventRecyclerAdapter();
        binding.recyclerEvent.setAdapter(recyclerAdapter);
        binding.recyclerEvent.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}
