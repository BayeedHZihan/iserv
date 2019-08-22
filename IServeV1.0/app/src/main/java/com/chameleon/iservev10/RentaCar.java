package com.chameleon.iservev10;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import static com.chameleon.iservev10.GridMenu.ordertype;

public class RentaCar extends AppCompatActivity {
    Spinner rentacarspinner;
    EditText torentacarET;
    EditText fromrentacarET;
    EditText daterentacarET;
    String torentacar,fromrentacar,daterentacar,rentacarname;
    public static String rentacardetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renta_car);
       rentacarspinner=(Spinner) findViewById(R.id.CarSP);
      ArrayAdapter<String> myRentAdapter=new ArrayAdapter<String>(RentaCar.this,
                R.layout.spinner_item, getResources().getStringArray(R.array.CarNames));
        myRentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rentacarspinner.setAdapter(myRentAdapter);
       torentacarET=(EditText)findViewById(R.id.RentaCarPlaceToET);
       fromrentacarET=(EditText)findViewById(R.id.RentaCarPlaceFromET);
        daterentacarET=(EditText)findViewById(R.id.RentaCarDateET);

    }
    public void onCommonPageRentaCar(View view){
        torentacar=torentacarET.getText().toString();
        fromrentacar=fromrentacarET.getText().toString();
        daterentacar=daterentacarET.getText().toString();
        rentacarname=rentacarspinner.getSelectedItem().toString();
        rentacardetail=fromrentacar+"*"+torentacar+"*"+daterentacar+"*"+rentacarname;
        ordertype="rentacar";
        Intent intent = new Intent(RentaCar.this, Finalise.class);
        startActivity(intent);
    }
}
