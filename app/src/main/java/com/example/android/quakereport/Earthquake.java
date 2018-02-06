package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by Mateusz on 03.02.2018.
 */

public class Earthquake {


    private String mEarthquakePlace;

    private String mEarthquakeMagnitude;

    private Long mTimeInMilliseconds;



    public Earthquake(String earthquakePlace, String earthquakeMagnitude, Long timeInMilliseconds){
        mEarthquakePlace = earthquakePlace;
        mEarthquakeMagnitude = earthquakeMagnitude;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    public String getEarthquakePlace(){
        return mEarthquakePlace;
    }

    public String getEarthquakeMagnitude(){
        return mEarthquakeMagnitude;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

}
