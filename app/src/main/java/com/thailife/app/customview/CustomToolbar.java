package com.thailife.app.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thailife.app.R;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class CustomToolbar extends BaseCustomViewGroup {

    public final static int MODE_FIRST = 1;
    public final static int MODE_SECOND = 2;

    public CustomToolbar(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public CustomToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public CustomToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public CustomToolbar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.view_toolbar, this);
    }


    LinearLayout layoutFirst , layoutSecond;
    TextView toolbarText;


    private void initInstances() {
        // findViewById here
        layoutFirst = (LinearLayout)findViewById(R.id.layoutFirst);
        layoutSecond = (LinearLayout)findViewById(R.id.layoutSecond);

        toolbarText = (TextView)findViewById(R.id.textToolbar);

    }

    public void setToolbarMode(int mode) {
        switch (mode) {
            case MODE_FIRST:
                layoutFirst.setVisibility(VISIBLE);
                layoutSecond.setVisibility(INVISIBLE);
                break;

            case MODE_SECOND:
                layoutFirst.setVisibility(INVISIBLE);
                layoutSecond.setVisibility(VISIBLE);
                break;
        }
    }

    public void setToolbarText(String title) {
        toolbarText.setText(title);
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
