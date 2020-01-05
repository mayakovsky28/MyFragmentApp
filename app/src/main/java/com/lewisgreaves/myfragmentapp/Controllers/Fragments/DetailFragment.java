package com.lewisgreaves.myfragmentapp.Controllers.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lewisgreaves.myfragmentapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private TextView textView;
    private int buttonTag;
    private static final String KEY_BUTTON_TAG = "com.lewiegreaves.myfragmentapp.Controllers.Fragments.DetailFragment.KEY_BUTTON_TAG";


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        this.textView = (TextView) view.findViewById(R.id.detail_fragment_text_view);
                return (view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            int buttonTagRestored = savedInstanceState.getInt(KEY_BUTTON_TAG, 0);
            this.updateTextView(buttonTagRestored);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_BUTTON_TAG, buttonTag);
    }

    public void updateTextView(int tag) {
        switch(tag) {
            case 10: this.textView.setText("We're all going on a summer holiday!");
            break;
            case 20: this.textView.setText("Time to go back to work.");
            break;
            case 30: this.textView.setText("Some people just cannot stop trumping!");
            break;
            default: this.textView.setText("Something has gone wrong here!");
            break;
        }
        this.buttonTag = tag;
    }

}
