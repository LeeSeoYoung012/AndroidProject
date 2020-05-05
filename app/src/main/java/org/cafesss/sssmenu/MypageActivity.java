package org.cafesss.sssmenu;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MypageActivity extends AppCompatActivity {
    String id, pw, name, age, phone;
    int point;
    UserDBHelper db;
    Cursor cursor;
    private List<User> userList;

    PaymentDBHelper paymentDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
        paymentDB = new PaymentDBHelper(this);
        userList = new ArrayList<>();
        db = new UserDBHelper(this);
        Intent myIntent = getIntent();

        id = myIntent.getStringExtra("id");

        Cursor cursor = db.getpersonInfo(id);
        if (cursor.getCount() == 0) {
        } else {
            while (cursor.moveToNext()) {
                id = cursor.getString(cursor.getColumnIndex("userId"));
                pw = cursor.getString(cursor.getColumnIndex("userPw"));
                name = cursor.getString(cursor.getColumnIndex("userName"));
                age = cursor.getString(cursor.getColumnIndex("userAge"));
                phone = cursor.getString(cursor.getColumnIndex("userPhone"));
                point = cursor.getInt(cursor.getColumnIndex("userPoint"));
                userList.add(new User(id, pw, name, age, phone, point));
            }
        }

        TextView idText = (TextView)findViewById(R.id.idText);
        TextView pwText = (TextView)findViewById(R.id.pwText);
        TextView nameText = (TextView)findViewById(R.id.nameText);
        TextView ageText = (TextView)findViewById(R.id.ageText);
        TextView phoneText = (TextView)findViewById(R.id.phoneText);
        TextView pointText = (TextView)findViewById(R.id.pointText);

        idText.setText(String.format(id));
        pwText.setText(String.format(pw));
        nameText.setText(String.format(name));
        ageText.setText(String.format(age));
        phoneText.setText(String.format(phone));
        pointText.setText(point+"point");

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

    public void onPaymentIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),ReceiptActivity.class);
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

    public void onChangePWClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),ChangePWActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onPointClicked(View v){
        Toast.makeText(getApplicationContext(), "직원에게 문의하세요.", Toast.LENGTH_SHORT).show();
    }
}
