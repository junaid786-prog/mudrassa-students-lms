package com.example.studentlms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class AddStudent extends AppCompatActivity {

    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        db = new DBHelper(this);

        Button addStudentAction = findViewById(R.id.add_student_action);
        TextView rollNo = findViewById(R.id.student_rollno);
        TextView name = findViewById(R.id.student_name);
        TextView age = findViewById(R.id.student_age);
        addStudentAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameValue, rollNoValue;
                int ageValue = 0;
                rollNoValue = rollNo.getText().toString();
                nameValue = name.getText().toString();
                try {
                    ageValue = Integer.parseInt(age.getText().toString());
                    Student student = new Student(nameValue, ageValue, rollNoValue);
                    db.insertStudent(student);
                }
                catch (SQLiteConstraintException exc){
                    Toast.makeText(AddStudent.this, "Roll no already taken", Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Toast.makeText(AddStudent.this, "Enter right age", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(AddStudent.this, "Student created successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AddStudent.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}