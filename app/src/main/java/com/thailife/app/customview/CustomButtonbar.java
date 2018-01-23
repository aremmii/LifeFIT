package com.thailife.app.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.thailife.app.R;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class CustomButtonbar extends BaseCustomViewGroup {

    public CustomButtonbar(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public interface ButtonbarListener{
        void onHomeTabClick();
        void onEventTabClick();
        void onGiftTabClick();
        void onMoreTabClick();
        void onTestTabClick();
    }

    public CustomButtonbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public CustomButtonbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public CustomButtonbar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.fragment_buttonbar, this);
    }

    TextView tvHome,tvEvent,tvGift,tvMore,tvTest;

    private void initInstances() {
        // findViewById here
        tvHome = (TextView) findViewById(R.id.tvHome);
        tvEvent = (TextView) findViewById(R.id.tvEvent);
        tvGift = (TextView) findViewById(R.id.tvGift);
        tvMore = (TextView) findViewById(R.id.tvMore);
        tvTest = (TextView) findViewById(R.id.tvTest);
    }

    public void setOnButtonBarItemClick(final ButtonbarListener listener) {
        tvHome.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onHomeTabClick();
            }
        });
        tvEvent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEventTabClick();
            }
        });
        tvGift.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onGiftTabClick();
            }
        });
        tvMore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMoreTabClick();
            }
        });
        tvTest.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTestTabClick();
            }
        });
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {

    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }

}
