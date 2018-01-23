package com.thailife.app.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.thailife.app.DeviceActivity;
import com.thailife.app.R;
import com.thailife.app.databinding.FragmentDashboardBinding;

import java.util.Timer;
import java.util.TimerTask;

import pl.pawelkleczkowski.customgauge.CustomGauge;

/**
 * Created by PromptNow5 on 12/7/2017.
 */

public class DashBoardFragment extends Fragment implements View.OnClickListener {
    FragmentDashboardBinding binding;
    MainActivity mainActivity;

    private CustomGauge gauge1, gauge2, gauge3, gauge4;

    private Runnable runnable1 = null;
    private Runnable runnable2 = null;
    private Runnable runnable3 = null;
    private Runnable runnable4 = null;

    int i, gauge1Value, gauge2Value, gauge3Value, gauge4Value,
            gauge1count = 0, gauge2count = 0, gauge3count = 0, gauge4count = 0;

    private TextView text1;
    private TextView textCountStep, textCountCal, textCountKm;

    public static DashBoardFragment newInstance() {

        Bundle args = new Bundle();


        DashBoardFragment fragment = new DashBoardFragment();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false);
        mainActivity = (MainActivity) getActivity();
        mainActivity = (MainActivity) getActivity();
        mainActivity.getBinding().customToolbar.setToolbarText("ThaiLife");

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initInstance();

        drawableGauge();

    }


    private void initInstance() {
        Button button = (Button) binding.getRoot().findViewById(R.id.button);
        Button btnUpDate = (Button) binding.getRoot().findViewById(R.id.btnUpdate);

        gauge1 = (CustomGauge) binding.getRoot().findViewById(R.id.gauge1);
        gauge2 = (CustomGauge) binding.getRoot().findViewById(R.id.gauge2);
        gauge3 = (CustomGauge) binding.getRoot().findViewById(R.id.gauge3);
        gauge4 = (CustomGauge) binding.getRoot().findViewById(R.id.gauge4);

        gauge1Value = 28000;
        gauge1.setEndValue(40000);

        gauge2Value = 18000;
        gauge2.setEndValue(30000);

        gauge3Value = 3000;
        gauge3.setEndValue(6000);

        gauge4Value = 120;
        gauge4.setEndValue(200);

        text1 = (TextView) binding.getRoot().findViewById(R.id.textView1);
        textCountStep = (TextView) binding.getRoot().findViewById(R.id.textCountStep);
        textCountCal = (TextView) binding.getRoot().findViewById(R.id.textCountCal);
        textCountKm = (TextView) binding.getRoot().findViewById(R.id.textCountKm);

        text1.setText(Integer.toString(gauge1.getValue()));
        textCountStep.setText(Integer.toString(gauge2.getValue()));
        textCountCal.setText(Integer.toString(gauge3.getValue()));
        textCountKm.setText(Integer.toString(gauge4.getValue()));

        binding.textMiddlebar.setText("Connect to Device");
        binding.middlebar.setOnClickListener(this);


        btnUpDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gauge1Value = gauge1Value + 400;
                gauge2Value = gauge2Value + 300;
                gauge3Value = gauge3Value + 200;
                gauge4Value = gauge4Value + 2;

                timerCount(gauge1, text1, gauge1Value, 400, runnable1);

//                timerCount(gauge1, text1, gauge1Value, 400, runnable1);
//                new Handler().post(new Runnable() {
//                    @Override
//                    public void run() {
//                        drawGauge(gauge1, text1, gauge1Value, 400, runnable1);
//                    }
//                });
            }
        });
    }

    private void drawableGauge() {
        setValue(gauge1, text1, gauge1Value, 400, runnable1);
        setValue(gauge2, textCountStep, gauge2Value, 300, runnable2);
        setValue(gauge3, textCountCal, gauge3Value, 200, runnable3);
        setValue(gauge4, textCountKm, gauge4Value, 2, runnable4);
    }

    private void timerCount(final CustomGauge gauge, final TextView textView, final int gaugeValue, final int value, final Runnable runnable) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (gauge1count < (gaugeValue / value) && gauge1count < 100) {
                    drawGauge(gauge, textView, gaugeValue, value, runnable);
                }
            }
        }, 100, 2000);
    }

    private void setValue(final CustomGauge gauge, final TextView textView, final int gaugeValue, final int value, final Runnable runnable) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                drawGauge(gauge, textView, gaugeValue, value, runnable);
            }
        });
    }

    private void drawGauge(final CustomGauge gauge, final TextView textView, final int gaugeValue, final int value, final Runnable runnable) {

        switch (value) {
            case 400:
                threadRun(gauge, textView, gaugeValue, value, runnable);
                break;
            case 300:
                threadRun(gauge, textView, gaugeValue, value, runnable);
                break;
            case 200:
                threadRun(gauge, textView, gaugeValue, value, runnable);
                break;
            case 2:
                threadRun(gauge, textView, gaugeValue, value, runnable);
                break;

        }
//                new Thread() {
//                    public void run() {
//                        for (i = gauge1count; i <= (gaugeValue / value); i++) {
//                            try {
//                                mainActivity.runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        gauge.setValue(i);
//                                        textView.setText(Integer.toString((int) (gauge.getValue() * value)));
//                                        gauge1count = gauge1count + 1;
//                                    }
//                                });
//                                Thread.sleep(30);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                                run();
//                            }
//                        }
//                    }
//                }.start();
    }

    private void threadRun(final CustomGauge gauge, final TextView textView, final int gaugeValue, final int value, final Runnable runnable) {
        new Thread(runnable) {
            @Override
            public void run() {
                for (i = gauge1count; i <= (gaugeValue / value); i++) {
                    try {
                        mainActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                gauge.setValue(i);
                                textView.setText(Integer.toString((int) (gauge.getValue() * value)));
                                gauge1count = i;
                            }
                        });
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.middlebar:
                Intent intentmiddle = new Intent(getActivity(), DeviceActivity.class);
                startActivity(intentmiddle);
                break;
        }
    }

}