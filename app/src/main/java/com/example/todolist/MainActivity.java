package com.example.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView todo_list;
    private ArrayList<String> items;
    private ArrayAdapter<String> items_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent main_intent = getIntent();

        todo_list = (ListView) findViewById(R.id.todo_list);
        items = new ArrayList<String>();
        items_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        todo_list.setAdapter(items_adapter);
//        items.add(main_intent.getStringExtra("task_name"));
//        items.add(main_intent.getStringExtra("estimated_task_length"));

        TextView display_task_name = findViewById(R.id.display_task_name);
        TextView display_estimated_task_length = findViewById(R.id.display_estimated_task_length);
//        display_task_name.setText(getTaskName(this));

        display_task_name.setText(main_intent.getStringExtra("task_name"));
        display_estimated_task_length.setText(main_intent.getStringExtra("estimated_task_length"));

        FloatingActionButton add_task = findViewById(R.id.new_task);
        add_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterTask();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static String getTaskName(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("myAppPackage", 0);
        return prefs.getString("task_name", "");

    }

    public void enterTask() {
        Intent intent = new Intent(this, enterTask.class);

        startActivity(intent);
    }



}
