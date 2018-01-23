package com.thailife.app;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.thailife.app.base.BaseActivity;
import com.thailife.app.databinding.ActivityConditionBinding;

public class MainCondition extends BaseActivity implements View.OnClickListener {
    ActivityConditionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_condition);
        binding = DataBindingUtil.setContentView(MainCondition.this, R.layout.activity_condition);

        bindView();
    }


    private void bindView() {
        binding.btnConOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnConOk:
                finish();
        }
    }
}
