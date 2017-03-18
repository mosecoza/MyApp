package com.example.android.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Work");
    String surname, username, employeeNum, date, description, signIn, signOff, length, email;
    Button btnLogWork;

    EditText tvName, tvSurname, tvEmployeeNumber, tvDescription, tvDate, tvSignIn,
            tvSignOff, tvLength, tvEmail ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        initialiseWidgets();

    }

    private void LogNewShift(String employeeNum, String date, String description,
                             String signIn, String signOff, String length) {

        Work work = new Work(employeeNum, date, description,signIn, signOff, length);

        myRef.child(employeeNum).setValue(work);
    }

    public void initialiseWidgets(){
        btnLogWork = (Button) findViewById(R.id.btn_log_shift);
        btnLogWork.setOnClickListener(this);

        tvEmployeeNumber = (EditText) findViewById(R.id.reg_emp_num);
        tvDate = (EditText) findViewById(R.id.reg_date);
        tvDescription = (EditText) findViewById(R.id.reg_description);
        tvSignIn = (EditText) findViewById(R.id.regsignin);
        tvSignOff = (EditText) findViewById(R.id.reg_signoff);
        tvLength = (EditText) findViewById(R.id.reg_length);
    }

    @Override
    public void onClick(View view) {

        employeeNum = tvEmployeeNumber.getText().toString();
        date = tvDate.getText().toString();
        description = tvDescription.getText().toString();
        signIn = tvSignIn.getText().toString();
        signOff = tvSignOff.getText().toString();
        length = tvLength.getText().toString();

        LogNewShift(employeeNum, date, description, signIn, signOff, length);
    }
}
