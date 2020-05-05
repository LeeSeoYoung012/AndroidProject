package org.cafesss.sssmenu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity  {
    Cursor cursor;
    private ListView listView;
    private CartListAdapter listAdapter;
    private List<Cart> cartList;
    PaymentDBHelper paymentDB;
    CartDBHelper cartDB;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        paymentDB=new PaymentDBHelper(this);
        cartDB = new CartDBHelper(this);
        TextView userName = findViewById(R.id.userName);
        userName.setText(String.format("%s",id));
        updateAllSel(id);

        listView = (ListView) findViewById(R.id.listView);
        cartList = new ArrayList<>();


        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

        final ImageView imageView= (ImageView) findViewById(R.id.imageView);

        Button buttonm = (Button) findViewById(R.id.buttonm);
        Button buttonp = (Button) findViewById(R.id.buttonp);

        Button changeButton = (Button) findViewById(R.id.changeButton);

        Button buttono = (Button) findViewById(R.id.buttono);
        Button buttond = (Button) findViewById(R.id.buttond);

        Button selectButton = (Button) findViewById(R.id.selectButton);
        Button allButton = (Button) findViewById(R.id.allButton);

        cursor = cartDB.getListContents(id);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String id, product, size;
                int price, prodnum, totalprice, pic;
                id = cursor.getString(cursor.getColumnIndex("ID"));
                product = cursor.getString(cursor.getColumnIndex("PRODUCT"));
                size = cursor.getString(cursor.getColumnIndex("SIZE"));
                price = Integer.parseInt(cursor.getString(cursor.getColumnIndex("PRICE")));
                prodnum = Integer.parseInt(cursor.getString(cursor.getColumnIndex("PRODNUM")));
                totalprice = Integer.parseInt(cursor.getString(cursor.getColumnIndex("TOTALPRICE")));
                pic = Integer.parseInt(cursor.getString(cursor.getColumnIndex("PIC")));
                cartList.add(new Cart(id, product, price, prodnum, totalprice, size, pic));
            }
        }
        listAdapter = new CartListAdapter((getApplicationContext()), cartList);
        listView.setAdapter(listAdapter);

        selectButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                Intent intent= new Intent(CartActivity.this, PaymentActivity.class);
                intent.putExtra("whichButton","s");
                intent.putExtra("id", id);
                paymentDB.delete(id);
                CartActivity.this.startActivity(intent);
            }
        });

        allButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                Intent intent= new Intent(CartActivity.this, PaymentActivity.class);
                intent.putExtra("whichButton","a");
                intent.putExtra("id", id);
                paymentDB.delete(id);
                CartActivity.this.startActivity(intent);
            }
        });

    }

    public void updateAllSel(String id)
    {
        Cursor cursor=cartDB.getListContents(id);
        while(cursor.moveToNext())
            cartDB.UpDateSel(id,cursor.getString(cursor.getColumnIndex("PRODUCT")),"n");
    }
    public void onHomeIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
        myIntent.putExtra("id", id);
        startActivity(myIntent);
    }

    public void onLogoIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
        myIntent.putExtra("id", id);
        startActivity(myIntent);
    }

    public void onMypageIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),MypageActivity.class);
        myIntent.putExtra("id", id);
        startActivity(myIntent);
    }

    public void onPaymentIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),ReceiptActivity.class);
        myIntent.putExtra("id", id);
        startActivity(myIntent);
    }

    public void onSettingIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),SettingActivity.class);
        myIntent.putExtra("id", id);
        startActivity(myIntent);
    }

}
