package com.thailife.app.device;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thailife.app.DeviceActivity;
import com.thailife.app.R;
import com.thailife.app.base.BaseFragment;
import com.thailife.app.databinding.FragmentDeviceBinding;

public class DeviceFragment extends BaseFragment implements View.OnClickListener {

    FragmentDeviceBinding binding;
    DeviceActivity deviceActivity;

    public static DeviceFragment newInstance() {

        Bundle args = new Bundle();

        DeviceFragment fragment = new DeviceFragment();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_device, container, false);
        deviceActivity = (DeviceActivity) getActivity();
        deviceActivity.getBinding().customToolbar.setToolbarText("Device");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initInstance();

    }

    private void initInstance() {

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