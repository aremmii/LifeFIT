package com.thailife.app;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.thailife.app.device.DeviceFragment;
import com.thailife.app.base.BaseActivity;
import com.thailife.app.customview.CustomToolbar;
import com.thailife.app.databinding.ActivityDeviceBinding;

/**
 * Created by PromptNow5 on 12/6/2017.
 */

public class DeviceActivity extends BaseActivity {

    ActivityDeviceBinding binding;

    public ActivityDeviceBinding getBinding() {
        return binding;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(DeviceActivity.this, R.layout.activity_device);

        binding.customToolbar.setToolbarMode(CustomToolbar.MODE_FIRST);
        binding.customToolbar.setToolbarText("55555");

        getSupportFragmentManager().beginTransaction()
                .add(R.id.contentContainer, DeviceFragment.newInstance())
                .commit();


    }
}
