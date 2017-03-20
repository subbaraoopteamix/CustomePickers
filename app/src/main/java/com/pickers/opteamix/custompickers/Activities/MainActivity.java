package com.pickers.opteamix.custompickers.Activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.pickers.opteamix.custompickers.R;
import com.pickers.opteamix.custompickers.Util.DateAndTimePickerUtil;
import com.pickers.opteamix.custompickers.View.CustomDatePicker;
import com.pickers.opteamix.custompickers.View.CustomTimePicker;

import java.util.Calendar;

public class MainActivity extends Activity implements CustomDatePicker.DateFace, CustomTimePicker.TimeFace{


    private Button currentDateFocus, currentTimeFocus;
    private int year_x, month_x, date_x;
    private int hour_x,minute_x;

    Button datePicker, timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_picker);

      datePicker= (Button)  findViewById(R.id.CustomeDatePicker);

        timePicker = (Button)  findViewById(R.id.CustomeTimePicker);

    }



    public void selectDatePicker(View view) {
        openDatePicker(datePicker);
    }



    public void selectTimePicker(View view) {
        openTimePicker(timePicker);
    }



    private void openDatePicker(Button target){
        currentDateFocus = target;
        CustomDatePicker customDatePicker = new CustomDatePicker();
        customDatePicker.setBase(MainActivity.this);
        customDatePicker.setDate(year_x, month_x, date_x);
        customDatePicker.show(getFragmentManager(), "date Picker");

    }



    @Override
    public void setDate(CustomDatePicker customDatePicker) {
        this.year_x = customDatePicker.year;
        this.month_x = customDatePicker.monthOfYear;
        this.date_x = customDatePicker.dayOfMonth;
        currentDateFocus.setText(DateAndTimePickerUtil.getDateStringInFormat(this.date_x,this.month_x,this.year_x));
        currentDateFocus.setError(null);
    }


    private void openTimePicker(Button target){
        currentTimeFocus = target;
        CustomTimePicker customTimePicker = new CustomTimePicker();
        customTimePicker.setBase(MainActivity.this);
        customTimePicker.setTime(hour_x,minute_x);
        customTimePicker.show(  getFragmentManager(),"time picker");
    }



    @Override
    public void setTime(CustomTimePicker customTimePicker) {
        this.hour_x = customTimePicker.hour;
        this.minute_x = customTimePicker.minute;


        Calendar c = Calendar.getInstance();
        // hour_x, minute_x;

        if (this.minute_x >= c.get(Calendar.MINUTE)
                && this.hour_x >= c.get(Calendar.HOUR_OF_DAY))  {

            currentTimeFocus.setText(DateAndTimePickerUtil.getTimeStringInFormat(this.hour_x,this.minute_x));
        }

        else {
           perfectTimeSelection();

            //  Toast.makeText(getContext(), "No valid Time " ,Toast.LENGTH_SHORT).show();
        }
    }




    public  void perfectTimeSelection() {

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);

        builder.setMessage("Select Appropriate Time, Not Past Time")
                .setCancelable(true)

                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // finish();
                    }
                });


        //Creating dialog box
        android.app.AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Alert");
        alert.show();
    }




}
