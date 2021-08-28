package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class response {
   @SerializedName("main")
    public main mai;
   @SerializedName("weather")
   public List<weat> weather;

    public main getMai() {
        return mai;
    }
      public List<weat> getweather(){
        return weather;
      }
}
