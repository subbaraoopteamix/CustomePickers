package com.pickers.opteamix.custompickers.View;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TimePicker;

import com.pickers.opteamix.custompickers.R;

import java.util.Calendar;

/**
 * Created by SGangavaram on 3/20/2017.
 */

public class CustomTimePicker  extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    public int hour,minute;
    TimeFace timeFace;

    public interface TimeFace{
        void setTime(CustomTimePicker customTimePicker);
    }

    public void setBase(TimeFace timeFace){
        this.timeFace = timeFace;
    }

    public void setTime(int hour,int minute){
        this.hour = hour;
        this.minute = minute;
    }

    public void startSetTime(int hour,int minute){
        this.hour = hour;
        this.minute = minute;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        Calendar calendar = Calendar.getInstance();
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), R.style.datepicker,this,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);

        return timePickerDialog;
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        this.hour = i;
        this.minute = i1;
        if(timeFace!=null)
            timeFace.setTime(this);
    }
}
