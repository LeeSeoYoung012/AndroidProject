package org.cafesss.sssmenu;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChangePWActivity extends AppCompatActivity {
    String id, pw, now,ch, checkch;
    UserDBHelper db;
    Cursor cursor;
    EditText nowPW, newPW, chkPW;
    private List<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pw);
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
                userList.add(new User(id, pw));
            }
        }

        nowPW = (EditText)findViewById(R.id.nowPW);
        newPW = (EditText)findViewById(R.id.newPW);
        chkPW = (EditText)findViewById(R.id.chkPW);

    }

    public void onClicked(View v){
        now = nowPW.getText().toString();
        ch = newPW.getText().toString();
        checkch = chkPW.getText().toString();

        if(!pw.equals(now)){
            Toast.makeText(getApplicationContext(), "현재 비밀번호가 틀립니다.", Toast.LENGTH_SHORT).show();
        }
        else {
            if(!ch.equals(checkch)){
                Toast.makeText(getApplicationContext(), "새 비밀번호가 서로 다릅니다.", Toast.LENGTH_SHORT).show();

            }else {
                SQLiteDatabase userdb = db.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("userPw",ch);
                userdb.update("tb_user",contentValues,"userId=?",new String[]{id});
                Toast.makeText(getApplicationContext(), "비밀번호가 변경되었습니다.", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(getApplicationContext(), MypageActivity.class);
                myIntent.putExtra("id",id);
                startActivity(myIntent);
            }
        }
    }

}
