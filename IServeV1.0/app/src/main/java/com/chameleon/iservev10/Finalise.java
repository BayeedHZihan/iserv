package com.chameleon.iservev10;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chameleon.iservev10.Model.Order;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import static com.chameleon.iservev10.Ambulance.ambulancedetail;
import static com.chameleon.iservev10.BackInfoBill.creditcarddetail;
import static com.chameleon.iservev10.BillPayment.elecdetail;
import static com.chameleon.iservev10.BillPayment.gasdetail;
import static com.chameleon.iservev10.BillPayment.internetdetail;
import static com.chameleon.iservev10.BillPayment.otherdetail;
import static com.chameleon.iservev10.BusTicket.busticketdetail;
import static com.chameleon.iservev10.CartListFinal.orderprice;
import static com.chameleon.iservev10.CartListFinal.packageorder;
import static com.chameleon.iservev10.Delivery.deliverydetail;
import static com.chameleon.iservev10.Doctor.doctordetail;
import static com.chameleon.iservev10.Fruit.fruitdetail;
import static com.chameleon.iservev10.GridMenu.ordertype;
import static com.chameleon.iservev10.Grocery.grocerydetail;
import static com.chameleon.iservev10.HotelBooking.hoteldetail;
import static com.chameleon.iservev10.ManualOrder.manualpackage;
import static com.chameleon.iservev10.Medicine.medicinedetail;
import static com.chameleon.iservev10.Region.regionorder;
import static com.chameleon.iservev10.RentaCar.rentacardetail;
import static com.chameleon.iservev10.TrainTicket.trainticketdetail;
import static com.chameleon.iservev10.laundryCheckbox.laundrydetail;

public class Finalise extends AppCompatActivity {
    String customer_name;
    String customer_address;
    String customer_phone;
    String ordertypefinal;
    String detail;
    String totalprice;
    String region;
    //ordertype
    //details
    //totalprice

    MaterialEditText edtPhoneFinal, edtNameFinal, edtaddressFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalise);

        edtPhoneFinal = (MaterialEditText)findViewById(R.id.edtPhoneFinal);
        edtNameFinal = (MaterialEditText)findViewById(R.id.edtNameFinal);
        edtaddressFinal = (MaterialEditText)findViewById(R.id.edtAddressFinal);
        Button b1=(Button) findViewById(R.id.btnConfirmOrder);


        //connectivity

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo= connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){

        }
        else {
            Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
            b1.setEnabled(false);
        }

        //connectend
    }

    public void onFinal(View view){

        customer_name= edtNameFinal.getText().toString();
        customer_address=edtaddressFinal.getText().toString();
        customer_phone=edtPhoneFinal.getText().toString();
        region=regionorder;
        if(customer_name.length()!=0 && customer_address.length()!= 0 && customer_phone.length()!= 0){
            ordertypefinal=ordertype;
            if(ordertypefinal=="Food"){
                detail = packageorder;
                totalprice = orderprice;
                //Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );
            }
            else if(ordertypefinal=="ManualFood"){

                detail = manualpackage;
                totalprice = "Manual Order";
               // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="doctor"){

                detail = doctordetail;
                totalprice = "Doctor Order";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="grocery"){

                detail = grocerydetail;
                totalprice = "Grocery Order";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="medicine"){

                detail = medicinedetail;
                totalprice = "Medicine Order";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="ambulance"){

                detail = ambulancedetail;
                totalprice = "Ambulance Order";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="rentacar"){

                detail = rentacardetail;
                totalprice = "Rent-a-car Order";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="hotel"){

                detail = hoteldetail;
                totalprice = "Hotel Order";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="delivery"){

                detail = deliverydetail;
                totalprice = "Delivery/Courier/Gift";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="fruit"){

                detail = fruitdetail;
                totalprice = "Fruit Order";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="laundry"){

                detail = laundrydetail;
                totalprice = "Laundry Order";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="busticket"){

                detail = busticketdetail;
                totalprice = "Bus Ticket Order";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="trainticket"){

                detail = trainticketdetail;
                totalprice = "Train/Plane Ticket Order";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="creditcardorder"){

                detail = creditcarddetail;
                totalprice = "Credit Card Bill";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="electricitybill"){

                detail = elecdetail;
                totalprice = "Electricity Bill";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="gasbill"){

                detail = gasdetail;
                totalprice = "Gas Bill";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="internetbill"){

                detail = internetdetail;
                totalprice = "Internet Bill";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }
            else if(ordertypefinal=="otherbill"){

                detail = otherdetail;
                totalprice = "Other Bill";
                // Toast.makeText(getApplicationContext(), detail +"\n" + totalprice, Toast.LENGTH_LONG).show();
                BackgroundTaskP backgroundTaskP = new BackgroundTaskP();
                backgroundTaskP.execute(customer_name,customer_address,customer_phone,ordertypefinal, detail, totalprice,region );


            }

        }
        else{
            Toast.makeText(getApplicationContext(), "Please fill up all the fields.", Toast.LENGTH_LONG).show();

        }





    }

    //backgroundtaskbeings
    class BackgroundTaskP extends AsyncTask<String,Void,String> {

        String add_info_url;

        @Override
        protected void onPreExecute(){

            add_info_url = "http://iserve.nexenitlabs.com/add_order.php";

        }

        @Override
        protected String doInBackground(String... args){
            String customer_name,customer_address,customer_phone,ordertypefinal1, detail, totalprice,region,status;
            customer_name=args[0];

            customer_address=args[1];
            customer_phone=args[2];
            ordertypefinal1=args[3];
            detail=args[4];
            totalprice=args[5];
            region=args[6];
            status="1";

            //nametemp=name;
            try {
                URL url = new URL(add_info_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream= httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data_string= URLEncoder.encode("customer_name","UTF-8")+"="+URLEncoder.encode(customer_name,"UTF-8")+"&"+
                        URLEncoder.encode("customer_address","UTF-8")+"="+URLEncoder.encode(customer_address,"UTF-8")+"&"+
                        URLEncoder.encode("customer_phone","UTF-8")+"="+URLEncoder.encode(customer_phone,"UTF-8")+"&"+
                        URLEncoder.encode("ordertypefinal1","UTF-8")+"="+URLEncoder.encode(ordertypefinal1,"UTF-8")+"&"+
                        URLEncoder.encode("detail","UTF-8")+"="+URLEncoder.encode(detail,"UTF-8")+"&"+
                        URLEncoder.encode("totalprice","UTF-8")+"="+URLEncoder.encode(totalprice,"UTF-8")+"&"+
                        URLEncoder.encode("region","UTF-8")+"="+URLEncoder.encode(region,"UTF-8")+"&"+
                        URLEncoder.encode("status","UTF-8")+"="+URLEncoder.encode(status,"UTF-8");
                bufferedWriter.write(data_string);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.close();
                httpURLConnection.disconnect();
                return "Registered...";

            }catch(MalformedURLException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result){
            Toast.makeText(getApplicationContext(),"Order Completed Successfully.",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Finalise.this,OrderCheck.class);
            startActivity(intent);
        }
    }
}
