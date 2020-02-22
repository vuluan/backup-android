package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvDetail;
    TextView tvDate;
    TextView tvPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvTitle = findViewById(R.id.tvTitle);
        tvDetail = findViewById(R.id.tvDetail);
        tvDate = findViewById(R.id.tvDate);
        tvPriority = findViewById(R.id.tvPriority);

        Intent intent = getIntent();
        if(intent.hasExtra(MainActivity.TITLE_TO_DISPLAY)) {
            tvTitle.setText(intent.getStringExtra(MainActivity.TITLE_TO_DISPLAY));
        }
        if(intent.hasExtra(MainActivity.DETAIL_TO_DISPLAY)) {
            tvDetail.setText(intent.getStringExtra(MainActivity.DETAIL_TO_DISPLAY));
        }
        if(intent.hasExtra(MainActivity.DATE_TO_DISPLAY)) {
            tvDate.setText(intent.getStringExtra(MainActivity.DATE_TO_DISPLAY));
        }
        if(intent.hasExtra(MainActivity.PRIORITY_TO_DISPLAY)) {
            if (intent.getExtras().getBoolean(MainActivity.PRIORITY_TO_DISPLAY)) {
                tvPriority.setVisibility(View.VISIBLE);
            } else {
                tvPriority.setVisibility(View.INVISIBLE);
            }
        }

    }
}
