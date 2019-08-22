package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import static com.chameleon.iservev10.GridMenu.ordertype;

public class laundryCheckbox extends AppCompatActivity {

    public static String laundrydetail;

    ArrayList<String> selection=new ArrayList<String>();
    //TextView textView;
    String laundryOrder="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry_checkbox);
        //textView=(TextView)findViewById(R.id.textView);
    }
    public void selectItem(View view){
        boolean checked=((CheckBox)view).isChecked();
        switch (view.getId()){
            case R.id.ironingCB:
                if(checked){
                    selection.add("ironing");
                }
                else {
                    selection.remove("ironing");
                }
                break;
            case R.id.washCB:
                if(checked){
                    selection.add("wash");
                }
                else {
                    selection.remove("wash");
                }
                break;
            case R.id.drywashCB:
                if(checked){
                    selection.add("drywash");
                }
                else {
                    selection.remove("drywash");
                }
                break;
        }
    }
    // to common page
    public void onCommonPagelaundry(View view){

        for(String selections:selection){
            laundryOrder=laundryOrder+"-"+selections;
        }

        laundrydetail=laundryOrder;
        ordertype="laundry";

        Intent intent = new Intent(laundryCheckbox.this, Finalise.class);
        startActivity(intent);
        //textView.setText(laundryOrder);
    }
}

