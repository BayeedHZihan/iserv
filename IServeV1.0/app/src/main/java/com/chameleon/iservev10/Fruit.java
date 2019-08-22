package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rengwuxian.materialedittext.MaterialEditText;

import static com.chameleon.iservev10.GridMenu.ordertype;

public class Fruit extends AppCompatActivity {

    MaterialEditText edtFruitName, edtFruitAmount;
    public static String fruitdetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        edtFruitName = (MaterialEditText)findViewById(R.id.edtFruitName);
        edtFruitAmount = (MaterialEditText)findViewById(R.id.edtFruitAmount);
    }

    public void onFruit(View view){
        String fruitname=edtFruitName.getText().toString();
        String fruitamount=edtFruitAmount.getText().toString();
        fruitdetail=fruitname+"-"+fruitamount;
        ordertype="fruit";
        Intent intent = new Intent(Fruit.this,Finalise.class);
        startActivity(intent);

    }
}
