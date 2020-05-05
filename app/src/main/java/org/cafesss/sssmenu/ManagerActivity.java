package org.cafesss.sssmenu;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ManagerActivity extends AppCompatActivity {
    OrderDBHelper orderDB;
    UserDBHelper userDB;
    List<User> userList;
    ListView listView;
    ManagerItemAdapter listAdapter;
    List<Order> orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        Button userListButton = (Button) findViewById(R.id.userListButton);
        FloatingActionButton showButton = (FloatingActionButton) findViewById(R.id.showButton);

        userListButton.setBackgroundColor(Color.rgb(88, 225, 235));
        userListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagerActivity.this, ShowUserActivity.class);
                ManagerActivity.this.startActivity(intent);
            }
        });

        listView = (ListView) findViewById(R.id.listView);

        userList = new ArrayList<>();

        orderDB = new OrderDBHelper(this);
        userDB = new UserDBHelper(this);

        Cursor cursor = userDB.ndgetListContents();

        String userId = null;
        String name, phone;

        if (cursor.getCount() == 0) {
        } else {
            while (cursor.moveToNext()) {
                userId = cursor.getString(cursor.getColumnIndex("userId"));
                name = cursor.getString(cursor.getColumnIndex("userName"));
                phone = cursor.getString(cursor.getColumnIndex("userPhone"));
                userList.add(new User(userId, name, phone));
            }
        }
        listAdapter = new ManagerItemAdapter(getApplicationContext(), userList);
        listView.setAdapter(listAdapter);
    }
}

