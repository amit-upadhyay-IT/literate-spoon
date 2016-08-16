package com.amitupadhyay.a5mobileads.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amitupadhyay.a5mobileads.R;
import com.amitupadhyay.a5mobileads.myadapters.MySliderAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    MySliderAdapter adapter;
    ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MySliderAdapter adapter;
        ViewPager viewPager;

        viewPager = (ViewPager) view.findViewById(R.id.fragment_home_view_pager);
        adapter = new MySliderAdapter(getActivity());
        viewPager.setAdapter(adapter);

    }
}
