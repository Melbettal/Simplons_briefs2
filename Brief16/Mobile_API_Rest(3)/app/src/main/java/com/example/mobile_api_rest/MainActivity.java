package com.example.mobile_api_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_categorie = (Button) findViewById(R.id.categorie);
        Button btn_produit= (Button) findViewById(R.id.produit);

        btn_categorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             // Instantiate the RequestQueue.
                        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                        String url ="https://www.metaweather.com/api/location/search/?query=tokyo";

        // Request a string response from the provided URL.
                         StringRequest stringRequest = new StringRequest(Request.Method.GET, url,

                                 response -> Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show(), new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this,"Problem dans la categorie",Toast.LENGTH_SHORT).show();
                            }
                        });

                // Add the request to the RequestQueue.
                queue.add(stringRequest);
                //Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();


            }
        });

        btn_produit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url ="https://www.metaweather.com/api/location/search/?query=OSLO";

                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,url,null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        String cityId = "";
                        String cityName = "";
                        String cityType = "";
                        try {
                            JSONObject cityInformation = response.getJSONObject(0);
                              cityId = cityInformation.getString("woeid");
                              cityName = cityInformation.getString("title");
                            cityType = cityInformation.getString("location_type");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String finalResult ="Id City : " + cityId +"\n"+" City Name : " + cityName +"\n"+"Type : " + cityType;
                        Toast.makeText(getApplicationContext(),finalResult,Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"Probleme dans la ville Oslo ",Toast.LENGTH_SHORT).show();
                    }

                });
                queue.add(request);
//                // Request a string response from the provided URL.
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//
//                        response -> Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show(), new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this,"Problem dans la categorie",Toast.LENGTH_SHORT).show();
//                    }
//                });

                // Add the request to the RequestQueue.
               // queue.add(stringRequest);
                //Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();


                //Toast.makeText(getApplicationContext(),"Hello java",Toast.LENGTH_SHORT).show();
            }
        });
    }
}