package com.amitupadhyay.a5mobileads.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.amitupadhyay.a5mobileads.R;
import com.amitupadhyay.a5mobileads.retrofit_work.adapter.CompanyRecyclerAdapter;
import com.amitupadhyay.a5mobileads.retrofit_work.model.CompaniesCollection;
import com.amitupadhyay.a5mobileads.retrofit_work.web.adapter.CompanyWebAdapter;
import com.amitupadhyay.a5mobileads.retrofit_work.web.service.CompanyService;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendingFragment extends Fragment {


    private RecyclerView recyclerView;
    private CompanyRecyclerAdapter adapter;

    private boolean flag = false;

    public TrendingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending, container, false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initPullRefresh(view);// this will refresh the data on the pull.
        if(!flag) {
            initFetchData(view); // this will display the fetched data even without any pull
            flag = true;
        }

    }


    public void initPullRefresh(final View view)
    {
        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.content_mainSwipe);
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.GRAY);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                swipeRefreshLayout.setRefreshing(true);

                swipeRefreshLayout.setRefreshing(false);

                initFetchData(view);

            }
        });
    }



    public void initFetchData(View view)
    {
        recyclerView = (RecyclerView) view.findViewById(R.id.companyList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(gridLayoutManager);

        CompanyService companyService = new CompanyWebAdapter().getCompanyService();

        companyService.getCompanyList(new Callback<CompaniesCollection>() {
            @Override
            public void success(CompaniesCollection companiesCollection, Response response) {
                adapter = new CompanyRecyclerAdapter(getActivity(), companiesCollection.companies);

                recyclerView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {

                Toast.makeText(getActivity(), ""+error, Toast.LENGTH_LONG).show();

            }
        });
    }

}
