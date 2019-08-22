package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.chameleon.iservev10.GridMenu.itemListCore;
import static com.chameleon.iservev10.GridMenu.ordertype;
import static com.chameleon.iservev10.Rest.ResName;

public class CartListFinal extends AppCompatActivity {

    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;
    EditText itemText;
    Button addButton;
    ListView lv;
    int len;
    int lenorder;
    public static String foodcart;

    public static String pricecart;

    public static String quantcart;

    public static String foodcartorder;

    public static String pricecartorder;

    public static String quantcartorder;

    public static String packageorder="";

    public static String packagetemp="";

    String finval ="";
    int sum = 0;

    public static String orderprice="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list_final);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarCartList);
        toolbar.setTitle( "Cart");
        setSupportActionBar(toolbar);
         final TextView ListTotal = (TextView) findViewById(R.id.listtotalfinal);


        lv = (ListView) findViewById(R.id.listViewFinal);
        //itemText = (EditText) findViewById(R.id.editTextAdd);
        //addButton = (Button) findViewById(R.id.addbtn);

        itemList = new ArrayList<>();
        //itemListCore.add("My name");

        //food:restaurantname:submenu:foodname:quantity:price
        //adapter= new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, listItems);
        adapter = new ArrayAdapter<String>(CartListFinal.this,R.layout.card_list_item, R.id.txtitem, itemListCore);
        lv.setAdapter(adapter);
        len = itemListCore.size();
        for(int i =0 ; i<len; i++){
            String value = (String) lv.getItemAtPosition(i);
            String lines[] = value.split("\\r?\\n");
            //Toast.makeText(getApplicationContext(), ""+lines[0]+" "+lines[2], Toast.LENGTH_SHORT).show();
            foodcart = lines[0];

            pricecart = lines[1];
            String pricenumberOnly= pricecart.replaceAll("[^0-9]", "");
            quantcart = lines[2];
            String quantnumberOnly= quantcart.replaceAll("[^0-9]", "");
            //packagetemp=lines[3]+"-"+lines[0]+"-"+lines[2]+"-"+lines[1]+"*";
            int pricenum = Integer.parseInt(pricenumberOnly);
            int quantnum = Integer.parseInt(quantnumberOnly);
            int prod = pricenum*quantnum;
            sum = sum+prod;
            //packageorder=packageorder+packagetemp;

        }

        ListTotal.setText(""+sum+" Tk.");
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemListCore.remove(position);

                //saveArrayList();
                adapter.notifyDataSetChanged();
                len = itemListCore.size();
                sum=0;
                finval ="";
                for(int i =0 ; i<len; i++){
                    String value = (String) lv.getItemAtPosition(i);
                    String lines[] = value.split("\\r?\\n");
                    //Toast.makeText(getApplicationContext(), ""+lines[0]+" "+lines[2], Toast.LENGTH_SHORT).show();
                    foodcart = lines[0];
                    pricecart = lines[1];

                    String pricenumberOnly= pricecart.replaceAll("[^0-9]", "");
                    quantcart = lines[2];
                    String quantnumberOnly= quantcart.replaceAll("[^0-9]", "");
                    int pricenum = Integer.parseInt(pricenumberOnly);
                    int quantnum = Integer.parseInt(quantnumberOnly);
                    int prod = pricenum*quantnum;
                    sum = sum+prod;

                   // finval = finval+sum;

                }

                ListTotal.setText(""+sum+" Tk.");


            }
        });






    }

    public void onOrder(View view){

        packageorder="";
        lenorder = itemListCore.size();
        for(int i =0 ; i<lenorder; i++){
            String value = (String) lv.getItemAtPosition(i);
            String lines[] = value.split("\\r?\\n");
            //Toast.makeText(getApplicationContext(), ""+lines[0]+" "+lines[2], Toast.LENGTH_SHORT).show();
           // foodcart = lines[0];

            pricecartorder = lines[1];
            String pricenumberOnly= pricecart.replaceAll("[^0-9]", "");
            quantcartorder = lines[2];
            String quantnumberOnly= quantcart.replaceAll("[^0-9]", "");
            packagetemp=lines[3]+"-"+lines[0]+"-"+lines[2]+"-"+lines[1]+"*";
            int pricenum = Integer.parseInt(pricenumberOnly);
            int quantnum = Integer.parseInt(quantnumberOnly);
            int prod = pricenum*quantnum;
            //sum = sum+prod;
            packageorder=packageorder+packagetemp;

        }


        orderprice=""+sum;
        ordertype="Food";
        Toast.makeText(getApplicationContext(), packageorder, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(CartListFinal.this,Finalise.class);
        startActivity(intent);
    }

}
