package com.example.firstapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ChooseCurs_Activity extends AppCompatActivity {

    Button doneBttn;
    private Spinner spnCourses;
    private ListView lastView;
    private int selectedCoursePosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choose);

        initViews();
        populateSpinner();
        setOnItemSelected();

    }

    // initialization and control items on UI
    private void initViews() {
        spnCourses = findViewById(R.id.spnCourses);
        lastView = findViewById(R.id.lastView);
    }

    // Save the selected item position of the spinners
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("selectedCoursePosition", selectedCoursePosition);
    }

    // Restore the selected item position of the spinners
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        selectedCoursePosition = savedInstanceState.getInt("selectedCoursePosition");
        spnCourses.setSelection(selectedCoursePosition);
    }

    // Read data from DataBase and out it on Spinner Chooser
    private void populateSpinner() {
        DataBase_Courses db = new DataBase_Courses();
        List<Course> courses = db.getInitialCourses();
        ArrayAdapter<Course> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, courses);
        spnCourses.setAdapter(adapter);
    }


//     Spinner Set Actions
    private void setOnItemSelected() {
        spnCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Course selectedCourse = (Course) parent.getItemAtPosition(position);
                selectedCoursePosition = position;

                //populate List View
                List<String> subjects = selectedCourse.getSubjects();
                ArrayAdapter<String> subjectAdapter = new ArrayAdapter<String>(ChooseCurs_Activity.this, android.R.layout.simple_list_item_1, subjects);
                lastView.setAdapter(subjectAdapter);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        lastView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected subject
                String selectedSubject = ((TextView) view).getText().toString();

                Intent intent;
                switch (selectedSubject) {
                    case "Pandas":
                        intent = new Intent(ChooseCurs_Activity.this, Quizes_Activity.class);
                        break;
                    case "Numpy":
                        intent = new Intent(ChooseCurs_Activity.this, Quizes_Activity.class);
                        break;
                    default:
                        intent = new Intent(ChooseCurs_Activity.this, Quizes_Activity.class);
                }
                intent.putExtra("selected_subject", selectedSubject);
                startActivity(intent);
            }
        });
    }

    // Action for Started Button
    private void setOnStartBttn() {
        doneBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseCurs_Activity.this, Quizes_Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}