package com.example.android.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity  implements View.OnClickListener{

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Employees");
    String surname, username, employeeNum, date, description, signIn, signOff, length, email;
    Button btnRegister;

    EditText tvName, tvSurname, tvEmployeeNumber, tvDescription, tvDate, tvSignIn, tvSignOff, tvLength, tvEmail ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialiseWidgets();


    }

    private void registerNewEmployee(String surname,String username,String employeeNum, String email) {

        Employees employee = new Employees(surname,username, employeeNum,email);

        myRef.child(employeeNum).setValue(employee);
    }

    public void initialiseWidgets(){
        btnRegister = (Button) findViewById(R.id.btn_register);
        tvName = (EditText) findViewById(R.id.username);
        tvSurname = (EditText) findViewById(R.id.surname);
        tvEmail = (EditText) findViewById(R.id.email);
        tvEmployeeNumber = (EditText) findViewById(R.id.employee_number);

        btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        surname = tvSurname.getText().toString();
        username = tvName.getText().toString();
        employeeNum = tvEmployeeNumber.getText().toString();
        email = tvEmail.getText().toString();

        registerNewEmployee(surname, username, employeeNum, email);
    }
}
