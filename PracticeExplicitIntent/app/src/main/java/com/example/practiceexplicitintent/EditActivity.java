package com.example.practiceexplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        tvResult = findViewById(R.id.tvResult);

        Intent intent = getIntent();
        if(intent.hasExtra(MainActivity.TEXT_TO_EDIT)) {
            Toast.makeText(this, "Received Text: " + intent.getStringExtra(MainActivity.TEXT_TO_EDIT), Toast.LENGTH_SHORT).show();
            tvResult.setText("Received Text: " + intent.getStringExtra(MainActivity.TEXT_TO_EDIT));
        }
    }
}
