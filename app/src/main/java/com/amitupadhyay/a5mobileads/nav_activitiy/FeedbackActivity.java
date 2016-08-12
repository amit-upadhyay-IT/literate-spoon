package com.amitupadhyay.a5mobileads.nav_activitiy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.amitupadhyay.a5mobileads.R;

public class FeedbackActivity extends AppCompatActivity {

    private Toolbar feedback_toolbar;

    public void initToolbar()
    {
        feedback_toolbar = (Toolbar) findViewById(R.id.feedback_toolbar);
        feedback_toolbar.setTitle("Feedback");
        feedback_toolbar.setSubtitle("user_name");
        setSupportActionBar(feedback_toolbar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        initToolbar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.feedback_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.feedback_close) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
