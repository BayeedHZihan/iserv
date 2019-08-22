package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderCheck extends AppCompatActivity {
    TextView recheckTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_check);
        recheckTV =(TextView) findViewById(R.id.recheckTV);
        Button btnCheck = (Button) findViewById(R.id.btnConfirmCheck);



    }

    public void onRecheck(View view){
        Intent intent = new Intent(OrderCheck.this,GridMenu.class);
        startActivity(intent);

    }
}
