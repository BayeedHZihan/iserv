package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rengwuxian.materialedittext.MaterialEditText;

import static com.chameleon.iservev10.GridMenu.ordertype;

public class Delivery extends AppCompatActivity {

    MaterialEditText edtDest;
    public static String deliverydetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        edtDest = (MaterialEditText)findViewById(R.id.edtDestination);
    }

    public void onDelivery(View view){
        String destination = edtDest.getText().toString();
        deliverydetail=destination;
        ordertype="delivery";
        Intent intent = new Intent(Delivery.this, Finalise.class);
        startActivity(intent);

    }
}
