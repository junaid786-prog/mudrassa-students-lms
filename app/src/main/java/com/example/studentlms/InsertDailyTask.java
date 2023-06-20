package com.example.studentlms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InsertDailyTask extends AppCompatActivity {

    // temp
    TaskDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_daily_task);

        db = new TaskDBHelper(this);
        String rollNo = "bsef20a511";
        Button insertStudentTask = findViewById(R.id.insert_student_task_btn);
        TextView sabaqView = findViewById(R.id.edit_student_record_sabaq);
        TextView sabaqiView = findViewById(R.id.edit_student_record_sabaqi);
        TextView manzalView = findViewById(R.id.edit_student_record_manzal);
        insertStudentTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sabaq = sabaqView.getText().toString();
                String sabaqi = sabaqiView.getText().toString();
                String manzal = manzalView.getText().toString();
                String currentDate = db.getCurrentDate();
                Task task = new Task(rollNo, sabaq, sabaqi, manzal, currentDate);
                db.insertTask(task);
            }
        });
    }
}