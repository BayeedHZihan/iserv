package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import static com.chameleon.iservev10.GridMenu.ordertype;

public class ManualOrder extends AppCompatActivity {

    public static String manualpackage;

    EditText edtManual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_order);
        edtManual = (MaterialEditText) findViewById(R.id.edtManualOrder);




    }

    public void onManual(View view){

        manualpackage= edtManual.getText().toString();

        ordertype="ManualFood";
       // Toast.makeText(getApplicationContext(),"You selected Cart", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ManualOrder.this,Finalise.class);
        startActivity(intent);


    }
}
