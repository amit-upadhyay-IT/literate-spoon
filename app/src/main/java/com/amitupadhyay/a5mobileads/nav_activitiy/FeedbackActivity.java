package com.amitupadhyay.a5mobileads.nav_activitiy;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.amitupadhyay.a5mobileads.R;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {

    private Toolbar feedback_toolbar;

    public void initToolbar()
    {
        feedback_toolbar = (Toolbar) findViewById(R.id.feedback_toolbar);
        feedback_toolbar.setTitle("Feedback");
        feedback_toolbar.setSubtitle("user_name");
        setSupportActionBar(feedback_toolbar);
    }

    private RadioGroup feedback_radio_group;
    private Button feedback_sumbit;
    private EditText feedback_comment;

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        finish();
    }

    public class Feedback
    {
        private int vote;
        private String comment;

        public int getVote() {
            return vote;
        }

        public void setVote(int vote) {
            this.vote = vote;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }
    public void initViews()
    {
        feedback_radio_group = (RadioGroup) findViewById(R.id.feedback_radio_group);
        feedback_sumbit = (Button) findViewById(R.id.feedback_submit);
        feedback_comment = (EditText) findViewById(R.id.feedback_comment);

        feedback_sumbit.setOnClickListener(this);
    }

    AlertDialog.Builder builder;
    AlertDialog dialog;

    public void showAlertDialog()
    {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Feedback Submited Sucessfully !");
        builder.setMessage("Thank you for taking out your time and writing to us.");

        builder.setPositiveButton("OK", this);

        dialog = builder.create();

        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        initToolbar();
        initViews();
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

    @Override
    public void onClick(View view) {

        Feedback obj = new Feedback();

        obj.setComment(feedback_comment.getText().toString().trim()); // setting the comment
        obj.setVote(0);// setting the vote to 0 so that at the end of this method we can check if the user has given feedback or not.

        switch (feedback_radio_group.getCheckedRadioButtonId())
        {
            case R.id.feedback_excellent:
                obj.setVote(5);     // setting the vote
                break;
            case R.id.feedback_very_good:
                obj.setVote(4);
                break;
            case R.id.feedback_good:
                obj.setVote(3);
                break;
            case R.id.feedback_average:
                obj.setVote(2);
                break;
            case R.id.feedback_poor:
                obj.setVote(1);
                break;
        }

        if(obj.getVote() == 0)
        {
            Toast.makeText(this, "Please Give the Rating", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            showAlertDialog();
        }
    }
}
