package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class Region extends AppCompatActivity {
    TextView regionTV;
    Spinner myspinner;

    public static String regionorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);
        myspinner=(Spinner) findViewById(R.id.regionSP);
        regionTV=(TextView) findViewById(R.id.regionTV);
        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(Region.this,
                R.layout.spinner_item, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);



    }
    public void onMenu(View view){
        String region = myspinner.getSelectedItem().toString();
        regionorder=region;
        //Toast.makeText(getApplicationContext(), regionorder, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Region.this, GridMenu.class);
        startActivity(intent);
        //regionTV.setText(text);
    }


    public void onBackPressed()
    {
        //do whatever you want the 'Back' button to do
        //as an example the 'Back' button is set to start a new Activity named 'NewActivity'

        //new BackgroundTask(this).execute(method,"Paanshi");


        Intent intent = new Intent(Region.this, ItemListScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);



        return;
    }
}

