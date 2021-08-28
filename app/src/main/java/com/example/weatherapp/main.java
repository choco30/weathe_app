package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class main {

@SerializedName("temp")
    String temp;
    @SerializedName("temp_min")
    String tempmin;
    @SerializedName("temp_max")
    String tempmax;
    @SerializedName("pressure")
    String pressure;
    @SerializedName("humidity")
    String humidity;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTempmin() {
        return tempmin;
    }

    public void setTempmin(String tempmin) {
        this.tempmin = tempmin;
    }

    public String getTempmax() {
        return tempmax;
    }

    public void setTempmax(String tempmax) {
        this.tempmax = tempmax;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
