package com.pickers.opteamix.custompickers.Util;

/**
 * Created by SGangavaram on 3/20/2017.
 */

public class DateAndTimePickerUtil   {



    public static String getDateStringInFormat(int date_x,int month_x,int year_x) {
        String dateString = "";

        //Setting dayOfMonth format
        if (date_x < 10) {
            dateString = dateString + "0" + date_x + "-";
        } else {
            dateString = dateString + date_x + "-";
        }

        //Setting monthOfYear format
        int displayMonth = month_x + 1;
        if (month_x < 9) {
            dateString = dateString + "0" + displayMonth + "-";
        } else {
            dateString = dateString + displayMonth + "-";
        }

        //Setting year
        return dateString + year_x;
    }




    public static String getTimeStringInFormat(int hour_x,int minute_x) {
        String timeString = "";

        if (hour_x < 10) {
            timeString = timeString + "0" + hour_x + ":";
        } else {
            timeString = timeString + hour_x + ":";
        }

        int displayMin = minute_x;
        if (minute_x < 10) {
            timeString = timeString +"0"+ displayMin;
        } else {
            timeString = timeString + displayMin;
        }

        return timeString;
    }

}
