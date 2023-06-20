package com.example.studentlms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class StudentRecyclerViewAdapter extends RecyclerView.Adapter<StudentRecyclerViewAdapter.MyVH> {

    List<Student> studentsList;
    public StudentRecyclerViewAdapter(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public StudentRecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_card, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentRecyclerViewAdapter.MyVH holder, int position) {
        holder.data=studentsList.get(position);
        holder.textViewStudentName.setText(holder.data.getName());
        holder.textViewStudentRollNo.setText(String.valueOf(holder.data.getRollNo()));
        holder.textViewStudentAge.setText(String.valueOf(holder.data.getAge()));
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView textViewStudentName;
        TextView textViewStudentRollNo;
        TextView textViewStudentAge;
        Student data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            textViewStudentName = itemView.findViewById(R.id.student_card_name_field);
            textViewStudentRollNo = itemView.findViewById(R.id.student_card_rollno_field);
            textViewStudentAge = itemView.findViewById(R.id.student_card_age_field);
        }
    }
}
