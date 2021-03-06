package com.lewisgreaves.myfragmentapp.Controllers.Fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lewisgreaves.myfragmentapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {


    public MainFragment() {
        // Required empty public constructor
    }

    private OnButtonClickedListener mCallback;

    public interface OnButtonClickedListener {
        void onButtonClicked (View view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result =  inflater.inflate(R.layout.fragment_main, container, false);
        result.findViewById(R.id.fragment_main_button).setOnClickListener(this);
        result.findViewById(R.id.fragment_main_button_happy).setOnClickListener(this);
        result.findViewById(R.id.fragment_main_button_sad).setOnClickListener(this);
        result.findViewById(R.id.fragment_main_button_horrible).setOnClickListener(this);
        return result;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // 4 - Call the method that creating callback after being attached to parent activity
        this.createCallbackToParentActivity();
    }

    @Override
    public void onClick(View v) {
        mCallback.onButtonClicked(v);
    }

    private void createCallbackToParentActivity(){
        try {
            //Parent activity will automatically subscribe to callback
            mCallback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString() + " must implement onButtonClickedListener");
        }
    }

}
