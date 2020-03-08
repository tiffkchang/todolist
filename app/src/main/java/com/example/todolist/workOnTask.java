package com.example.todolist;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class workOnTask extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    private ArrayList<Task> tasksToBeListed;
    private Spinner tasksBeingWorkedOn;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private static TaskListAdapter adapt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_on_task);

        prefs = getApplicationContext().getSharedPreferences("myAppPackage", 0);
        editor = prefs.edit();
        adapt = MainActivity.getAdapt();

        tasksBeingWorkedOn = findViewById(R.id.task_being_worked_on);

        chronometer = findViewById(R.id.chronometer);
//        chronometer.setFormat("You've been working for: %s");
        tasksToBeListed = MainActivity.getTasks();
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.spinner_item, tasksToBeListed);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        tasksBeingWorkedOn.setAdapter(adapter);

    }

    public void startChronometer(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }

    public void pauseChronometer(View v) {
        if (running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

    public void resetChronometer(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }

    public void finishTask(View v) {
        int task_pos = tasksBeingWorkedOn.getSelectedItemPosition();
        tasksToBeListed.get(task_pos).setActualTaskLength(pauseOffset);
        adapt.notifyDataSetChanged();
        onBackPressed();
    }

    public void onBackPressed() {
        Log.d("back 2", "back button pressed in workOnTask");
        editor.remove("task_name");
        editor.remove("estimated_hours");
        editor.remove("estimated_minutes");
        editor.apply();
        super.onBackPressed();
    }

}