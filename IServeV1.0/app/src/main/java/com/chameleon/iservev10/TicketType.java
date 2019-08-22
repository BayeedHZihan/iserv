package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TicketType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_type);
    }
    public void onBusTicket(View view){
        Intent intent = new Intent(TicketType.this, BusTicket.class);
        startActivity(intent);
    }
    public void onTrainTicket(View view){
        Intent intent = new Intent(TicketType.this, TrainTicket.class);
        startActivity(intent);
    }
    public void onPlaneTicket(View view){
        Intent intent = new Intent(TicketType.this, TrainTicket.class);
        startActivity(intent);
    }
}
