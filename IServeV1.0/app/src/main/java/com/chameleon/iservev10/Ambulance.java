package com.chameleon.iservev10;



        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;

        import static com.chameleon.iservev10.GridMenu.ordertype;

public class Ambulance extends AppCompatActivity {
    EditText fromambulanceET,toambulanceET;
    String fromambulance,toambulance;
    public static String ambulancedetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);
        fromambulanceET=(EditText)findViewById(R.id.FromAmbulanceET);
        toambulanceET=(EditText)findViewById(R.id.toAmbulanceET);
    }
    public void onCommonPageAmbulance(View view){
        fromambulance=fromambulanceET.getText().toString();
        toambulance=toambulanceET.getText().toString();
        ambulancedetail=fromambulance+"-"+toambulance;
        ordertype="ambulance";
        Intent intent = new Intent(Ambulance.this, MainActivity.class);
        startActivity(intent);
    }

}
