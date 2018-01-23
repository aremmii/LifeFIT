package com.thailife.app.openapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.thailife.app.main.MainActivity;
import com.thailife.app.R;
import com.thailife.app.SharedPref;
import com.thailife.app.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    Handler handler;
    Runnable runnable;
    long delay_time;
    long time = 3000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (SharedPref.getIsLogin(SplashActivity.this)) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, TermConditionActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 3000);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        delay_time = time;
//        handler.postDelayed(runnable, delay_time);
//        time = System.currentTimeMillis();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        handler.removeCallbacks(runnable);
//        time = delay_time - (System.currentTimeMillis() - time);
    }
}
