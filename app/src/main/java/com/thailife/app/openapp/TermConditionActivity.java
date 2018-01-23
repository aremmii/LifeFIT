package com.thailife.app.openapp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.thailife.app.R;
import com.thailife.app.base.BaseActivity;
import com.thailife.app.databinding.ActivityTermConditionBinding;
import com.thailife.app.login.LoginActivity;

public class TermConditionActivity extends BaseActivity implements View.OnClickListener {

    ActivityTermConditionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_term_condition);
        binding = DataBindingUtil.setContentView(TermConditionActivity.this, R.layout.activity_term_condition);

        bindView();
    }

    private void bindView() {
        setButtonEnable(binding.btnOk,false);
        binding.checkBox.setOnClickListener(this);
        binding.btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.checkBox:
                if (binding.checkBox.isChecked()) {
                    setButtonEnable(binding.btnOk,true);
                } else {
                    setButtonEnable(binding.btnOk,false);
                }
                break;

            case R.id.btnOk:
                Intent intent = new Intent(TermConditionActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;

        }
    }
}
