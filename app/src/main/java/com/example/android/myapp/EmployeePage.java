package com.example.android.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EmployeePage extends AppCompatActivity implements View.OnClickListener, ValueEventListener {

    private FirebaseAuth firebaseAuth;
//    FirebaseUser user = firebaseAuth.getCurrentUser();

    private String TAG = EmployeePage.class.getSimpleName();

    Button btnAccept, btnDecline, btnSendMessage;

    EditText message;

    String employeeNum,date,description,signOut,signIn,length,username,email,surname;

    TextView tvEmpNum, tvDate, tvDescription, tvSignoff, tvSignIn,
            tvLength, tvUsername, tvEmail, tvSurname;

    // Write a get employee from database to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mRef = database.getReference();
//    DatabaseReference workRef = database.getReference("Work");

    Employees employees = new Employees();
    Work work = new Work();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            email = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        if(email == "man@mail.com"){
            employeeNum ="G654Q1";
        }
        else if(email=="female@mail.com"){
            employeeNum="TRANS12";
        } else if(email=="other@mail.com"){
            employeeNum="TRANS13";
        }
        else {
            employeeNum="TRANS14";
        }

if(employeeNum!=null){
            mRef.addValueEventListener(this);
}




    }

    public void initialiseWidgets(){
        btnAccept = (Button) findViewById(R.id.btn_accept);
        btnDecline = (Button) findViewById(R.id.btn_decline);
        btnSendMessage = (Button) findViewById(R.id.btn_send);

        btnAccept.setOnClickListener(this);
        btnDecline.setOnClickListener(this);
        btnSendMessage.setOnClickListener(this);

        message = (EditText) findViewById(R.id.show_decline_mesage);

        tvEmpNum = (TextView) findViewById(R.id.show_emp_num);
        tvDate = (TextView) findViewById(R.id.show_date);
        tvDescription = (TextView) findViewById(R.id.show_description);
        tvSignIn = (TextView) findViewById(R.id.show_sign_on);
        tvSignoff = (TextView) findViewById(R.id.show_sign_off);
        tvLength = (TextView) findViewById(R.id.show_length);
        tvUsername = (TextView) findViewById(R.id.show_username);
         tvSurname= (TextView) findViewById(R.id.show_surname);
        tvEmail = (TextView) findViewById(R.id.show_email);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_accept:

                break;

            case R.id.btn_decline:
                message.setVisibility(View.VISIBLE);
                btnSendMessage.setVisibility(View.VISIBLE);
                break;

            case R.id.btn_send:

                break;
        }

    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
//System.out.println("============================================================="+employeeNum);
        employees = dataSnapshot.child("Employees").child(employeeNum).getValue(Employees.class);
        work = dataSnapshot.child("Work").child(employeeNum).getValue(Work.class);

        setContentView(R.layout.activity_employee_page);
        initialiseWidgets();

        tvSurname.setText(employees.surname);
        tvUsername.setText(employees.username);
        tvEmail.setText(email);
        tvEmpNum.setText(employeeNum);
        tvDescription.setText(work.description);
        tvSignIn.setText(work.signIn);
        tvSignoff.setText(work.signOut);
        tvLength.setText(work.length);
        tvDate.setText(work.date);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
    }
}
