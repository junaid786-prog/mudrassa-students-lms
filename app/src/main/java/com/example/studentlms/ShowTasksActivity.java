package com.example.studentlms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowTasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tasks);

        Button searchTaskBtn = findViewById(R.id.search_task_by_rollno_btn);
        TextView rollNoEntryView = findViewById(R.id.edit_search_task_by_rollno);
        searchTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollNo = rollNoEntryView.getText().toString();

            }
        });
    }
}