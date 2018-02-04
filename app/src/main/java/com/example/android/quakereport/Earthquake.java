package com.example.android.quakereport;

/**
 * Created by Mateusz on 03.02.2018.
 */

public class Earthquake {


    private String mEarthquakePlace;

    private String mEarthquakeMagnitude;

    private String mEarthquakeDate;

    private String mEarthquakeReports;



    public Earthquake(String earthquakePlace, String earthquakeMagnitude, String earthquakeDate){
        mEarthquakePlace = earthquakePlace;
        mEarthquakeMagnitude = earthquakeMagnitude;
        mEarthquakeDate = earthquakeDate;
    }

    public String getEarthquakePlace(){
        return mEarthquakePlace;
    }

    public String getEarthquakeMagnitude(){
        return mEarthquakeMagnitude;
    }

    public String getEarthquakeDate(){
        return mEarthquakeDate;
    }
}
