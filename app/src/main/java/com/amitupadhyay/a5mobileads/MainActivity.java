package com.amitupadhyay.a5mobileads;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.amitupadhyay.a5mobileads.fragments.EducationFragment;
import com.amitupadhyay.a5mobileads.fragments.EntertainmentFragment;
import com.amitupadhyay.a5mobileads.fragments.HomeFragment;
import com.amitupadhyay.a5mobileads.fragments.MediaFragment;
import com.amitupadhyay.a5mobileads.fragments.RealEstateFragment;
import com.amitupadhyay.a5mobileads.fragments.TrendingFragment;
import com.amitupadhyay.a5mobileads.myadapters.ViewPagerAdapter;
import com.amitupadhyay.a5mobileads.nav_activitiy.FeedbackActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, DialogInterface.OnClickListener {

    AlertDialog.Builder builder;
    AlertDialog dialog;

    public void showAlertDialog()
    {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Please Confirm !");
        builder.setMessage("Do you want to exit?");

        builder.setPositiveButton("YES", this);
        builder.setNegativeButton("NO", this);

        dialog = builder.create();

        dialog.show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i)
        {
            case DialogInterface.BUTTON_POSITIVE:
                finish();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                if (dialog.isShowing())
                    dialog.dismiss();
                break;
        }
    }

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    public void initTabLayout()
    {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragments(new HomeFragment(), "Home");
        viewPagerAdapter.addFragments(new TrendingFragment(), "Trending");
        viewPagerAdapter.addFragments(new MediaFragment(), "Media");
        viewPagerAdapter.addFragments(new EntertainmentFragment(), "Entertainment");
        viewPagerAdapter.addFragments(new RealEstateFragment(), "Real Estates");
        viewPagerAdapter.addFragments(new EducationFragment(), "Education");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initTabLayout();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            showAlertDialog();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }
        else if (id == R.id.call_admin)
        {
            String posted_by = "7769942159";
            String uri = "tel:" + posted_by.trim() ;
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(uri));
            startActivity(intent);
            overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );// this will Open the Activity from Bottom to Up.
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home_id)
        {

        }
        else if (id == R.id.profile_id)
        {

        }
        else if (id == R.id.cart_id)
        {

        }
        else if (id == R.id.feedback_id)
        {
            startActivity(new Intent(MainActivity.this, FeedbackActivity.class));
        }
        else if (id == R.id.notifications_id)
        {

        }
        else if (id == R.id.share_id)
        {

        }
        else if (id == R.id.nav_trending_tab)
        {
            viewPager.setCurrentItem(1);
        }
        else if (id == R.id.nav_media_tab)
        {
            viewPager.setCurrentItem(2);
        }
        else if (id == R.id.nav_entertainment_tab)
        {
            viewPager.setCurrentItem(3);
        }
        else if (id == R.id.nav_realestate_tab)
        {
            viewPager.setCurrentItem(4);
        }
        else if (id == R.id.nav_education_tab)
        {
            viewPager.setCurrentItem(5);
        }
        else if (id == R.id.nav_share_app)
        {

        }
        else if (id == R.id.nav_loyalty_points)
        {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
