package org.cafesss.sssmenu;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ReceiptActivity extends AppCompatActivity {
    String id;
    OrderDBHelper orderDB;
    List<String> orderList;
    ListView listView;
    ReceiptArrayAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        ListView listView = (ListView) findViewById(R.id.listView);

        orderList = new ArrayList<>();

        orderDB = new OrderDBHelper(this);

        Cursor cursor = orderDB.getListContents(id);
        cursor.moveToNext();
        orderList.add(cursor.getString(cursor.getColumnIndex("ORDEREDTIME")));
        while (cursor.moveToNext()) {
                String time = cursor.getString(cursor.getColumnIndex("ORDEREDTIME"));
                if (orderList.get(orderList.size()-1).equals(time)) {
                    continue;
                }
                 else {
                    orderList.add(cursor.getString(cursor.getColumnIndex("ORDEREDTIME")));
                }
            }

        listAdapter = new ReceiptArrayAdapter(getApplicationContext(), orderList,id);
        listView.setAdapter(listAdapter);

    }


    public void onHomeIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onLogoIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onMypageIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),MypageActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onCartIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),CartActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onSettingIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),SettingActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

}
