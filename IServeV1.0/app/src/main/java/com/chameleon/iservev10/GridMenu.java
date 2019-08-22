package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import static com.chameleon.iservev10.DisplaySubMenu.foodname;
import static com.chameleon.iservev10.Rest.resname;

public class GridMenu extends AppCompatActivity {
    public static String ordertype="";
    public static ArrayList<String> itemListCore = new ArrayList<>();
    //online edits
    public static String json_string2;
    public static String resbuffer="";

    //online edits end


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_menu);
    }
    public void onFood(View view){
        String method = "get_rest";
        new BackgroundTask(this).execute(method);

       // Intent intent = new Intent(GridMenu.this,Rest.class);
       // startActivity(intent);
    }
    public void onLaundry(View view){
        Intent intent = new Intent(GridMenu.this,LaundryPrice.class);
        startActivity(intent);
    }
    public void onTicket(View view) {
        Intent intent = new Intent(GridMenu.this, TicketType.class);
        startActivity(intent);
    }
    public void onBillPayment(View view) {
        Intent intent = new Intent(GridMenu.this, BillPayment.class);
        startActivity(intent);
    }
    public void onDoctorSerial(View view) {
        Intent intent = new Intent(GridMenu.this, Doctor.class);
       startActivity(intent);
    }
    public void onGrocery(View view) {
        Intent intent = new Intent(GridMenu.this, Grocery.class);
       startActivity(intent);
    }
    public void onMedicine(View view) {
        Intent intent = new Intent(GridMenu.this, Medicine.class);
        startActivity(intent);
    }
    public void onAmbulance(View view) {
        Intent intent = new Intent(GridMenu.this, Ambulance.class);
       startActivity(intent);
    }
    public void onRentaCar(View view) {
        Intent intent = new Intent(GridMenu.this, RentaCar.class);
        startActivity(intent);
    }
    public void onHotelBooking(View view) {
        Intent intent = new Intent(GridMenu.this, HotelBooking.class);
        startActivity(intent);
    }
    public void onRepair(View view) {
        Toast.makeText(getApplicationContext(),"Feature Under Construction",Toast.LENGTH_LONG).show();
    }
    public void onCourier(View view) {
        Intent intent = new Intent(GridMenu.this, Delivery.class);
        startActivity(intent);
    }
    public void onProductDelivery(View view) {
       Intent intent = new Intent(GridMenu.this, Delivery.class);
       startActivity(intent);
    }
    public void onFruit(View view) {
       Intent intent = new Intent(GridMenu.this, Fruit.class);
       startActivity(intent);
    }
    public void onGift(View view) {
        Intent intent = new Intent(GridMenu.this, Delivery.class);
       startActivity(intent);
    }
    public void onContact(View view) {
      Intent intent = new Intent(GridMenu.this, ContactUs.class);
       startActivity(intent);
    }

    public void onBackPressed()
    {
        //do whatever you want the 'Back' button to do
        //as an example the 'Back' button is set to start a new Activity named 'NewActivity'

        //new BackgroundTask(this).execute(method,"Paanshi");


        Intent intent = new Intent(GridMenu.this, Region.class);
        startActivity(intent);









        return;
    }
}
