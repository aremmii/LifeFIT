package com.thailife.app.camera;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thailife.app.R;
import com.thailife.app.databinding.FragmentScreenSlidePageBinding;

/**
 * Created by PromptNow5 on 12/22/2017.
 */

public class ScreenSlidePageFragment extends Fragment {

    public static final String ARG_PAGE = "page";

    FragmentScreenSlidePageBinding binding;

    private int mPageNumber;

    PhotoActivity photoActivity;

    private ImageView photoshow;

    public static ScreenSlidePageFragment create(int pageNumber) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ScreenSlidePageFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        photoActivity = (PhotoActivity) getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_screen_slide_page, container, false);

        ((TextView) rootView.findViewById(R.id.tvTitle)).setText(
                getString(R.string.title_template_step, mPageNumber + 1));

        ((ImageView) rootView.findViewById(R.id.showphoto)).setImageBitmap(BitmapFactory.decodeFile
                (photoActivity.images.get(0).getPath()));


        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}
