package org.cafesss.sssmenu;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String id;
    UserDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        db=new UserDBHelper(this);
        TextView point=(TextView)findViewById(R.id.point);
        point.setText(String.format("%d",db.findpoint(id)));
        TextView userName = findViewById(R.id.userName);
        userName.setText(String.format("%s",id));
    }

    public void onOrderClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),MenuActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onMypageIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),MypageActivity.class);
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

    public void onPointClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),MypageActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onLocationClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),LocationActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void OnLogoutClicked(View v){
        Toast.makeText(getApplicationContext(),"로그아웃 되었습니다.",Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(myIntent);
        myIntent.putExtra("id",id);
    }

}
