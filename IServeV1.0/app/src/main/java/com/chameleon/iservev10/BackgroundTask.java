package com.chameleon.iservev10;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;



/**
 * Created by HEMAYEET on 7/22/2017.
 */

public class BackgroundTask extends AsyncTask<String, Void, String> {


    String JSON_STRING;
    public static String statmethod;
    public static String jsondata;
    public static String checktemp="";


    String json_string;
    JSONObject jsonObject;
    JSONArray jsonnArray;

    //edits


    //edits
    AlertDialog alertDialog;

    Context ctx;
    BackgroundTask(Context ctx){

        this.ctx = ctx;
    }

    protected void onPreExecute(){
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information");


    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://iserve1.000webhostapp.com/add_info.php";
        String login_url = "http://iserve.nexenitlabs.com/json_get_data.php";
        String sub_url = "http://iserve.nexenitlabs.com/json_get_submenu.php";
        String food_url="http://iserve.nexenitlabs.com/json_get_foodlist.php";
        String getsession_url="http://iserve.nexenitlabs.com/json_get_session.php";
        String method = params[0];
        if(method.equals("add_info"))
        {
            statmethod = method;
            String restname = params[1];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("restname", "UTF-8") +"=" +URLEncoder.encode(restname, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration Success";
            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        else if(method.equals("get_rest")) {

            statmethod = method;
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                /*
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("login_name", "UTF-8") +"=" +URLEncoder.encode(login_name, "UTF-8")+"&"+
                        URLEncoder.encode("login_pass", "UTF-8") +"=" +URLEncoder.encode(login_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                */
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                //  String response = "";
                // String line = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {

                    stringBuilder.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        else if(method.equals("get_session")) {

            String customer_phone = params[1];
            String customer_password = params[2];

            checktemp=params[1];

            statmethod = method;
            try {
                URL url = new URL(getsession_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("customer_phone", "UTF-8") +"=" +URLEncoder.encode(customer_phone, "UTF-8")+"&"+
                        URLEncoder.encode("customer_password", "UTF-8") +"=" +URLEncoder.encode(customer_password, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                /*
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("login_name", "UTF-8") +"=" +URLEncoder.encode(login_name, "UTF-8")+"&"+
                        URLEncoder.encode("login_pass", "UTF-8") +"=" +URLEncoder.encode(login_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                */
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                //  String response = "";
                // String line = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {

                    stringBuilder.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        else if(method.equals("get_sub")) {
            String restname = params[1];
            statmethod = method;

            try {
                URL url = new URL(sub_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("restname", "UTF-8") +"=" +URLEncoder.encode(restname, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                /*
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("login_name", "UTF-8") +"=" +URLEncoder.encode(login_name, "UTF-8")+"&"+
                        URLEncoder.encode("login_pass", "UTF-8") +"=" +URLEncoder.encode(login_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                */
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                //  String response = "";
                // String line = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {

                    stringBuilder.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        else if(method.equals("get_sub")) {
            String restname = params[1];
            statmethod = method;

            try {
                URL url = new URL(sub_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("restname", "UTF-8") +"=" +URLEncoder.encode(restname, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                /*
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("login_name", "UTF-8") +"=" +URLEncoder.encode(login_name, "UTF-8")+"&"+
                        URLEncoder.encode("login_pass", "UTF-8") +"=" +URLEncoder.encode(login_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                */
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                //  String response = "";
                // String line = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {

                    stringBuilder.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        else if(method.equals("get_food")) {
            String restname = params[1];
            String sub = params[2];
            statmethod = method;

            try {
                URL url = new URL(food_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("restname", "UTF-8") +"=" +URLEncoder.encode(restname, "UTF-8")+"&"+
                        URLEncoder.encode("sub", "UTF-8") +"=" +URLEncoder.encode(sub, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                /*
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("login_name", "UTF-8") +"=" +URLEncoder.encode(login_name, "UTF-8")+"&"+
                        URLEncoder.encode("login_pass", "UTF-8") +"=" +URLEncoder.encode(login_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                */
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                //  String response = "";
                // String line = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {

                    stringBuilder.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        else if(method.equals("get_recheck")) {
            String restname = params[1];
            statmethod = method;

            try {
                URL url = new URL(sub_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("restname", "UTF-8") +"=" +URLEncoder.encode(restname, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                /*
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("login_name", "UTF-8") +"=" +URLEncoder.encode(login_name, "UTF-8")+"&"+
                        URLEncoder.encode("login_pass", "UTF-8") +"=" +URLEncoder.encode(login_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                */
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                //  String response = "";
                // String line = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {

                    stringBuilder.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        return null;

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("Registration Success")) {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else if(result.equals("Login Failed. Try Again.")) {
            alertDialog.setMessage(result);
            alertDialog.show();

        }
        else
        {


            String json_string2 = result;
            if(json_string2==null)
            {
                Toast.makeText(ctx.getApplicationContext(), "First get jsonn", Toast.LENGTH_LONG).show();
            }
            else
            {
                if(statmethod.equals("get_rest")){
                    Intent intent = new Intent(ctx.getApplicationContext(),Rest.class);
                    intent.putExtra("json_data",json_string2);
                    //MainActivity.resbuffer=json_string2;
                    ctx.startActivity(intent);
                }
                else if(statmethod.equals("get_sub")){
                    Intent intentsub = new Intent(ctx.getApplicationContext(),DisplaySubMenu.class);
                    intentsub.putExtra("json_data",json_string2);
                    ctx.startActivity(intentsub);


                }
                else if(statmethod.equals("get_food")){
                    Intent intentsub = new Intent(ctx.getApplicationContext(),FoodList.class);
                    intentsub.putExtra("json_data",json_string2);
                    ctx.startActivity(intentsub);


                }
                else if(statmethod.equals("get_session")){
                   // Intent intentsub = new Intent(ctx.getApplicationContext(),DisplaySubMenu.class);
                   // intentsub.putExtra("json_data",json_string2);
                   // ctx.startActivity(intentsub);
                    //jsondata= json_string2;
                    String name = "";
                    String phone="";


                    //Toast.makeText(ctx.getApplicationContext(), "First get jsonn", Toast.LENGTH_LONG).show();
                    try{
                        //tvresult.setText("hi1");
                        jsonObject = new JSONObject(json_string2);
                        // tvresult.setText("hi2");
                        jsonnArray = jsonObject.getJSONArray("server_respone");
                        // tvresult.setText("hi3");
                        int count=0;
                        //String restname;


                        while(count<jsonnArray.length())
                        {
                            JSONObject JO = jsonnArray.getJSONObject(count);
                            name = JO.getString("restname");
                            phone = JO.getString("phone");
                           // password = JO.getString("customer_password");


                           // ar.add(restname);
                           // itemList.add(restname);

                            count++;


                        }

                    }catch(JSONException e){
                        e.printStackTrace();
                    }

                    if(checktemp.equals(name)){
                        Intent intentsub = new Intent(ctx.getApplicationContext(),Region.class);
                        //intentsub.putExtra("json_data",json_string2);
                        ctx.startActivity(intentsub);


                    }
                    else if (name!=checktemp){
                        Toast.makeText(ctx.getApplicationContext(), "Wrong Phone Number or Password.", Toast.LENGTH_LONG).show();
                    }




                }


            }




        }

    }
}
