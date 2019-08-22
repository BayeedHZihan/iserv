package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.chameleon.iservev10.GridMenu.ordertype;

public class BillPayment extends AppCompatActivity {
    public static String elecdetail,gasdetail,internetdetail,otherdetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_payment);
    }
    public void onCreditcard(View view){
        Intent intent = new Intent(BillPayment.this, BackInfoBill.class);
        startActivity(intent);
    }
    //to common page
    public void onElectricity(View view){
        elecdetail="Electricity Bill";
        ordertype="electricitybill";
        Intent intent = new Intent(BillPayment.this, Finalise.class);
        startActivity(intent);
    }
    public void onGas(View view){
        gasdetail="Gas Bill";
        ordertype="gasbill";
        Intent intent = new Intent(BillPayment.this, Finalise.class);
        startActivity(intent);
    }
    public void onInternet(View view){
        internetdetail="Internet Bill";
        ordertype="internetbill";
        Intent intent = new Intent(BillPayment.this, Finalise.class);
        startActivity(intent);
    }
    public void onOther(View view){
        otherdetail="Other Bill";
        ordertype="otherbill";
        Intent intent = new Intent(BillPayment.this, Finalise.class);
        startActivity(intent);
    }
}