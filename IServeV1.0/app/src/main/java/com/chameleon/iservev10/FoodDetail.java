package com.chameleon.iservev10;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.chameleon.iservev10.Database.Database;
import com.chameleon.iservev10.Model.Order;

import static com.chameleon.iservev10.DisplaySubMenu.foodname;
import static com.chameleon.iservev10.FoodList.food;
import static com.chameleon.iservev10.FoodList.price;

import static com.chameleon.iservev10.GridMenu.itemListCore;
import static com.chameleon.iservev10.Rest.ResName;
import static com.chameleon.iservev10.Rest.resname;

//import static com.chameleon.iservev10.FoodList.food;
//import static com.chameleon.iservev10.FoodList.price;

public class FoodDetail extends AppCompatActivity {

    TextView food_name, food_price,food_description;
   // ImageView food_image;
   CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;
    TextView textCartItemCount;
    public static int mCartItemCount = 0;

    public static int backflag=0;
    String foodId="";
    String discount="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        //Init View
        numberButton = (ElegantNumberButton) findViewById(R.id.number_button);
        btnCart = (FloatingActionButton) findViewById(R.id.btncart);
        textCartItemCount = (TextView) findViewById(R.id.badge_notification_1);

        setupBadge();



        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCartItemCount=0;
                Intent cartIntent = new Intent(FoodDetail.this, CartListFinal.class);
                startActivity(cartIntent);

            }
        });

        food_description = (TextView)findViewById(R.id.food_description);
        food_name = (TextView) findViewById(R.id.food_name);
        food_price = (TextView) findViewById(R.id.food_price);
       // food_image = (ImageView) findViewById(R.id.imgfood);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
       collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);

        //get name and id;

        food_name.setText(food);
        food_price.setText(price);
        food_description.setText("Delivery within 60 minutes.");
    }



    public void onAddToCart(View view){

        String order = food+"\n"+price+"\nQuantity: "+numberButton.getNumber()+"\nRestaurant: "+resname;
        itemListCore.add(order);

        Toast.makeText(FoodDetail.this, "Added To Cart", Toast.LENGTH_SHORT).show();
        mCartItemCount++;
        setupBadge();


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

    public void onBackPressed()
    {
        //do whatever you want the 'Back' button to do
        //as an example the 'Back' button is set to start a new Activity named 'NewActivity'
        String method = "get_food";
        //new BackgroundTask(this).execute(method,"Paanshi");





        BackgroundTask backgroundTask = new BackgroundTask(FoodDetail.this);
        backgroundTask.execute(method,resname, foodname);





        return;
    }
}
