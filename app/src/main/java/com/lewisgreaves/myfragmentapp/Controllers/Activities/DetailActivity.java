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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.configureAndShowDetailFragment();
    }

    private void configureAndShowDetailFragment() {
        detailFragment = (DetailFragment)getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if (detailFragment == null) {
            detailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_detail, detailFragment).commit();
        }
    }

}
