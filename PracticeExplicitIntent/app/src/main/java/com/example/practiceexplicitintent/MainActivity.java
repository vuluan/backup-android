package com.example.practiceexplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TEXT_TO_EDIT = "text_to_edit";

    EditText etName;
    Intent editIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        editIntent = new Intent(this, EditActivity.class);
    }

    public void sendClicked(View view) {
        editIntent.putExtra(TEXT_TO_EDIT, etName.getText().toString());
        startActivity(editIntent);
    }
}
