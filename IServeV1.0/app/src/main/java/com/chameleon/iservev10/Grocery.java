package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.chameleon.iservev10.GridMenu.ordertype;

public class Grocery extends AppCompatActivity {
    EditText groceryET;
    String groceryname;
    public static String grocerydetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);
        groceryET=(EditText)findViewById(R.id.GroceryNameET);
    }
    public void onCommonPageGrocery(View view){
        groceryname=groceryET.getText().toString();
        grocerydetail=groceryname;
        ordertype="grocery";
        Intent intent = new Intent(Grocery.this, Finalise.class);
        startActivity(intent);
    }
}
