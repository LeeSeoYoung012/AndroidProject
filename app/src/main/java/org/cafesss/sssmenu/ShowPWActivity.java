package org.cafesss.sssmenu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShowPWActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();

        String editText=intent.getStringExtra("pw");
        setContentView(R.layout.activity_show_pw);
        Button backButton=(Button)findViewById(R.id.backButton);
        TextView pwText = (TextView)findViewById(R.id.passwordText);
        TextView welcomeMessage = (TextView)findViewById(R.id.welcomeMessage);
        TextView realPW = (TextView)findViewById(R.id.realPW);
        realPW.setText(editText);

        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                Intent confirmIntent = new Intent(ShowPWActivity.this, LoginActivity.class);
                ShowPWActivity.this.startActivity(confirmIntent);
            }
        });
    }



}

