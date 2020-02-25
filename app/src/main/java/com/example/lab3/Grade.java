package com.example.lab3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Grade extends Activity {
    int score;
    int total;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.grade);
        Intent intent = getIntent();
        score = intent.getIntExtra("Score", 0);
        total = intent.getIntExtra("Total_Number_Of_Questions", 1);

        TextView t = (TextView) findViewById(R.id.textView4);

        String scoreStr = Integer.toString(score);
        String totalStr = Integer.toString(total);

        t.setText(scoreStr + "/" + totalStr);
    }
}
