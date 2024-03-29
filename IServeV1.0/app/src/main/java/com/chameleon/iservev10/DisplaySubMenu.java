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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static com.chameleon.iservev10.FoodDetail.mCartItemCount;
import static com.chameleon.iservev10.Rest.ResName;
import static com.chameleon.iservev10.Rest.resname;


public class DisplaySubMenu extends AppCompatActivity {

    public static String foodname;

    //online edits

    ArrayList<String> itemList;
    //ArrayAdapter<String> adapter;
    ListView lv;

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonnArray;
    ArrayList<String> ar = new ArrayList<String>();



    //online edits end
    String[] items;
    ArrayList <String> listItems;
    ArrayAdapter<String> adapter;
    ListView lvProduct;
    EditText editTextFoodList;
    public static String food;
    public static String price;
    TextView textCartItemCount;


    int i =0;
    int j;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sub_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarSubMenuList);
        toolbar.setTitle(ResName+ " Menu");
        setSupportActionBar(toolbar);

        json_string = getIntent().getExtras().getString("json_data");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabSubMenu1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCartItemCount=0;
                Intent cartIntent = new Intent(DisplaySubMenu.this, CartListFinal.class);
                startActivity(cartIntent);
            }
        });


        textCartItemCount = (TextView) findViewById(R.id.badge_notification_1_SubMenulist);
        setupBadgeFoodList();

        lvProduct = (ListView)findViewById(R.id.listviewSubMenuList);
        try{
            // tvresult.setText("hi1");
            jsonObject = new JSONObject(json_string);
            // tvresult.setText("hi2");
            jsonnArray = jsonObject.getJSONArray("server_respone");
            // tvresult.setText("hi3");
            int count=0;
            String restname;


            while(count<jsonnArray.length())
            {
                JSONObject JO = jsonnArray.getJSONObject(count);
                restname = JO.getString("restname");


                ar.add(restname);
                //itemList.add(restname);

                count++;


            }

        }catch(JSONException e){
            e.printStackTrace();
        }
        editTextFoodList = (EditText) findViewById(R.id.txtsearchSubMenuList);

        adapter= new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, ar);
       // adapter = new ArrayAdapter<String>(DisplaySubMenu.this,R.layout.card_list_item, R.id.txtitem, ar);
        lvProduct.setAdapter(adapter);
        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String) lvProduct.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), resname+" "+ value, Toast.LENGTH_LONG ).show();
                // String method = "get_sub";
                // new BackgroundTask(getApplicationContext()).execute(method,value);
                // finish();
                String method = "get_food";
                //new BackgroundTask(this).execute(method,"Paanshi");
                foodname = value;




                BackgroundTask backgroundTask = new BackgroundTask(DisplaySubMenu.this);
                backgroundTask.execute(method,resname, value);


            }
        });

        //initFoodList();


        editTextFoodList.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
                if(keyCode == KeyEvent.KEYCODE_DEL) {
                    editTextFoodList.setText("");
                }
                return false;
            }
        });

        editTextFoodList.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().equals("")){
                    initFoodList();
                }
                else{
                    searchFoodItem(s.toString());

                }
            }

            @Override
            public void afterTextChanged(Editable s) {



            }
        });


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
        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemposition = position;
                String value = (String) lvProduct.getItemAtPosition(position);
                String lines[] = value.split("\\r?\\n");
                Toast.makeText(getApplicationContext(), ""+lines[0]+" "+lines[2], Toast.LENGTH_SHORT).show();
                food = lines[0];
                price = lines[2];


                Intent intent = new Intent(getApplicationContext(), FoodDetail.class);
                startActivity(intent);


            }
        });

    }

    public void setupBadgeFoodList() {

        if (textCartItemCount != null) {
            if (mCartItemCount == 0) {
                if (textCartItemCount.getVisibility() != View.GONE) {
                    textCartItemCount.setVisibility(View.GONE);
                }
            } else {
                textCartItemCount.setText(String.valueOf(Math.min(mCartItemCount, 99)));
                if (textCartItemCount.getVisibility() != View.VISIBLE) {
                    textCartItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    public void onBackPressed()
    {
        //do whatever you want the 'Back' button to do
        //as an example the 'Back' button is set to start a new Activity named 'NewActivity'
        //Intent newIntent = new Intent(DisplaySubMenu.this,Rest.class);
       // newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //startActivity(newIntent);
        String method = "get_rest";
        new BackgroundTask(this).execute(method);



        return;
    }
}
