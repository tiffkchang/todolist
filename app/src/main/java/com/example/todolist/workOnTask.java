package com.example.todolist;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class workOnTask extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_on_task);

        Spinner taskBeingWorkedOn = findViewById(R.id.task_being_worked_on);

        chronometer = findViewById(R.id.chronometer);
//        chronometer.setFormat("You've been working for: %s");

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

    public long finishTask(View v) {
        onBackPressed();
        return pauseOffset;
    }

}