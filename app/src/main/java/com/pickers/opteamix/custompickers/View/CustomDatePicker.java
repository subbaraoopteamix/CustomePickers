package com.pickers.opteamix.custompickers.View;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import com.pickers.opteamix.custompickers.R;

import java.util.Calendar;

/**
 * Created by SGangavaram on 3/20/2017.
 */

public class CustomDatePicker   extends DialogFragment implements DatePickerDialog.OnDateSetListener {


    public int year, monthOfYear, dayOfMonth;
    public int dayAddition;
    public int daySubtraction;
    DateFace dateFace;

    public interface DateFace {
        void setDate(CustomDatePicker customDatePicker);
    }

    public CustomDatePicker() {

    }

    public void setBase(DateFace dateFace) {
        this.dateFace =  dateFace;
    }

    public void setDate(int year, int monthOfYear, int dayOfMonth) {
        this.year = year;
        this.monthOfYear = monthOfYear;
        this.dayOfMonth = dayOfMonth;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        Calendar calendar = Calendar.getInstance();

        //Todo check for 29-dec

        /*
                We should use THEME_HOLO_LIGHT, THEME_HOLO_DARK or THEME_TRADITIONAL only.

                The THEME_DEVICE_DEFAULT_LIGHT and THEME_DEVICE_DEFAULT_DARK does not work
                perfectly. This two theme set disable color of disabled dates but users can
                select the disabled dates also.

                Other three themes act perfectly after defined enabled date range of date picker.
                Those theme completely hide the disable dates from date picker object.
             */
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), R.style.datepicker,this, calendar.YEAR, calendar.MONTH, calendar.DAY_OF_MONTH);
//        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, calendar.YEAR, calendar.MONTH, calendar.DAY_OF_MONTH);
        /*
                add(int field, int value)
                    Adds the given amount to a Calendar field.
             */
        // Add 3 days to Calendar


         /*
                getTimeInMillis()
                    Returns the time represented by this Calendar,
                    recomputing the time from its fields if necessary.

                getDatePicker()
                Gets the DatePicker contained in this dialog.

                setMinDate(long minDate)
                    Sets the minimal date supported by this NumberPicker
                    in milliseconds since January 1, 1970 00:00:00 in getDefault() time zone.

                setMaxDate(long maxDate)
                    Sets the maximal date supported by this DatePicker in milliseconds
                    since January 1, 1970 00:00:00 in getDefault() time zone.
             */

        // Set the Calendar new date as maximum date of date picker

        // Subtract 6 days from Calendar updated date

        // Set the Calendar new date as minimum date of date picker
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());

        // So, now date picker selectable date range is 7 days only

//        datePickerDialog.getDatePicker().updateDate(year, monthOfYear, dayOfMonth);

        datePickerDialog.getDatePicker().setDescendantFocusability(DatePicker.FOCUS_BLOCK_DESCENDANTS);
        // Return the DatePickerDialog
//        calendar.add(Calendar.DATE, 17);
        datePickerDialog.getDatePicker().setCalendarViewShown(false);
        datePickerDialog.setTitle("");
        return datePickerDialog;
    }


    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        this.year = year;
        this.monthOfYear = monthOfYear;
        this.dayOfMonth = dayOfMonth;
        if (dateFace != null)
            dateFace.setDate(this);
    }

}
