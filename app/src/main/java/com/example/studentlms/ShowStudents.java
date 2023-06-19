package com.example.studentlms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowStudents extends AppCompatActivity {
    DBHelper dbHelper;
    List<Student> friendsList;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHelper = new DBHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);
        friendsList = dbHelper.selectAllStudents();
        recyclerView = findViewById(R.id.recycler_view_students);


        recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        layoutManager = new LinearLayoutManager(ShowStudents.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,
//                LinearLayoutManager.HORIZONTAL,
//                false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new StudentRecyclerViewAdapter(friendsList) ;
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
    }
}