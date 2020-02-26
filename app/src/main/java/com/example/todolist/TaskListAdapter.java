package com.example.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import com.daimajia.swipe.adapters.ArraySwipeAdapter;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskListViewHolder> {
    private Context c;
    private ArrayList<Task> todo_list;

    public static class TaskListViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TaskListViewHolder(View v) {
            super(v);
            view = v;
        }
    }

    public TaskListAdapter(Context c, ArrayList<Task> todo_list) {
        this.c = c;
        this.todo_list = todo_list;
    }

    public Context getContext() { return c; }

    public TaskListAdapter.TaskListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        TaskListViewHolder vh = new TaskListViewHolder(v);
        return vh;
    }

    public Task getItem(int position) { return todo_list.get(position); }

    public void onBindViewHolder(TaskListViewHolder holder, int position) {
        String taskName = getItem(position).getTaskName();
        int estimatedHours = getItem(position).getEstimatedHours();
        int estimatedMinutes = getItem(position).getEstimatedMinutes();

        TextView tName = (TextView) holder.view.findViewById(R.id.text1);
        TextView eTaskLength = (TextView) holder.view.findViewById(R.id.text2);
        CheckBox completed = (CheckBox) holder.view.findViewById(R.id.completed);

        String eTaskLengthString = "";

        if (estimatedHours == 1) {
            if (estimatedMinutes == 1) {
                eTaskLengthString = Integer.toString(estimatedHours) + " hour " + Integer.toString(estimatedMinutes) + " minute remaining";
            } else {
                eTaskLengthString = Integer.toString(estimatedHours) + " hour " + Integer.toString(estimatedMinutes) + " minutes remaining";
            }
        } else {
            if (estimatedMinutes == 1) {
                eTaskLengthString = Integer.toString(estimatedHours) + " hours" + Integer.toString(estimatedMinutes) + " minute remaining";
            } else {
                eTaskLengthString = Integer.toString(estimatedHours) + " hours " + Integer.toString(estimatedMinutes) + " minutes remaining";
            }
        }

        tName.setText(taskName);
        eTaskLength.setText(eTaskLengthString);
        completed.setActivated(false);
    }

    public int getItemCount() { return todo_list.size(); }

    public void deleteTask(int position) {
        todo_list.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,todo_list.size());

    }

    public void deleteAllTasks() {
        for (int i = todo_list.size() - 1; i >= 0; i--) {
            todo_list.remove(i);
            notifyItemRemoved(i);
            notifyItemRangeChanged(i,todo_list.size());
        }
    }


}
