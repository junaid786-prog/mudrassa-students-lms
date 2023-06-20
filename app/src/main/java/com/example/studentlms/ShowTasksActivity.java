package com.example.studentlms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ShowTasksActivity extends AppCompatActivity {
    TaskDBHelper dbHelper;
    List<Task> tasksList;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tasks);

        dbHelper = new TaskDBHelper(this);

        Button searchTaskBtn = findViewById(R.id.search_task_by_rollno_btn);
        TextView rollNoEntryView = findViewById(R.id.edit_search_task_by_rollno);
        searchTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollNo = rollNoEntryView.getText().toString();

                tasksList = dbHelper.selectAllTasks(rollNo);
                recyclerView = findViewById(R.id.show_tasks_recycler_view);


                recyclerView.setHasFixedSize(true);

                //LinearLayoutManager GridLayoutManager
                layoutManager = new LinearLayoutManager(ShowTasksActivity.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,
//                LinearLayoutManager.HORIZONTAL,
//                false);
                recyclerView.setLayoutManager(layoutManager);

                adapter = new TaskRecyclerViewAdapter(tasksList) ;
                recyclerView.setAdapter(adapter);
            }
        });
    }
}