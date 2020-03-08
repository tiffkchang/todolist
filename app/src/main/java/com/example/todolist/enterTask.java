package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class enterTask extends AppCompatActivity {
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_task);

        prefs = getApplicationContext().getSharedPreferences("myAppPackage", 0);
        editor = prefs.edit();
        tasks = MainActivity.getTasks();

//        EditText task_name = (EditText) findViewById(R.id.task_name);
//        String task_name_value = task_name.getText().toString();
//        task_name.setText(task_name_value);


/*        TextView display_task_name = new TextView(R.id.display_task_name);
        display_task_name.setText(R.id.task_name);*/

        Button back_to_home = findViewById(R.id.back_to_home);
        back_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EditText task_name = (EditText) findViewById(R.id.task_name);
                //String task_name_value = task_name.getText().toString();
                //setTaskName(getApplicationContext(), task_name_value);
                backToHome();
            }
        });
    }

    public static void setTaskName(Context context, String name_of_task) {
        SharedPreferences prefs = context.getSharedPreferences("myAppPackage", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("task_name", name_of_task);
        editor.apply();
    }

    public void backToHome() {
        //Intent intent = new Intent(this, MainActivity.class);
//        SharedPreferences prefs = getApplicationContext().getSharedPreferences("myAppPackage", 0);
//        SharedPreferences.Editor editor = prefs.edit();

        EditText task_name = (EditText) findViewById(R.id.task_name);
        //intent.putExtra("task_name", task_name_value);
        EditText estimated_hours = (EditText) findViewById(R.id.estimated_hours);
        EditText estimated_minutes = (EditText) findViewById(R.id.estimated_minutes);

        String task_name_value = task_name.getText().toString();
        String estimated_hours_value = estimated_hours.getText().toString();
        String estimated_minutes_value = estimated_minutes.getText().toString();

        if (task_name_value.equals("") || estimated_hours_value.equals("") || estimated_minutes_value.equals("")) {
            Toast.makeText(this,"Please populate all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int estimated_minutes_checked = Integer.parseInt(estimated_minutes_value);
        if (estimated_minutes_checked > 59) {
            Toast.makeText(this, "Please enter a minutes value less than 60", Toast.LENGTH_SHORT).show();
            return;
        }

//        tasks.add(new Task(task_name_value, Integer.parseInt(estimated_hours_value), estimated_minutes_checked));

        editor.putString("task_name", task_name_value);
        editor.putBoolean("completed", false);
        editor.putInt("estimated_hours", Integer.parseInt(estimated_hours_value));
        editor.putInt("estimated_minutes", estimated_minutes_checked);
        editor.putLong("actual_time_spent", 0);
        editor.apply();

//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            public void run() {
//                finish();
//            }
//        }, 1000);

        finish();

    }

    public void onBackPressed() {
        Log.d("back", "back button pressed");
        editor.remove("task_name");
        editor.remove("completed");
        editor.remove("estimated_hours");
        editor.remove("estimated_minutes");
        editor.remove("actual_time_spent");
        editor.apply();
        super.onBackPressed();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        EditText task_name = findViewById(R.id.task_name);
//        String task_name_value = task_name.getText().toString();
//        task_name.setText(task_name_value);
    }

}
