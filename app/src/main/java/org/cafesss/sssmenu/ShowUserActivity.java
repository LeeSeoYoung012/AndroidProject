package org.cafesss.sssmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShowUserActivity extends AppCompatActivity {
    UserDBHelper db;
    Cursor cursor;
    private ListView listView;
    private UserListAdapter listAdapter;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);

        listView = (ListView) findViewById(R.id.listView);
        userList = new ArrayList<>();
        db = new UserDBHelper(this);


        Button orderListButton = (Button) findViewById(R.id.orderListButton);
        orderListButton.setBackgroundColor(Color.rgb(88, 225, 235));

        FloatingActionButton floatingActionButton2=(FloatingActionButton)findViewById(R.id.floatingActionButton2) ;

        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowUserActivity.this, LoginActivity.class);
                ShowUserActivity.this.startActivity(intent);
            }
        });

        orderListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowUserActivity.this, ManagerActivity.class);
                ShowUserActivity.this.startActivity(intent);
            }
        });

        Cursor cursor = db.getListContents();
        if (cursor.getCount() == 0) {
        } else {
            while (cursor.moveToNext()) {
                String id, pw, name, age, phone;
                id = cursor.getString(cursor.getColumnIndex("userId"));
                pw = cursor.getString(cursor.getColumnIndex("userPw"));
                name = cursor.getString(cursor.getColumnIndex("userName"));
                age = cursor.getString(cursor.getColumnIndex("userAge"));
                phone = cursor.getString(cursor.getColumnIndex("userPhone"));
                userList.add(new User(id, pw, name, age, phone));
            }
        }


        listAdapter = new UserListAdapter((getApplicationContext()), userList);
        listView.setAdapter(listAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showPoint(userList.get(position),position);
            }
        });

    }

    public void showPoint(final User user, final int index)
    {
        final Dialog dialog=new Dialog(ShowUserActivity.this);

        dialog.setTitle("Point");
        dialog.setContentView(R.layout.point);
        TextView point=(TextView)dialog.findViewById(R.id.point);
        final EditText txtinput=(EditText)dialog.findViewById(R.id.txtinput);

        int p= db.setpoint(user.getId(), 0);
        userList.get(index).setPoint(p);
        point.setText(p+"Point");

        Button button=(Button)dialog.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String input = txtinput.getText().toString();
                if (input.equals("")) {
                } else {
                    int p = db.setpoint(user.getId(), Integer.parseInt(input));
                    userList.get(index).setPoint(p);
                    listAdapter.notifyDataSetChanged();
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}





