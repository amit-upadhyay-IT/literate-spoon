package com.amitupadhyay.a5mobileads.retrofit_work.web.service;

import com.amitupadhyay.a5mobileads.retrofit_work.model.CompaniesCollection;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by aupadhyay on 8/14/16.
 */

public interface CompanyService {

    @GET("/dummyCompanyJson")
    void getCompanyList(Callback<CompaniesCollection> callback);

}
