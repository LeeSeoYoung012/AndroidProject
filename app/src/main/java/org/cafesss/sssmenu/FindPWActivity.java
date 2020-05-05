package org.cafesss.sssmenu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FindPWActivity extends AppCompatActivity {
    UserDBHelper db;
    EditText phoneNumText, idText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pw);

        db= new UserDBHelper(this);
        phoneNumText = (EditText) findViewById(R.id.phoneNumText);
        idText = (EditText) findViewById(R.id.IDText);

        TextView notification = (TextView) findViewById(R.id.notification);
        TextView notification2 = (TextView) findViewById(R.id.notification2);
        Button confirmButton = (Button) findViewById(R.id.confirmButton);
        confirmButton.setBackgroundColor(Color.rgb(88,225,235));

        confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String id = idText.getText().toString();
                String phone = phoneNumText.getText().toString();
                String chkPass = db.findpw(id, phone);
                if (chkPass =="") {
                    Toast.makeText(getApplicationContext(), "입력한 정보에 맞는 사용자가 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent confirmIntent = new Intent(FindPWActivity.this, ShowPWActivity.class);
                    confirmIntent.putExtra("pw", chkPass);
                    FindPWActivity.this.startActivity(confirmIntent);
                }

            }
        });
    }
}