package com.thailife.app.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.thailife.app.R;
import com.thailife.app.base.BaseActivity;
import com.thailife.app.customview.CustomToolbar;
import com.thailife.app.databinding.ActivityMainBinding;

/**
 * Created by PromptNow on 14/11/2560.
 */

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    public ActivityMainBinding getBinding() {
        return binding;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.customToolbar.setToolbarMode(CustomToolbar.MODE_FIRST);
        binding.customToolbar.setToolbarText("55555");

        getSupportFragmentManager().beginTransaction()
                .add(R.id.contentContainer, MainFragment.newInstance())
                .commit();

//        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
//
    }
}
