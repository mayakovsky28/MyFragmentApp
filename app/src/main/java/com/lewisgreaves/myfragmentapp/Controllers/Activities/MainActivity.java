package com.lewisgreaves.myfragmentapp.Controllers.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import com.lewisgreaves.myfragmentapp.Controllers.Fragments.DetailFragment;
import com.lewisgreaves.myfragmentapp.Controllers.Fragments.MainFragment;
import com.lewisgreaves.myfragmentapp.R;

public class MainActivity extends AppCompatActivity implements MainFragment.OnButtonClickedListener {

    private MainFragment mainFragment;
    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configureAndShowMainFragment();
        this.configureAndShowDetailFragment();
    }

    private void configureAndShowMainFragment() {
        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);

        if (mainFragment == null) {
            mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_main, mainFragment).commit();
        }
    }


    public void onButtonClicked(View view) {
        if (detailFragment == null || !detailFragment.isVisible()) {
            startActivity(new Intent(this, DetailActivity.class));
        }
    }

    private void configureAndShowDetailFragment(){
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if (detailFragment == null && findViewById(R.id.frame_layout_detail) != null) {
                detailFragment = new DetailFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frame_layout_detail, detailFragment)
                        .commit();
        }
    }
}