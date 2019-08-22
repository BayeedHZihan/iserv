package com.chameleon.iservev10;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.R.attr.category;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private int mPreviousLength;
    private boolean mBackSpace;

    //listview code
    String[] items;
    ArrayList <String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;

    //listviewcode ends

    //RecyclerView recycler_menu;
    RecyclerView.LayoutManager layoutManager;
    private List<Category> movieList = new ArrayList<>();
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Restaurants");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        //Load Menu
        listView =(ListView) findViewById(R.id.listviewRes);
        editText = (EditText) findViewById(R.id.txtsearch);
        //initList();
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
                if(keyCode == KeyEvent.KEYCODE_DEL) {
                    editText.setText("");
                }
                return false;
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mPreviousLength = s.length();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPreviousLength = s.length();
                mBackSpace = mPreviousLength > s.length();

                if (mPreviousLength > s.length()) {
                    editText.setText("");



                }
               if(s.toString().equals("")){
                   initList();
               }
               else{
                   searchItem(s.toString());

               }
            }

            @Override
            public void afterTextChanged(Editable s) {
                mBackSpace = mPreviousLength > s.length();

                if (mBackSpace) {
                    editText.setText("");



                }


            }
        });



       // mAdapter = new MyAdapter(movieList, this);
       // recycler_menu = (RecyclerView) findViewById(R.id.recycler_menu);
       // recycler_menu.setHasFixedSize(true);
       // layoutManager = new LinearLayoutManager(this);
       // recycler_menu.setLayoutManager(layoutManager);
       // recycler_menu.setItemAnimator(new DefaultItemAnimator());
      //  recycler_menu.setAdapter(mAdapter);

        /*recycler_menu.addOnItemTouchListener(
                new RecyclerItemClickListener(this.getApplicationContext(), recycler_menu ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        if(position == 0) {
                            Toast.makeText(getApplicationContext(), "You chose paanshi",
                                    Toast.LENGTH_LONG).show();

                        }
                        else if(position == 1) {
                            Toast.makeText(getApplicationContext(), "You chose paachbhai",
                                    Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
        */


       // loadMenu();
        /* recycler menu xml
    <android.support.v7.widget.RecyclerView
        android:layout_width="368dp"
        android:id="@+id/recycler_menu"
        android:scrollbars="vertical"
        android:layout_height="495dp"
        tools:layout_editor_absoluteY="8dp"
        tools:layout_editor_absoluteX="8dp"></android.support.v7.widget.RecyclerView>
         */
    }

    public void searchItem(String textToSearch){
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
    public void initList(){
        items= new String[]{"Cafe La Vista", "Food Lounge", "Hungry Station", "Chick Chicken" };
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter= new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, listItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemposition = position;
                String value = (String) listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), ""+value, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), FoodList.class);
                startActivity(intent);

            }
        });
    }

    private void loadMenu() {
        Category movie = new Category("Paanshi", "Action & Adventure");
        movieList.add(movie);

         movie = new Category("Paach Bhai", "Thriller");
        movieList.add(movie);
        movie = new Category("Foodlounge", "Thriller");
        movieList.add(movie);
        movie = new Category("HungryStation", "Thriller");
        movieList.add(movie);
        movie = new Category("Cafe La Vista", "Thriller");
        movieList.add(movie);
        movie = new Category("Ishti Kutum", "Thriller");
        movieList.add(movie);
        movie = new Category("KachaLonka", "Thriller");
        movieList.add(movie);
        movie = new Category("Chick Chicken", "Thriller");
        movieList.add(movie);
        movie = new Category("Banoful", "Thriller");
        movieList.add(movie);
        movie = new Category("Fulkoli", "Thriller");
        movieList.add(movie);
  }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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

        } else if (id == R.id.nav_cart) {

        } else if (id == R.id.nav_orders) {

        } else if (id == R.id.nav_log_out) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
