package org.cafesss.sssmenu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent=getIntent();
        id=intent.getStringExtra("id");

    }

    public void onCoffeeClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),CoffeeActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onFrappuccinoClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),FrappuccinoActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onBlendedClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),BlendedActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onTeaClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),TeaActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onBakeryClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),BakeryActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onAllClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),AllActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
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

    public void Onclick(View v){
        Intent myIntent = new Intent(getApplicationContext(),CartActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }
}
