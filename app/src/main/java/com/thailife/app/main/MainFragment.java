package com.thailife.app.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thailife.app.R;
import com.thailife.app.camera.PhotoActivity;
import com.thailife.app.customview.CustomButtonbar;
import com.thailife.app.databinding.FragmentMainBinding;

public class MainFragment extends Fragment implements View.OnClickListener {

    FragmentMainBinding binding;
    MainActivity mainActivity;

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initInstance();

        getChildFragmentManager().beginTransaction()
                .add(R.id.dashboard, DashBoardFragment.newInstance())
                .commit();

        binding.buttonbar.setOnButtonBarItemClick(new CustomButtonbar.ButtonbarListener() {
            @Override
            public void onHomeTabClick() {
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.dashboard, DashBoardFragment.newInstance())
                        .commit();
            }

            @Override
            public void onEventTabClick() {
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.dashboard, EventFragment.newInstance())
                        .commit();
            }

            @Override
            public void onGiftTabClick() {

            }

            @Override
            public void onMoreTabClick() {

            }

            @Override
            public void onTestTabClick() {
                Intent intent = new Intent(getActivity(), PhotoActivity.class);
                startActivity(intent);
            }
        });

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