package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.chameleon.iservev10.GridMenu.ordertype;

public class BackInfoBill extends AppCompatActivity {
    EditText banknameET;
    EditText cardnumberET;
    String bank,card;
    public static String creditcarddetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_info_bill);
        banknameET=(EditText)findViewById(R.id.banknameET);
        cardnumberET=(EditText)findViewById(R.id.cardnumberET);
    }
    public void onCommonPagebank(View view){
        bank=banknameET.getText().toString();
        card=cardnumberET.getText().toString();
        creditcarddetail=bank+"-"+card;
        ordertype= "creditcardorder";
        Intent intent = new Intent(BackInfoBill.this, Finalise.class);
        startActivity(intent);
    }
}
