package com.chameleon.iservev10;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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

import static com.chameleon.iservev10.FoodDetail.mCartItemCount;

public class Rest extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //online edits

    ArrayList<String> itemList;
    //ArrayAdapter<String> adapter;
    ListView lv;
    public static String resname;



    String json_string;
    JSONObject jsonObject;
    JSONArray jsonnArray;
    ArrayList<String> ar = new ArrayList<String>();
    String textres="1";
    TextView tvresult;
    TextView tvresult1;
    public static int statcount=0;

    //online edits end



    private int mPreviousLength;
    private boolean mBackSpace;
    //listview code
    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView1;
    EditText editText;
    public static String ResName="";
    //public static String ResName;
    //listviewcode ends
    TextView textCartItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Restaurants");
        setSupportActionBar(toolbar);

        json_string = getIntent().getExtras().getString("json_data");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCartItemCount=0;
          Intent cartIntent = new Intent(Rest.this, CartListFinal.class);
                startActivity(cartIntent);
            }
        });



        textCartItemCount = (TextView) findViewById(R.id.badge_notification_1_restname);
        setupBadge();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //load menu
        listView1 =(ListView) findViewById(R.id.listviewRestList);
        itemList = new ArrayList<>();




        try{
            //tvresult.setText("hi1");
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
                itemList.add(restname);

                count++;


            }

        }catch(JSONException e){
            e.printStackTrace();
        }
        //editText = (EditText) findViewById(R.id.txtsearchR);
      // initList();
        adapter= new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, ar);
       // adapter = new ArrayAdapter<String>(Rest.this,R.layout.card_list_item, R.id.txtitem, ar);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String)  listView1.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG ).show();

                String method = "get_sub";
                //new BackgroundTask(this).execute(method,"Paanshi");



                BackgroundTask backgroundTask = new BackgroundTask(Rest.this);
                resname=value;
                backgroundTask.execute(method, value);
                // backgroundTask.cancel(true);
                // finish();





            }
        });








    }



    public void initList(){
        items= new String[]{"Cafe La Vista", "Food Lounge", "Hungry Station", "Chick Chicken" };
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter= new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, listItems);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemposition = position;
                String value = (String) listView1.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), ""+value, Toast.LENGTH_SHORT).show();
                ResName= value;
                Intent intent = new Intent(getApplicationContext(), FoodList.class);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent newIntent = new Intent(Rest.this,GridMenu.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(newIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rest, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu) {
            // Handle the camera action
        } else if (id == R.id.nav_cart) {
            mCartItemCount=0;
            Intent cartIntent = new Intent(Rest.this, CartListFinal.class);
            startActivity(cartIntent);

        }else if (id == R.id.nav_log_out) {
            Intent cartIntent = new Intent(Rest.this, ItemListScreen.class);
            startActivity(cartIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupBadge() {

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

    public void onManualScreen(View view){
        Intent newIntent = new Intent(Rest.this,ManualOrder.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(newIntent);
    }




}
