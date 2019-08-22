package com.chameleon.iservev10;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;




public class CartList extends AppCompatActivity {
    String[] items;
    ArrayList <String> listItems;
    ArrayAdapter<String> adapter;
    ArrayList<String> itemList;
    ListView lvProduct;
    EditText editTextFoodList;
    public static String foodfinal;
    public static String pricefinal;
    TextView listtotal;
    int len;
    String finval ="";


    int i =0;
    int j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        listtotal = (TextView) findViewById(R.id.littotal);

        lvProduct = (ListView)findViewById(R.id.listviewFoodList);
        itemList = new ArrayList<>();
        itemList.add("My name");
        itemList.add("Khan");
        adapter = new ArrayAdapter<String>(CartList.this,  R.layout.list_item, itemList);
        lvProduct.setAdapter(adapter);


        //initFoodList();





    }

    public void searchFoodItem(String textToSearch){
        for(String item:items){
            ;
            String mitem = item.toLowerCase();
            String mtexttoSearch = textToSearch.toLowerCase();

            if( !mitem.contains(textToSearch.toLowerCase()) ){
                listItems.remove(item);
            }
        }

        adapter.notifyDataSetChanged();
    }

    public void initFoodList(){

        items= new String[]{"Chicken Pasta\n\nPrice: 200 Tk.", "Grill\n\nPrice: 75 Tk.", "Biriyani\n\nPrice: 110 Tk.", "Daal\n\nPrice: 20 Tk." };
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter= new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, listItems);
        lvProduct.setAdapter(adapter);
         len = listItems.size();

        for(int i =0 ; i<len ; i++){
            String val = (String) lvProduct.getItemAtPosition(i);
            finval = finval+val;
        }
        listtotal.setText(finval);
        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemposition = position;
                String value = (String) lvProduct.getItemAtPosition(position);
                String lines[] = value.split("\\r?\\n");
               // listtotal.setText("200");
                Toast.makeText(getApplicationContext(), ""+lines[0]+" "+lines[2], Toast.LENGTH_SHORT).show();
                foodfinal = lines[0];
                pricefinal = lines[2];
                listItems.remove(value);
                initFoodList();





            }
        });

    }

    public void calculate(){

        int len = items.length;
        listtotal.setText(len);


    }
}
