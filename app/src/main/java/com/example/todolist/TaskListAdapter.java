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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TaskListAdapter extends ArrayAdapter<Task> {
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
        int estimatedTaskLength = getItem(position).getEstimatedTaskLength();

        Task task = new Task(taskName, estimatedTaskLength);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tName = (TextView) convertView.findViewById(R.id.text1);
        TextView eTaskLength = (TextView) convertView.findViewById(R.id.text2);
        CheckBox completed = (CheckBox) convertView.findViewById(R.id.completed);

        tName.setText(taskName);
        eTaskLength.setText(Integer.toString(estimatedTaskLength));
        completed.setActivated(false);

        return convertView;

    }
}
