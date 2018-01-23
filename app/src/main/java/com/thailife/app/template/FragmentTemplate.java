package com.thailife.app.template;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thailife.app.R;
import com.thailife.app.base.BaseFragment;
import com.thailife.app.databinding.FragmentTemplateBinding;

/**
 * Created by PromptNow on 10/11/2560.
 */

public class FragmentTemplate extends BaseFragment {

    FragmentTemplateBinding binding;

    public static FragmentTemplate newInstance() {

        Bundle args = new Bundle();

        FragmentTemplate fragment = new FragmentTemplate();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_template,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
