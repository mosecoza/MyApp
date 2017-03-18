package com.example.android.myapp;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Admin on 2017/02/22.
 */
@IgnoreExtraProperties
public class Work {
    public String employeeNum;
    public String date;
    public String description;
    public String signOut;
    public String signIn;
    public String length;

    public Work() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Work(String employeeNum, String date, String description,
                String signIn, String signOut, String length) {
        this.employeeNum = employeeNum;
        this.date = date;
        this.description = description;
        this.signIn = signIn;
        this.signOut = signOut;
        this.length = length;
    }
}

