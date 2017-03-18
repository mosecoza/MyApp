package com.example.android.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button btnAdd, btnLog, btnPage;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnAdd = (Button) findViewById(R.id.btn_choose_add);
        btnLog = (Button) findViewById(R.id.btn_choose_log_work);
        btnPage = (Button) findViewById(R.id.btn_choose_page);

        btnAdd.setOnClickListener(this);
        btnLog.setOnClickListener(this);
        btnPage.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn_choose_add:
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                break;

            case R.id.btn_choose_log_work:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;

            case R.id.btn_choose_page:
                startActivity(new Intent(getApplicationContext(), EmployeePage.class));
                break;
        }
    }
}
