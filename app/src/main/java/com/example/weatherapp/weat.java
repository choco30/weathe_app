package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class weat {
   @SerializedName("id")
    String id;
   @SerializedName("description")
    String description;
   @SerializedName("icon")
    String icon;
   @SerializedName("main")
    String main;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
}
