package com.example.happynewyear3;

import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.app.Fragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Text2Fragment extends Fragment {

    @Override
    // Переопределяем метод onCreateView
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text2_fragment, container, false);
        return view;
    }
}
