package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        editText = findViewById(R.id.et_2);

        Intent intent = getIntent();
        if(intent.hasExtra(MainActivity.TEXT_TO_EDIT)) {
            Toast.makeText(this, "Received Text: " + intent.getStringExtra(MainActivity.TEXT_TO_EDIT), Toast.LENGTH_SHORT).show();
            editText.setText("Received Text: "+intent.getStringExtra(MainActivity.TEXT_TO_EDIT));
        }

    }
}
