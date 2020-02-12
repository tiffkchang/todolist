package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class enterTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_task);

        EditText task_name = (EditText) findViewById(R.id.task_name);
        String task_name_value = task_name.getText().toString();
        task_name.setText(task_name_value);


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
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("myAppPackage", 0);
        SharedPreferences.Editor editor = prefs.edit();

        EditText task_name = (EditText) findViewById(R.id.task_name);
        String task_name_value = task_name.getText().toString();
        //intent.putExtra("task_name", task_name_value);
        editor.putString("task_name", task_name_value);

        EditText estimated_task_length = (EditText) findViewById(R.id.estimated_task_length);
        String estimated_task_length_value = estimated_task_length.getText().toString();
/*        DateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
        try {
            Date date = formatter.parse(estimated_task_length_value);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        editor.putString("estimated_task_length", estimated_task_length_value);
        editor.apply();

        finish();

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        EditText task_name = findViewById(R.id.task_name);
        String task_name_value = task_name.getText().toString();
        task_name.setText(task_name_value);
    }

}
