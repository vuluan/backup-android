package com.example.quiz1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String TITLE_TO_DISPLAY = "title_to_display";
    public static final String DETAIL_TO_DISPLAY = "detail_to_display";
    public static final String DATE_TO_DISPLAY = "date_to_display";
    public static final String PRIORITY_TO_DISPLAY = "priority_to_display";

    Intent displayIntent;
    EditText etTitle;
    EditText etDetail;
    CheckBox cbPriority;

    DatePicker mainDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayIntent = new Intent(this, DisplayActivity.class);
        etTitle = findViewById(R.id.etTitle);
        etDetail = findViewById(R.id.etDetail);
        cbPriority = findViewById(R.id.cbPriority);
        mainDatePicker = findViewById(R.id.mainDatePicker);

    }

    public void doneClicked(View view) {

        String date = mainDatePicker.getYear() + "/" + (mainDatePicker.getMonth() + 1) + "/" + mainDatePicker.getDayOfMonth();

        displayIntent.putExtra(TITLE_TO_DISPLAY, etTitle.getText().toString());
        displayIntent.putExtra(DETAIL_TO_DISPLAY, etDetail.getText().toString());
        displayIntent.putExtra(DATE_TO_DISPLAY, date);
        displayIntent.putExtra(PRIORITY_TO_DISPLAY, cbPriority.isChecked());

        startActivity(displayIntent);
    }
}
