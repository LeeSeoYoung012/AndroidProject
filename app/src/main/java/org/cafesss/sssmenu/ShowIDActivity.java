package org.cafesss.sssmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowIDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        String editText=intent.getStringExtra("id");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_id);
        Button backButton = (Button) findViewById(R.id.backButton);
        TextView idText = (TextView) findViewById(R.id.idText);
        TextView welcomeMessage = (TextView) findViewById(R.id.welcomeMessage);
        TextView realID = (TextView) findViewById(R.id.realID);
        realID.setText(editText);
        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                Intent confirmIntent = new Intent(ShowIDActivity.this, LoginActivity.class);
                ShowIDActivity.this.startActivity(confirmIntent);
            }
        });
    }

}