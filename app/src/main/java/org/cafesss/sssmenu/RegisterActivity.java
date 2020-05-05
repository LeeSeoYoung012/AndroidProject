package org.cafesss.sssmenu;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;


public class RegisterActivity extends AppCompatActivity {
    EditText idText, passwordText, nameText, ageText, phoneNumText;
    UserDBHelper db;
    Socket socket;
    String id,pw,name,age,phone;

    //String id,pw,name,age,phone;
    ArrayList<String> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new UserDBHelper(this);
        setContentView(R.layout.activity_register);
        idText = (EditText) findViewById(R.id.idText);
        passwordText = (EditText) findViewById(R.id.passwordText);
        nameText = (EditText) findViewById(R.id.nameText);
        ageText = (EditText) findViewById(R.id.ageText);
        phoneNumText = (EditText) findViewById(R.id.phoneNumText);
        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setBackgroundColor(Color.rgb(88, 225, 235));
    }

    public void onClick(View v) {
         id = idText.getText().toString();
         pw = passwordText.getText().toString();
         name = nameText.getText().toString();
         age = ageText.getText().toString();
         phone = phoneNumText.getText().toString();
         user.add(id);
         user.add(pw);

        if (id.equals("") || pw.equals("") || name.equals("") || age.equals("") || phone.equals("")) {
            Toast.makeText(getApplicationContext(), "입력란이 비어있습니다", Toast.LENGTH_SHORT).show();
        } else {
            Boolean chkId = db.chkId(id);
            Boolean chkUser = db.ChkUser(name, phone);
            if (chkUser == true) {
                if (chkId == true) {
                    Boolean insert = db.insert(id, pw, name, age, phone);
                    if (insert == true) {
                        Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        if (socket == null) {
                            ConnectionThread connection = new ConnectionThread();
                            connection.start();
                            }
                            RegisterActivity.this.startActivity(intent);

                    } else {
                        Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "아이디가 이미 존재합니다", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "이미 존재하는 사용자입니다", Toast.LENGTH_SHORT).show();
            }

        }
        }
    class ConnectionThread extends Thread {
        public void run() {
            try {
                Socket socket = new Socket("169.254.113.118/16", 3000);
                OutputStream os = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}