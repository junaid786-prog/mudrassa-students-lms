package com.example.studentlms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addStudent = findViewById(R.id.add_student);
        Button showStudents = findViewById(R.id.show_students);
        Button insertStudent = findViewById(R.id.insert_std_record_btn);
        Button showTasks = findViewById(R.id.show_student_record_btn);

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveActivity = new Intent(MainActivity.this, AddStudent.class);
                startActivity(moveActivity);
            }
        });
        showStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveActivity = new Intent(MainActivity.this, ShowStudents.class);
                startActivity(moveActivity);
            }
        });

        insertStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveActivity = new Intent(MainActivity.this, InsertDailyTask.class);
                startActivity(moveActivity);
            }
        });

        showTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveActivity = new Intent(MainActivity.this, ShowTasksActivity.class);
                startActivity(moveActivity);
            }
        });
    }
}