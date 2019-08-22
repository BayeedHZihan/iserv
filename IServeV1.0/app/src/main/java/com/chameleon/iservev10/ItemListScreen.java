package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ItemListScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list_screen);
    }

    public void onSignUp(View view){

        Intent intent = new Intent(getApplicationContext(), SignUp.class);
        startActivity(intent);
    }

    public void onSignIn(View view){

        Intent intent = new Intent(getApplicationContext(), SignIn.class);
        startActivity(intent);
    }

    public void onVisit(View view){
      //  Intent intent = new Intent(ItemListScreen.this, TicketType.class);
      //  startActivity(intent);
        Intent cartIntent = new Intent(ItemListScreen.this, Region.class);
        startActivity(cartIntent);
    }

//    public void onBackPressed()
//    {
//        //do whatever you want the 'Back' button to do
//        //as an example the 'Back' button is set to start a new Activity named 'NewActivity'
//
//        //new BackgroundTask(this).execute(method,"Paanshi");
//
//
////        Intent intent = new Intent(ItemListScreen.this, Region.class);
////        startActivity(intent);
////        System.exit(1);
////
////
//
//
//
//
//
//
//
//        return;
//    }
}
