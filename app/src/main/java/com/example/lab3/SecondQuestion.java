package com.example.lab3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SecondQuestion extends Activity {
    Button button;
    int num;
    int score;
    int total;
    RadioGroup radioGroup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_question);
        Intent intent = getIntent();
        num = intent.getIntExtra("Number_Of_Questions", 0);
        total = intent.getIntExtra("Total_Number_Of_Questions", 2);
        score = intent.getIntExtra("Score", 0);

        num--;

        button = (Button) findViewById(R.id.button2);
        if(num == 0) {
            button.setText("Finish");
        }

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent;
                try {
                    String answer = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId()))
                            .getText().toString();
                    if (answer.equals("Charlottetown")) {
                        score++;
                    }
                    if (num > 0) {
                        myIntent = new Intent(SecondQuestion.this, ThirdQuestion.class);
                        myIntent.putExtra("Number_Of_Questions", num);
                        myIntent.putExtra("Total_Number_Of_Questions", total);
                        myIntent.putExtra("Score", score);
                    } else {
                        myIntent = new Intent(SecondQuestion.this, Grade.class);
                        myIntent.putExtra("Total_Number_Of_Questions", total);
                        myIntent.putExtra("Score", score);
                    }
                    startActivity(myIntent);
                }catch (Exception e) {
                    //do nothing
                }
            }
        });
    }
}
