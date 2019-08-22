package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.chameleon.iservev10.GridMenu.ordertype;

public class Medicine extends AppCompatActivity {
    EditText medicineET;
    String medicinename;
    public static String medicinedetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        medicineET=(EditText)findViewById(R.id.MedicineNameET);
    }
    public void onCommonPageMedicine(View view){
        medicinename=medicineET.getText().toString();
        medicinedetail=medicinename;
        ordertype="medicine";
        Intent intent = new Intent(Medicine.this, Finalise.class);
        startActivity(intent);
    }
}
