package org.cafesss.sssmenu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

        String id;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_setting);
            Intent intent=getIntent();
            id=intent.getStringExtra("id");
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

        public void onCallClicked(View v){
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:1588-0424"));
            myIntent.putExtra("id",id);
            startActivity(myIntent);
        }
        public void onUpdateClicked(View v){
            Toast.makeText(getApplicationContext(),"최신 버전입니다.",Toast.LENGTH_SHORT).show();
        }
    }
