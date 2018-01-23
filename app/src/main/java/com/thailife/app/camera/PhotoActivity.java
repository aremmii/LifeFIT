package com.thailife.app.camera;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.features.ImagePickerConfigFactory;
import com.esafirm.imagepicker.features.camera.CameraModule;
import com.esafirm.imagepicker.features.camera.DefaultCameraModule;
import com.esafirm.imagepicker.features.camera.OnImageReadyListener;
import com.esafirm.imagepicker.model.Image;
import com.esafirm.rximagepicker.RxImagePicker;
import com.thailife.app.R;
import com.thailife.app.base.BaseActivity;
import com.thailife.app.databinding.ActivityPhotoBinding;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;


public class PhotoActivity extends BaseActivity {

    ActivityPhotoBinding binding;

    private static int NUM_PAGES = 0;
    private PagerAdapter mPagerAdapter;

    public ActivityPhotoBinding getBinding() {
        return binding;
    }

    private static final int RC_CODE_PICKER = 2000;
    private static final int RC_CAMERA = 3000;


    private ImageView imageView11, imageView21, imageView22, imageView31, imageView32, imageView33, imageView41, imageView42, imageView43, imageView44;
    private LinearLayout image1, image2, image3, image4;
    private TextView textView, imageCount;
    private int count;
    public ArrayList<Image> images = new ArrayList<>();
    private ArrayList<Image> cameraimages = new ArrayList<>();
    private CameraModule cameraModule;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_photo);

        viewPager = (ViewPager) findViewById(R.id.pager);

        imageCount = (TextView) findViewById(R.id.imageCount);
        textView = (TextView) findViewById(R.id.text_view);
        imageView11 = (ImageView) findViewById(R.id.image1photo1);
        imageView21 = (ImageView) findViewById(R.id.image2photo1);
        imageView22 = (ImageView) findViewById(R.id.image2photo2);
        imageView31 = (ImageView) findViewById(R.id.image3photo1);
        imageView32 = (ImageView) findViewById(R.id.image3photo2);
        imageView33 = (ImageView) findViewById(R.id.image3photo3);
        imageView41 = (ImageView) findViewById(R.id.image4photo1);
        imageView42 = (ImageView) findViewById(R.id.image4photo2);
        imageView43 = (ImageView) findViewById(R.id.image4photo3);
        imageView44 = (ImageView) findViewById(R.id.image4photo4);

        image1 = (LinearLayout) findViewById(R.id.image1);
        image2 = (LinearLayout) findViewById(R.id.image2);
        image3 = (LinearLayout) findViewById(R.id.image3);
        image4 = (LinearLayout) findViewById(R.id.image4);

        findViewById(R.id.button_pick_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
            }
        });

        findViewById(R.id.button_camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Activity activity = PhotoActivity.this;
                final String[] permissions = new String[]{Manifest.permission.CAMERA};
                if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(activity, permissions, RC_CAMERA);
                } else {
                    captureImage();
                }
            }
        });

        findViewById(R.id.layoutphotoview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setVisibility(View.VISIBLE);

                viewPager.setAdapter(mPagerAdapter);
                mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
                viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
                viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When changing pages, reset the action bar actions since they are dependent
                        // on which page is currently active. An alternative approach is to have each
                        // fragment expose actions itself (rather than the activity exposing actions),
                        // but for simplicity, the activity provides the actions in this sample.
                        invalidateOptionsMenu();
                    }
                });


            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == RC_CAMERA) {
            if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                captureImage();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void captureImage() {
        startActivityForResult(
                getCameraModule().getCameraIntent(this, ImagePickerConfigFactory.createDefault()), RC_CAMERA);
    }

    private CameraModule getCameraModule() {
        if (cameraModule == null) {
            cameraModule = new DefaultCameraModule();
        }
        return cameraModule;
    }

    Action1<List<Image>> action = new Action1<List<Image>>() {
        @Override
        public void call(List<Image> images) {
            printImages(images);
        }
    };

    private Observable<List<Image>> getImagePickerObservable() {
        return RxImagePicker.getInstance()
                .start(this, ImagePicker.create(this));
    }

    private void startWithIntent() {
        startActivityForResult(ImagePicker.create(this)
                .multi()
                .returnAfterFirst(false)
                .getIntent(this), RC_CODE_PICKER);
    }

    public void start() {
        final boolean returnAfterCapture = ((Switch) findViewById(R.id.ef_switch_return_after_capture)).isChecked();
        final boolean isSingleMode = ((Switch) findViewById(R.id.ef_switch_single)).isChecked();
        final boolean useCustomImageLoader = ((Switch) findViewById(R.id.ef_switch_imageloader)).isChecked();
        final boolean folderMode = ((Switch) findViewById(R.id.ef_switch_folder_mode)).isChecked();

        ImagePicker imagePicker = ImagePicker.create(this)
                .theme(R.style.ImagePickerTheme)
                .returnAfterFirst(false) // set whether pick action or camera action should return immediate result or not. Only works in single mode for image picker
                .folderMode(false) // set folder mode (false by default)
                .folderTitle("Folder") // folder selection title
                .imageTitle("Tap to select"); // image selection title

        if (useCustomImageLoader) {
            imagePicker.imageLoader(new GrayscaleImageLoader());
        }

        if (isSingleMode) {
            imagePicker.single();
        } else {
            imagePicker.multi(); // multi mode (default mode)
        }
        imagePicker.limit(10) // max images can be selected (99 by default)
                .showCamera(true) // show camera or not (true by default)
                .imageDirectory("Camera")   // captured image directory name ("Camera" folder by default)
                .imageFullDirectory(Environment.getExternalStorageDirectory().getPath()) // can be full path
                .origin(images) // original selected images, used in multi mode
                .start(RC_CODE_PICKER); // start image picker activity with request code
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        if (requestCode == RC_CODE_PICKER && resultCode == RESULT_OK && data != null) {
            images = (ArrayList<Image>) ImagePicker.getImages(data);
            printImages(images);
            return;
        }

        if (requestCode == RC_CAMERA && resultCode == RESULT_OK && data != null) {
            getCameraModule().getImage(PhotoActivity.this, data, new OnImageReadyListener() {
                @Override
                public void onImageReady(List<Image> resultImages) {
                    cameraimages = (ArrayList<Image>) resultImages;
                    images.addAll(cameraimages);
                    start();
                }
            });
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void printImages(List<Image> pimages) {
        if (images == null) return;

        NUM_PAGES = images.size();

        count = images.size();

        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0, l = images.size(); i < l; i++) {
            stringBuffer.append(images.get(i).getPath()).append("\n");
        }
        textView.setText(stringBuffer.toString());

        if (count == 1) {
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.GONE);
            image3.setVisibility(View.GONE);
            image4.setVisibility(View.GONE);
            imageView11.setImageBitmap(BitmapFactory.decodeFile(images.get(0).getPath()));
        } else if (count == 2) {
            image1.setVisibility(View.GONE);
            image2.setVisibility(View.VISIBLE);
            image3.setVisibility(View.GONE);
            image4.setVisibility(View.GONE);
            imageView21.setImageBitmap(BitmapFactory.decodeFile(images.get(0).getPath()));
            imageView22.setImageBitmap(BitmapFactory.decodeFile(images.get(1).getPath()));
        } else if (count == 3) {
            image1.setVisibility(View.GONE);
            image2.setVisibility(View.GONE);
            image3.setVisibility(View.VISIBLE);
            image4.setVisibility(View.GONE);
            imageView31.setImageBitmap(BitmapFactory.decodeFile(images.get(0).getPath()));
            imageView32.setImageBitmap(BitmapFactory.decodeFile(images.get(1).getPath()));
            imageView33.setImageBitmap(BitmapFactory.decodeFile(images.get(2).getPath()));
        } else if (count == 4) {
            image1.setVisibility(View.GONE);
            image2.setVisibility(View.GONE);
            image3.setVisibility(View.GONE);
            image4.setVisibility(View.VISIBLE);
            imageView41.setImageBitmap(BitmapFactory.decodeFile(images.get(0).getPath()));
            imageView42.setImageBitmap(BitmapFactory.decodeFile(images.get(1).getPath()));
            imageView43.setImageBitmap(BitmapFactory.decodeFile(images.get(2).getPath()));
            imageView44.setImageBitmap(BitmapFactory.decodeFile(images.get(3).getPath()));
        } else if (count >= 5) {
            image1.setVisibility(View.GONE);
            image2.setVisibility(View.GONE);
            image3.setVisibility(View.GONE);
            image4.setVisibility(View.VISIBLE);
            imageView41.setImageBitmap(BitmapFactory.decodeFile(images.get(0).getPath()));
            imageView42.setImageBitmap(BitmapFactory.decodeFile(images.get(1).getPath()));
            imageView43.setImageBitmap(BitmapFactory.decodeFile(images.get(2).getPath()));
            imageView44.setImageBitmap(BitmapFactory.decodeFile(images.get(3).getPath()));

            imageCount.setVisibility(View.VISIBLE);

            imageCount.setText(" + " + (count - 4));
        }

    }

    /**
     * A simple pager adapter that represents 5 {@link ScreenSlidePageFragment} objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.create(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
