package org.cafesss.sssmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WaitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);
        Handler handler = new Handler();
        Intent intent=getIntent();
        final String id=intent.getStringExtra("id");

        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent intent = new Intent(WaitActivity.this,CartActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                finish();
            }
        },0);
    }
}
