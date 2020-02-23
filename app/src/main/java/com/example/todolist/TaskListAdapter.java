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
    private ArrayList<Task> todo_list;

    public static class TaskListViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TaskListViewHolder(View v) {
            super(v);
            view = v;
        }
    }

    public TaskListAdapter(ArrayList<Task> todo_list) {
        this.todo_list = todo_list;
    }

    public TaskListAdapter.TaskListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        String taskName = getItem(position).getTaskName();
        int estimatedHours = getItem(position).getEstimatedHours();
        int estimatedMinutes = getItem(position).getEstimatedMinutes();

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        TaskListViewHolder vh = new TaskListViewHolder(v);
        return vh;
    }

    /*
    private Context mContext;
    private int mResource;

    public TaskListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Task> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String taskName = getItem(position).getTaskName();
        int estimatedHours = getItem(position).getEstimatedHours();
        int estimatedMinutes = getItem(position).getEstimatedMinutes();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tName = (TextView) convertView.findViewById(R.id.text1);
        TextView eTaskLength = (TextView) convertView.findViewById(R.id.text2);
        CheckBox completed = (CheckBox) convertView.findViewById(R.id.completed);

        String eTaskLengthString = "";

        if (estimatedHours == 1) {
            eTaskLengthString = Integer.toString(estimatedHours) + " hour " + Integer.toString(estimatedMinutes) + " minutes";
        } else {
            eTaskLengthString = Integer.toString(estimatedHours) + " hours " + Integer.toString(estimatedMinutes) + " minutes";
        }

        tName.setText(taskName);
        eTaskLength.setText(eTaskLengthString);
        completed.setActivated(false);

        return convertView;

    }

     */

    public void deleteTask(int position) {

    }

}
