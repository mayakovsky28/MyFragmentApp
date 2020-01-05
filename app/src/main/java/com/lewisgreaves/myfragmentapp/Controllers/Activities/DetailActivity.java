package com.lewisgreaves.myfragmentapp.Controllers.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.lewisgreaves.myfragmentapp.Controllers.Fragments.DetailFragment;
import com.lewisgreaves.myfragmentapp.R;

/*
 * Created by @Mayakovsky28 on 05 01 2020.
 */
public class DetailActivity extends AppCompatActivity {

    private DetailFragment detailFragment;
    public static final String EXTRA_BUTTON_TAG = "com.lewisgreaves.myfragmentapp.Controllers.Activities.DetailActivity.EXTRA_BUTTON_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.configureAndShowDetailFragment();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.updateDetailFragmentTextViewWithIntentTag();
    }

    private void configureAndShowDetailFragment() {
        detailFragment = (DetailFragment)getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if (detailFragment == null) {
            detailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_detail, detailFragment).commit();
        }
    }

    private void updateDetailFragmentTextViewWithIntentTag() {
        int buttonTag = getIntent().getIntExtra(EXTRA_BUTTON_TAG, 0);
        detailFragment.updateTextView(buttonTag);
    }

}
