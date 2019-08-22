package com.chameleon.iservev10;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

public class SignUp extends AppCompatActivity {

    MaterialEditText edtPhone, edtName, edtPassword, edtAddress;
    String name,password,address,phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtName = (MaterialEditText)findViewById(R.id.edtName);
        edtPassword = (MaterialEditText)findViewById(R.id.edtPassword);
        edtPhone = (MaterialEditText)findViewById(R.id.edtPhone);
        edtName = (MaterialEditText)findViewById(R.id.edtAddress);
        Button b1=(Button) findViewById(R.id.btnSignIn);

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo= connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){

        }
        else {
            Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
            b1.setEnabled(false);
        }

    }

    public void onLogUp(View view){
        name= edtName.getText().toString();
        password=edtPassword.getText().toString();
        address=edtAddress.getText().toString();
        phone_number=edtPhone.getText().toString();
        BackgroundTask1 backgroundTask1 = new BackgroundTask1();
        backgroundTask1.execute(name,password,address,phone_number);

    }

    class BackgroundTask1 extends AsyncTask<String,Void,String> {

        String add_info_url;

        @Override
        protected void onPreExecute(){

            add_info_url = "http://iserve.nexenitlabs.com/add_info.php";

        }

        @Override
        protected String doInBackground(String... args){
            String customer_name,customer_address,customer_password,customer_phone;
            customer_name=args[0];
            customer_password=args[1];
            customer_address=args[2];
            customer_phone=args[3];
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
                        URLEncoder.encode("customer_password","UTF-8")+"="+URLEncoder.encode(customer_password,"UTF-8")+"&"+
                        URLEncoder.encode("customer_phone","UTF-8")+"="+URLEncoder.encode(customer_phone,"UTF-8");
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
            Toast.makeText(getApplicationContext(),"Registered Successfully.",Toast.LENGTH_LONG).show();
        }
    }
}
