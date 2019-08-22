package com.chameleon.iservev10;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import static com.chameleon.iservev10.GridMenu.ordertype;

public class HotelBooking extends AppCompatActivity {
    Spinner Hotelspinner;
    EditText checkindateET;
    EditText checkoutdateET;
    EditText hotelnameET;
    EditText hotelplaceET;
    String hotelname,hotelplace,checkindate,checkoutdate,roomtype;
    public static String hoteldetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_booking);
        Hotelspinner=(Spinner) findViewById(R.id.RoomTypeSP);
        ArrayAdapter<String> SeatAdapter=new ArrayAdapter<String>(HotelBooking.this,
                R.layout.spinner_item, getResources().getStringArray(R.array.RoomNames));
        SeatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Hotelspinner.setAdapter(SeatAdapter);
        hotelnameET=(EditText)findViewById(R.id.HotelNameET);
        hotelplaceET=(EditText)findViewById(R.id.HotelPlaceNameET);
        checkindateET=(EditText)findViewById(R.id.CheckinDateET);
        checkoutdateET=(EditText)findViewById(R.id.CheckoutDateET);
    }
    public void onCommonPageHotelBooking(View view){
        hotelname=hotelnameET.getText().toString();
        hotelplace=hotelplaceET.getText().toString();
        checkindate=checkindateET.getText().toString();
        checkoutdate=checkoutdateET.getText().toString();
        roomtype=Hotelspinner.getSelectedItem().toString();
        hoteldetail=hotelname+"*"+hotelplace+"*"+checkindate+"*"+checkoutdate+"*"+roomtype;
        ordertype="hotel";
        Intent intent = new Intent(HotelBooking.this,Finalise.class);
        startActivity(intent);
    }
}
