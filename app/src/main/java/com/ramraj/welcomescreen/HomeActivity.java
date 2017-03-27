package com.ramraj.welcomescreen;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.ramraj.welcomescreen.util.SharedPreferenceInfoUtil;

public class HomeActivity extends CoreActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void bindViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        button = (Button) findViewById(R.id.button1);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void setListeners() {
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferenceInfoUtil.addFirstTimeUser(getContext(), false);
        Toast.makeText(getContext(), "Please restart the app", Toast.LENGTH_LONG).show();
    }
}
