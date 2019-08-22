package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LaundryPrice extends AppCompatActivity {

    TextView laundryTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry_price);
        laundryTV=(TextView)findViewById(R.id.laundryTV);

    }
    public void onLaundrycheckbox(View view){
        Intent intent = new Intent(LaundryPrice.this, laundryCheckbox.class);
        startActivity(intent);
    }
}