package org.cafesss.sssmenu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FindIDActivity extends Activity {
    UserDBHelper db;
    EditText ageText,phoneNumText,nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id);

        db=new UserDBHelper(this);
        ageText = (EditText) findViewById(R.id.ageText);
        phoneNumText = (EditText) findViewById(R.id.phoneNumText);
        nameText = (EditText) findViewById(R.id.nameText);
        TextView notification = (TextView) findViewById(R.id.notification);
        TextView notification2 = (TextView) findViewById(R.id.notification2);
        Button confirmButton = (Button) findViewById(R.id.confirmButton);
        confirmButton.setBackgroundColor(Color.rgb(88,225,235));


        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String age = ageText.getText().toString();
                String phone = phoneNumText.getText().toString();
                String name = nameText.getText().toString();

                String chkPass = db.findid(name, phone, age);
                if (chkPass == "") {
                    Toast.makeText(getApplicationContext(), "입력한 정보에 맞는 사용자가 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent confirmIntent = new Intent(FindIDActivity.this, ShowIDActivity.class);
                    confirmIntent.putExtra("id", chkPass);
                    FindIDActivity.this.startActivity(confirmIntent);
                }

            }
        });
    }
}
