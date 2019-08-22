package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import static com.chameleon.iservev10.GridMenu.ordertype;

public class BusTicket extends AppCompatActivity {
    Spinner busspinner;
    EditText busnameET;
    EditText toET;
    EditText fromET;
    EditText dateET;
    String bus,tobus,frombus,datebus,timebus;
    public static String busticketdetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_ticket);
        busspinner=(Spinner) findViewById(R.id.TimeSP);
        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(BusTicket.this,
                R.layout.spinner_item, getResources().getStringArray(R.array.TimeNames));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        busspinner.setAdapter(myAdapter);
        busnameET=(EditText)findViewById(R.id.BusNameET);
        toET=(EditText)findViewById(R.id.PlaceToET);
        fromET=(EditText)findViewById(R.id.PlaceFromET);
        dateET=(EditText)findViewById(R.id.DateET);
    }
    public void onCommonPageBus(View view){
        bus=busnameET.getText().toString();
        tobus=toET.getText().toString();
        frombus=fromET.getText().toString();
        datebus=dateET.getText().toString();
        timebus=busspinner.getSelectedItem().toString();
        busticketdetail=bus+"*"+frombus+"*"+tobus+"*"+datebus+"*"+timebus;
        ordertype="busticket";
        Intent intent = new Intent(BusTicket.this, Finalise.class);
        startActivity(intent);
    }
}
