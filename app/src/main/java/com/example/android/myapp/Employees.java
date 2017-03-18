package com.example.android.myapp;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Admin on 2017/02/22.
 */
@IgnoreExtraProperties
public class Employees {
    public String employeeNum;
    public String username;
    public String email;
    public String surname;

    public Employees() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Employees(String surname, String username, String employeeNum,
                   String email) {
        this.employeeNum = employeeNum;
        this.surname = surname;
        this.username = username;
        this.email = email;
    }
}
