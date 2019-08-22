package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.chameleon.iservev10.GridMenu.ordertype;

public class Doctor extends AppCompatActivity {
    EditText doctornameET,patientnameET,ageET,doctordateET;
    public static String doctorname,patientname,age,doctordate;
    public static String doctordetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        doctornameET=(EditText)findViewById(R.id.DoctorNameET);
        patientnameET=(EditText)findViewById(R.id.PatientNameET);
        ageET=(EditText)findViewById(R.id.AgeET);
        doctordateET=(EditText)findViewById(R.id.DoctorDateET);
    }
    public void onCommonPageDoctor(View view){
        doctorname=doctornameET.getText().toString();
        patientname=patientnameET.getText().toString();
        age=ageET.getText().toString();
        doctordate=doctordateET.getText().toString();
        ordertype="doctor";
        doctordetail=doctorname+"*"+patientname+"*"+age+"*"+doctordate;

        Intent intent = new Intent(Doctor.this, Finalise.class);
        startActivity(intent);
    }


}
