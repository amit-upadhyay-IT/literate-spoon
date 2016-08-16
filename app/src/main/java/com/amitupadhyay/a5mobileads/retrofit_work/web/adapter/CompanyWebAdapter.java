package com.amitupadhyay.a5mobileads.retrofit_work.web.adapter;

import com.amitupadhyay.a5mobileads.retrofit_work.web.service.CompanyService;

import retrofit.RestAdapter;

/**
 * Created by aupadhyay on 8/14/16.
 */

public class CompanyWebAdapter {

    public CompanyService getCompanyService()
    {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://raw.githubusercontent.com/amit-upadhyay-IT/MyDummyServer/master")
                .build();
        return restAdapter.create(CompanyService.class);
    }

}
