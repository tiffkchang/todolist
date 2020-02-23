package com.example.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RecyclerView todo_list;
    private ArrayList<String> items;
    private ArrayAdapter<String> items_adapter;
    private ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent main_intent = getIntent();

//        EditText et = findViewById(R.id.estimated_task_length);
//        et.setInputType(InputType.TYPE_CLASS_NUMBER);

//        todo_list = (ListView) findViewById(R.id.todo_list);
//        items = new ArrayList<String>();
//        items_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

//        ArrayList<Task> tasks = new ArrayList<>();
//        tasks.add(new Task("first task", 30));
//
//        TaskListAdapter adapt = new TaskListAdapter(this, R.layout.list_item, tasks);
//        todo_list.setAdapter(adapt);

//        todo_list.setAdapter(items_adapter);



//        TextView display_task_name = findViewById(R.id.display_task_name);
//        TextView display_estimated_task_length = findViewById(R.id.display_estimated_task_length);
//        display_task_name.setText(getTaskName(this));
//
//        display_task_name.setText(main_intent.getStringExtra("task_name"));
//        display_estimated_task_length.setText(main_intent.getStringExtra("estimated_task_length"));

        FloatingActionButton add_task = findViewById(R.id.new_task);
        add_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterTask();
            }
        });

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        tasks = new ArrayList<>();
        todo_list = (RecyclerView) findViewById(R.id.todo_list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        todo_list.setLayoutManager(layoutManager);

        TaskListAdapter adapt = new TaskListAdapter(this, tasks);
        todo_list.setAdapter(adapt);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteCallback(adapt));
        itemTouchHelper.attachToRecyclerView(todo_list);
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

    @Override
    protected void onActivityResult(int rq, int rc, Intent data) {
        Log.d("ADDTASK", "HERE");
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("myAppPackage", 0);

        String task_name = prefs.getString("task_name", "no name");
        int estimated_hours = prefs.getInt("estimated_hours", 0);
        int estimated_minutes = prefs.getInt("estimated_minutes", 0);

        Log.d("RESULT","TASK NAME: " + task_name);


        tasks.add(new Task(task_name, estimated_hours, estimated_minutes));


//        List<HashMap<String, String>> listItems = new ArrayList<>();
//        ArrayAdapter<HashMap<String, String>> adapter = new ArrayAdapter(this, R.layout.list_item, R.id.text1, listItems);
//
//
//        if (task_name != null && estimated_task_length != null) {
//            HashMap<String, String> resultsMap = new HashMap<>();
//            resultsMap.put("First line", task_name);
//            resultsMap.put("Second line", estimated_task_length);
//            listItems.add(resultsMap);
//        }
//        todo_list.setAdapter(adapter);

//        if (task_name != null) {
//            items_adapter.add(task_name);
//        }
//        if (estimated_task_length!= null) {
//            items_adapter.add(estimated_task_length);
//        }
    }

    public static String getTaskName(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("myAppPackage", 0);
        return prefs.getString("task_name", "");

    }

    public void enterTask() {
        Intent intent = new Intent(this, enterTask.class);

        Log.d("START", "START ACTIVITY");
        startActivityForResult(intent, 0);
    }



}
