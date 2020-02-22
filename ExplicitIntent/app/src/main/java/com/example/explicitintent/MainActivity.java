package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TEXT_TO_EDIT = "text_to_edit";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendClicked(View view) {
        EditText et = findViewById(R.id.et);
        String text = et.getText().toString();
        Intent intent = new Intent(this, EditTextActivity.class);
        intent.putExtra(TEXT_TO_EDIT,text);
        startActivity(intent);
    }
}
