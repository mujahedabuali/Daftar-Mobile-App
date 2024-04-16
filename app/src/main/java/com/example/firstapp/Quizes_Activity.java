package com.example.firstapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Quizes_Activity extends AppCompatActivity {

    private String selectedItem;
    private TextView subText;

    private RadioGroup radio_q1;
    private RadioGroup radio_q2;
    private RadioGroup radio_q3;
    private RadioGroup radio_q4;
    private RadioGroup radio_q5;
    private RadioGroup radio_q6;
    private RadioGroup radio_q7;

    private Button ansBttn1;
    private Button ansBttn2;
    private Button ansBttn3;
    private Button ansBttn4;
    private Button ansBttn5;
    private Button ansBttn6;
    private Button ansBttn7;

    private TextView ansTxt1;
    private TextView ansTxt2;
    private TextView ansTxt3;
    private TextView ansTxt4;
    private TextView ansTxt5;
    private TextView ansTxt6;
    private TextView ansTxt7;

    private Button endbttn;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);

        initViews();
        selectedItem();
        answersBttn();
        endBttn();
    }

    // End Button Action
    private void endBttn() {
        endbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quizes_Activity.this, ChooseCurs_Activity.class);
                startActivity(intent);
            }
        });
    }
    // initialization and control items on UI
    private void initViews() {
        subText = findViewById(R.id.subjectTxt);

        radio_q1 = findViewById(R.id.radioQ1);
        radio_q2 = findViewById(R.id.radioQ2);
        radio_q3 = findViewById(R.id.radioQ3);
        radio_q4 = findViewById(R.id.radioQ4);
        radio_q5 = findViewById(R.id.radioQ5);
        radio_q6 = findViewById(R.id.radioQ6);
        radio_q7 = findViewById(R.id.radioQ7);

        ansBttn1 = findViewById(R.id.ans1);
        ansBttn2 = findViewById(R.id.ans2);
        ansBttn3 = findViewById(R.id.ans3);
        ansBttn4 = findViewById(R.id.ans4);
        ansBttn5 = findViewById(R.id.ans5);
        ansBttn6 = findViewById(R.id.ans6);
        ansBttn7 = findViewById(R.id.ans7);

        ansTxt1 = findViewById(R.id.AnswerInfo1);
        ansTxt2 = findViewById(R.id.AnswerInfo2);
        ansTxt3 = findViewById(R.id.AnswerInfo3);
        ansTxt4 = findViewById(R.id.AnswerInfo4);
        ansTxt5 = findViewById(R.id.AnswerInfo5);
        ansTxt6 = findViewById(R.id.AnswerInfo6);
        ansTxt7 = findViewById(R.id.AnswerInfo7);

        endbttn = findViewById(R.id.end_button);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("result1", ansTxt1.getText().toString());
        outState.putInt("result1_color", ansTxt1.getCurrentTextColor());

        outState.putString("result2", ansTxt2.getText().toString());
        outState.putInt("result2_color", ansTxt2.getCurrentTextColor());

        outState.putString("result3", ansTxt3.getText().toString());
        outState.putInt("result3_color", ansTxt3.getCurrentTextColor());

        outState.putString("result4", ansTxt4.getText().toString());
        outState.putInt("result4_color", ansTxt4.getCurrentTextColor());

        outState.putString("result5", ansTxt5.getText().toString());
        outState.putInt("result5_color", ansTxt5.getCurrentTextColor());

        outState.putString("result6", ansTxt6.getText().toString());
        outState.putInt("result6_color", ansTxt6.getCurrentTextColor());

        outState.putString("result7", ansTxt7.getText().toString());
        outState.putInt("result7_color", ansTxt7.getCurrentTextColor());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        ansTxt1.setText(savedInstanceState.getString("result1", ""));
        ansTxt1.setTextColor(savedInstanceState.getInt("result1_color", Color.BLACK));

        ansTxt2.setText(savedInstanceState.getString("result2", ""));
        ansTxt2.setTextColor(savedInstanceState.getInt("result2_color", Color.BLACK));

        ansTxt3.setText(savedInstanceState.getString("result3", ""));
        ansTxt3.setTextColor(savedInstanceState.getInt("result3_color", Color.BLACK));

        ansTxt4.setText(savedInstanceState.getString("result4", ""));
        ansTxt4.setTextColor(savedInstanceState.getInt("result4_color", Color.BLACK));

        ansTxt5.setText(savedInstanceState.getString("result5", ""));
        ansTxt5.setTextColor(savedInstanceState.getInt("result5_color", Color.BLACK));

        ansTxt6.setText(savedInstanceState.getString("result6", ""));
        ansTxt6.setTextColor(savedInstanceState.getInt("result6_color", Color.BLACK));

        ansTxt7.setText(savedInstanceState.getString("result7", ""));
        ansTxt7.setTextColor(savedInstanceState.getInt("result7_color", Color.BLACK));



    }



    // Setup Subject Name Text
    private void selectedItem() {
        selectedItem = getIntent().getStringExtra("selected_subject");
        subText.setText("Subject: "+ selectedItem );
    }

    // Answer Buttons Action
    private void answersBttn() {
        //Q1
        ansBttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = radio_q1.getCheckedRadioButtonId();

                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String selectedAnswer = selectedRadioButton.getText().toString();

                    String correctAnswer = "Array";
                    boolean isCorrect = selectedAnswer.equals(correctAnswer);

                    if (isCorrect) {
                        ansTxt1.setText("True! ✅");
                        ansTxt1.setTextColor(Color.parseColor("#1BAE21"));
                    } else {
                        ansTxt1.setText("False 😡");
                        ansTxt1.setTextColor(Color.RED);
                    }
                } else {
                    Toast.makeText(Quizes_Activity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Q2
        ansBttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = radio_q2.getCheckedRadioButtonId();

                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String selectedAnswer = selectedRadioButton.getText().toString();

                    String correctAnswer = "read_csv()";
                    boolean isCorrect = selectedAnswer.equals(correctAnswer);

                    if (isCorrect) {
                        ansTxt2.setText("True! ✅");
                        ansTxt2.setTextColor(Color.parseColor("#1BAE21"));
                    } else {
                        ansTxt2.setText("False 😡");
                        ansTxt2.setTextColor(Color.RED);
                    }
                } else {
                    // No radio button is selected
                    Toast.makeText(Quizes_Activity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Q3
        ansBttn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = radio_q3.getCheckedRadioButtonId();

                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String selectedAnswer = selectedRadioButton.getText().toString();

                    String correctAnswer = "dropna()";
                    boolean isCorrect = selectedAnswer.equals(correctAnswer);

                    if (isCorrect) {
                        ansTxt3.setText("True! ✅");
                        ansTxt3.setTextColor(Color.parseColor("#1BAE21"));
                    } else {
                        ansTxt3.setText("False 😡");
                        ansTxt3.setTextColor(Color.RED);
                    }
                } else {
                    // No radio button is selected
                    Toast.makeText(Quizes_Activity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Q4
        ansBttn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = radio_q4.getCheckedRadioButtonId();

                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String selectedAnswer = selectedRadioButton.getText().toString();

                    String correctAnswer = "df['A']";
                    boolean isCorrect = selectedAnswer.equals(correctAnswer);

                    if (isCorrect) {
                        ansTxt4.setText("True! ✅");
                        ansTxt4.setTextColor(Color.parseColor("#1BAE21"));
                    } else {
                        ansTxt4.setText("False 😡");
                        ansTxt4.setTextColor(Color.RED);
                    }
                } else {
                    // No radio button is selected
                    Toast.makeText(Quizes_Activity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Q5
        ansBttn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = radio_q5.getCheckedRadioButtonId();

                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String selectedAnswer = selectedRadioButton.getText().toString();

                    String correctAnswer = "merge()";
                    boolean isCorrect = selectedAnswer.equals(correctAnswer);
                    if (isCorrect) {
                        ansTxt5.setText("True! ✅");
                        ansTxt5.setTextColor(Color.parseColor("#1BAE21"));
                    } else {
                        ansTxt5.setText("False 😡");
                        ansTxt5.setTextColor(Color.RED);
                    }
                } else {
                    // No radio button is selected
                    Toast.makeText(Quizes_Activity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Q6
        ansBttn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = radio_q6.getCheckedRadioButtonId();

                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String selectedAnswer = selectedRadioButton.getText().toString();

                    String correctAnswer = "mode()";
                    boolean isCorrect = selectedAnswer.equals(correctAnswer);
                    if (isCorrect) {
                        ansTxt6.setText("True! ✅");
                        ansTxt6.setTextColor(Color.parseColor("#1BAE21"));
                    } else {
                        ansTxt6.setText("False 😡");
                        ansTxt6.setTextColor(Color.RED);
                    }
                } else {
                    // No radio button is selected
                    Toast.makeText(Quizes_Activity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Q7
        ansBttn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = radio_q7.getCheckedRadioButtonId();

                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String selectedAnswer = selectedRadioButton.getText().toString();

                    String correctAnswer = "rename()";
                    boolean isCorrect = selectedAnswer.equals(correctAnswer);

                    if (isCorrect) {
                        ansTxt7.setText("True! ✅");
                        ansTxt7.setTextColor(Color.parseColor("#1BAE21"));
                    } else {
                        ansTxt7.setText("False 😡");
                        ansTxt7.setTextColor(Color.RED);
                    }
                } else {
                    // No radio button is selected
                    Toast.makeText(Quizes_Activity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
