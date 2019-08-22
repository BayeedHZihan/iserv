package com.chameleon.iservev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import static com.chameleon.iservev10.GridMenu.ordertype;

public class TrainTicket extends AppCompatActivity {
    Spinner Trainspinner,Seatspinner;
    EditText toTrainET;
    EditText fromTrainET;
    EditText dateTrainET;
    String toTrain,fromTrain,dateTrain,timeTrain,seatTrain;

    public static String trainticketdetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_ticket);
        Trainspinner=(Spinner) findViewById(R.id.TimeSP);
        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(TrainTicket.this,
                R.layout.spinner_item, getResources().getStringArray(R.array.TimeNames));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Trainspinner.setAdapter(myAdapter);
        Seatspinner=(Spinner) findViewById(R.id.SeatTypeSP);
        ArrayAdapter<String> SeatAdapter=new ArrayAdapter<String>(TrainTicket.this,
                R.layout.spinner_item, getResources().getStringArray(R.array.SeatNames));
        SeatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Seatspinner.setAdapter(SeatAdapter);
        toTrainET=(EditText)findViewById(R.id.TrainPlaceToET);
        fromTrainET=(EditText)findViewById(R.id.TrainPlaceFromET);
        dateTrainET=(EditText)findViewById(R.id.TrainDateET);
    }
    public void onCommonPageTrain(View view){
        toTrain=toTrainET.getText().toString();
        fromTrain=fromTrainET.getText().toString();
        dateTrain=dateTrainET.getText().toString();
        timeTrain=Trainspinner.getSelectedItem().toString();
        seatTrain=Seatspinner.getSelectedItem().toString();
        trainticketdetail=fromTrain+"*"+toTrain+"*"+dateTrain+"*"+timeTrain+"*"+seatTrain;
        ordertype="trainticket";
        Intent intent = new Intent(TrainTicket.this, Finalise.class);
        startActivity(intent);
    }
}
