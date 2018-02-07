package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Mateusz on 03.02.2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context,0,earthquakes);
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude){
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(),magnitudeColorResourceId);
    }




    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_earthquake,parent,
                    false);

            Earthquake currentEarthquake = getItem(position);


            String placeInfo = currentEarthquake.getEarthquakePlace();
            String parts1;
            String parts2;

            if(placeInfo.contains(LOCATION_SEPARATOR)){
                String[] parts = placeInfo.split(LOCATION_SEPARATOR);
                parts1 = parts[0] + LOCATION_SEPARATOR;
                parts2 = parts[1];
            } else {
                parts1 = getContext().getString(R.string.near_the);
                parts2 = placeInfo;
            }

            TextView where = (TextView) listItemView.findViewById(R.id.where);
            where.setText(parts1);

            TextView place = (TextView) listItemView.findViewById(R.id.place);
            place.setText(parts2);

            TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
            String earthquakeMagnitude = formatMagnitude(currentEarthquake.getEarthquakeMagnitude());
            magnitude.setText(earthquakeMagnitude);

            Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

            TextView time = (TextView) listItemView.findViewById(R.id.time);
            String earthquakeTime = formatTime(dateObject);
            time.setText(earthquakeTime);

            TextView date = (TextView) listItemView.findViewById(R.id.date);
            String earthquakeDate = formatDate(dateObject);
            date.setText(earthquakeDate);

            // Set the proper background color on the magnitude circle.
            // Fetch the background from the TextView, which is a GradientDrawable.
            GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

            // Get the appropriate background color based on the current earthquake magnitude
            int magnitudeColor = getMagnitudeColor(currentEarthquake.getEarthquakeMagnitude());

            // Set the color on the magnitude circle
            magnitudeCircle.setColor(magnitudeColor);

        }
        return listItemView;
    }
}
