package org.cafesss.sssmenu;

import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PayCheckActivity extends AppCompatActivity {
    String id;
    PaymentDBHelper paymentDB;
    CartDBHelper cartDB;
    UserDBHelper userDB;
    OrderDBHelper orderDB;
    private MyArrayAdapter listAdapter;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_check);
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        paymentDB = new PaymentDBHelper(this);
        cartDB = new CartDBHelper(this);
        cartDB.delete(id);
        userDB=new UserDBHelper(this);
        userDB.ChangeDeleteToN(id);

        Cursor cursor;
        ListView listView = (ListView)findViewById(R.id.listView);
        list = new ArrayList<>();

        cursor = paymentDB.getListContents(id);

        while (cursor.moveToNext()){
            list.add(cursor.getString(cursor.getColumnIndex("PRODUCT"))+
                    "\n"+"사이즈:"+cursor.getString(cursor.getColumnIndex("SIZE"))+
                    "  수량:"+cursor.getString(cursor.getColumnIndex("PRODNUM"))+
                    "  상품가격:"+cursor.getString(cursor.getColumnIndex("PRICE"))+
                    "\n"+"총가격:"+cursor.getString(cursor.getColumnIndex("TOTALPRICE")));
        }
        listAdapter = new MyArrayAdapter((getApplicationContext()), list);
        listView.setAdapter(listAdapter);
        paymentDB.delete(id);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
                finish();
            }
        }, 10000);
    }
    public void onHomeIconClicked (View v){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onLogoIconClicked (View v){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onMypageIconClicked (View v){
        Intent myIntent = new Intent(getApplicationContext(), MypageActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onPaymentIconClicked (View v){
        Intent myIntent = new Intent(getApplicationContext(), ReceiptActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onCartIconClicked (View v){
        Intent myIntent = new Intent(getApplicationContext(), CartActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onSettingIconClicked (View v){
        Intent myIntent = new Intent(getApplicationContext(), SettingActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }
}

