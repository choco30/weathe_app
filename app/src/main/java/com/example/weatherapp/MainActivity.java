package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
 private final String apikey="533c9b5178600cb0819d3b1b14267dbd";
 private final String url="https://api.openweathermap.org/data/2.5/";
 EditText tf1;
 TextView temp,humidity,air_p,city,temp_max,temp_min;
 Button b;
 private response example;
 private main mai;
 public DecimalFormat df2=new DecimalFormat("#.##");

 SwipeRefreshLayout swipe;
 ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                    swipe=findViewById(R.id.swipe);
                 tf1=findViewById(R.id.tf1);
                 b=findViewById(R.id.button);
                 temp=findViewById(R.id.temp);
                 humidity=findViewById(R.id.humidity);
        air_p=findViewById(R.id.air_p);
        temp_min=findViewById(R.id.temp_min);
        temp_max=findViewById(R.id.temp_max);
        city=findViewById(R.id.city);
        image=findViewById(R.id.image);
        b.setOnClickListener(v -> apicall());
       swipe.setOnRefreshListener(() -> b.setOnClickListener(v -> apicall()));


    }

    private void apicall() {
        Retrofit retro=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        weather call=retro.create(weather.class);

       String a= tf1.getText().toString().trim();
        Call<response> call1=call.getWeather(a,apikey);
             call1.enqueue(new Callback<response>() {
                 @Override
                 public void onResponse(Call<response> call, Response<response> response) {
                     if(!response.isSuccessful()){
                         Log.d("error",String.valueOf(response.message()));

                     }
                     else if(response.code()==404)
                         Toast.makeText(MainActivity.this, "Enter Valid City Name", Toast.LENGTH_SHORT).show();
                     else{
                         Log.i("response",String.valueOf(response.code()));
                         response example=response.body();
                          main mai=example.getMai();
                         List<weat> we= example.getweather();
                          Log.d("temp",mai.getTemp());
                          temp.setText(String.valueOf(df2.format(Double.valueOf(mai.getTemp())-273.15)));
                          city.setText(tf1.getText().toString());
                          air_p.setText(mai.getPressure());
                          temp_min.setText(String.valueOf(df2.format(Double.valueOf(mai.getTempmin())-273.15)));
                          temp_max.setText(String.valueOf(df2.format(Double.valueOf(mai.getTempmax())-273.15)));
                          humidity.setText((mai.getHumidity()));
                          switch(we.get(0).getIcon())
                          {
                              case "01d":image.setBackgroundResource(R.drawable.sun);
                              break;
                              case "01n":image.setBackgroundResource(R.drawable.moon);
                                  break;
                              default:image.setBackgroundResource(R.drawable.download);
                          }
                     }

                 }

                 @Override
                 public void onFailure(Call<response> call, Throwable t) {
                     Log.i("err",t.getMessage());
                     Toast.makeText(MainActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                 }
             });
         
    }
}