package com.example.com.myoptus;

/**
 * Created by SU357582 on 2/7/2017.
 */

public class MyLocations {

    private String name, car, train;
    private double lat, lang;

    public void setName(String na)
    {
        name = na;
    }

    public void setCarMode(String na)
    {
        car = na;
    }
    public void setTrainMode(String na)
    {
        train = na;
    }

    public void setLatitude(float s)
    {
        lat = s;
    }

    public void setLongitude(float s)
    {
        lang = s;
    }

    public String getName()
    {
       return name;
    }
    public String getCarMode()
    {
        return car;
    }
    public String getTrainMode()
    {
        return train;
    }
    public double getLatitude()
    {
        return lat;
    }
    public double getLongitude()
    {
        return lang;
    }


}
