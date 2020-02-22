package com.example.diceout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // create variale to hold the score
    int score;

    // Field to hold the roll result text
    TextView txtResult;

    // Field to hold the roll roll button
    Button btnRoll;

    // Field to hold the score
    TextView txtScore;

    // Create variable to hold random number
    Random rand;

    // Create variable to hold value of dice 1
    int dice1;
    int dice2;
    int dice3;

    // ArrayList to hold all three dice values
    ArrayList<Integer> dice;

    // ArrayList to hold all three images
    ArrayList<ImageView> diceImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // set initial score
        score = 0;

        Toast.makeText(getApplicationContext(), "Welcome to DiceOut!", Toast.LENGTH_SHORT).show();

        txtResult = findViewById(R.id.txtResult);
        btnRoll = findViewById(R.id.btnRoll);
        txtScore = findViewById(R.id.txtScore);

        rand = new Random();

        dice = new ArrayList<Integer>();

        ImageView dice1Image = findViewById(R.id.dice1Image);
        ImageView dice2Image = findViewById(R.id.dice2Image);
        ImageView dice3Image = findViewById(R.id.dice3Image);

        diceImageView = new ArrayList<ImageView>();
        diceImageView.add(dice1Image);
        diceImageView.add(dice2Image);
        diceImageView.add(dice3Image);
    }

    public void rollDice(View view) {
        dice1 = rand.nextInt(6) + 1;
        dice2 = rand.nextInt(6) + 1;
        dice3 = rand.nextInt(6) + 1;

        dice.clear();
        dice.add(dice1);
        dice.add(dice2);
        dice.add(dice3);

        for (int diceOffet = 0; diceOffet < 3; diceOffet++) {
            String imageName = "dice_" + dice.get(diceOffet) + ".png";
            try {
                InputStream stream = getAssets().open(imageName);
                Drawable d = Drawable.createFromStream(stream, null);
                diceImageView.get(diceOffet).setImageDrawable(d);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String msg = "";
        if (dice1 == dice2 && dice1 == dice3) {
            int scoreDelta = dice1 * 100;
            msg = "You rolled a triple " + dice1 + "! You score " + scoreDelta + " points!";
            score += scoreDelta;
        } else if (dice1 == dice2 || dice1 == dice3 || dice2 == dice3){
            msg = "You rolled a doubles for 50 points!";
            score += 50;
        } else {
            msg = "You didn't score this roll please try again!";
        }

        txtResult.setText(msg);
        txtScore.setText("Score: " + score);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
