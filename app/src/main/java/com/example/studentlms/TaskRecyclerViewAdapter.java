package com.example.studentlms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskRecyclerViewAdapter.MyVH> {

    List<Task> tasksList;
    public TaskRecyclerViewAdapter(List<Task> tasksList) {
        this.tasksList = tasksList;
    }

    @NonNull
    @Override
    public TaskRecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_card, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskRecyclerViewAdapter.MyVH holder, int position) {
        holder.data = tasksList.get(position);
        holder.textViewStudentName.setText(holder.data.getRollNo());
        holder.textViewStudentRollNo.setText(String.valueOf(holder.data.getRollNo()));
        holder.textViewStudentSabaq.setText(String.valueOf(holder.data.getSabaq()));
        holder.textViewStudentSabaqi.setText(String.valueOf(holder.data.getSabaqi()));
        holder.textViewStudentManzal.setText(String.valueOf(holder.data.getManzil()));
        holder.textViewTaskDate.setText(String.valueOf(holder.data.getDate()));

    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView textViewStudentName;
        TextView textViewStudentRollNo;
        TextView textViewTaskDate;
        TextView textViewStudentSabaq;
        TextView textViewStudentSabaqi;
        TextView textViewStudentManzal;

        Task data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            textViewStudentName = itemView.findViewById(R.id.edit_task_roll_no);
            textViewStudentRollNo = itemView.findViewById(R.id.edit_task_roll_no);
            textViewStudentSabaq = itemView.findViewById(R.id.edit_task_sabaq);
            textViewStudentSabaqi = itemView.findViewById(R.id.edit_task_sabaqi);
            textViewStudentManzal = itemView.findViewById(R.id.edit_task_manzal);
            textViewTaskDate = itemView.findViewById(R.id.edit_task_date);
        }
    }
}
