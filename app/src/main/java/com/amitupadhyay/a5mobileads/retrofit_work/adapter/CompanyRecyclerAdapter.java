package com.amitupadhyay.a5mobileads.retrofit_work.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amitupadhyay.a5mobileads.R;
import com.amitupadhyay.a5mobileads.retrofit_work.model.Company;
import com.squareup.picasso.Picasso;

/**
 * Created by aupadhyay on 8/14/16.
 */

public class CompanyRecyclerAdapter extends RecyclerView.Adapter<CompanyRecyclerAdapter.ViewHolder> {

    private final Context context;
    private final Company[] companies;
    private int mCount;

    public CompanyRecyclerAdapter(Context context, Company[] companies) {
        this.context = context;
        this.companies = companies;
        mCount = companies.length;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_company_trending, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(context)
                .load(companies[position].url)
                .fit()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mCount;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.trending_company_image);

        }
    }

}
