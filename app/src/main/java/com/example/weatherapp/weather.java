package com.example.weatherapp;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface weather {
    @GET("weather")
     Call<response> getWeather(@Query("q") String cityName, @Query("appid") String apiKey );

}
