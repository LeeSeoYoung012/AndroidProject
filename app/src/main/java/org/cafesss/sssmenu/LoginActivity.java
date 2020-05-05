package org.cafesss.sssmenu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText idText, passwordText;
    UserDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new UserDBHelper(this);
        idText = findViewById(R.id.idText);
        passwordText = findViewById(R.id.passwordText);

        Button loginButton = findViewById(R.id.loginButton);

        TextView registerButton = findViewById(R.id.registerButton);
        TextView findIDButton = findViewById(R.id.findIDButton);
        TextView findPWButton = findViewById(R.id.findPWButton);
        loginButton.setBackgroundColor(Color.WHITE);

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                String id=idText.getText().toString();
                String pw=passwordText.getText().toString();

                String managerid="manager";
                String managerpw="1234";

                Boolean chkPass = db.idpw(id, pw);

                if(id.equals(managerid)&&pw.equals(managerpw))
                {
                    Intent confirmIntent = new Intent(LoginActivity.this, ShowUserActivity.class);
                    LoginActivity.this.startActivity(confirmIntent);
                }
                else if (chkPass == true) {
                    Intent confirmIntent = new Intent(LoginActivity.this, MainActivity.class);
                    confirmIntent.putExtra("id", id);
                    LoginActivity.this.startActivity(confirmIntent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "아이디 혹은 비밀번호를 잘못 입력하셨습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        findIDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent findIDIntent = new Intent(LoginActivity.this,FindIDActivity.class);
                LoginActivity.this.startActivity(findIDIntent);
            }
        });

        findPWButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent findPWIntent = new Intent(LoginActivity.this,FindPWActivity.class);
                LoginActivity.this.startActivity(findPWIntent);
            }
        });

    }
}


