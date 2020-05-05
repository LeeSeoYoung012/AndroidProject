package org.cafesss.sssmenu;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaymentActivity extends AppCompatActivity {
    String id, whichButton;
    PaymentDBHelper paymentDB;
    CartDBHelper cartDB;
    OrderDBHelper orderDB;
    UserDBHelper userDB;
    int nowpoint;
    int tot;
    Cursor cursor;
    private MyArrayAdapter listAdapter;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView now=(TextView)findViewById(R.id.now);
        TextView after=(TextView)findViewById(R.id.after);
        TextView total=(TextView)findViewById(R.id.total);
        Button button1=(Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        paymentDB = new PaymentDBHelper(this);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        userDB = new UserDBHelper(this);
        cartDB = new CartDBHelper(this);
        orderDB = new OrderDBHelper(this);

        whichButton = intent.getStringExtra("whichButton");
        tot = 0;

        switch (whichButton) {
            case "a":
                cursor = cartDB.getListContents(id);
                inputtopay(cursor);
                break;
            case "s":
                cursor = cartDB.getSelListContents(id);
                inputtopay(cursor);
                break;
            case "o":
                String product = intent.getStringExtra("payproduct");
                paymentDB.Insert(id, product, cartDB.findProdNum(id, product),
                        cartDB.findPrice(id, product), cartDB.findSize(id, product), getTime());
                tot = cartDB.findTotalPrice(id, product);
                break;
        }
        nowpoint=userDB.findpoint(id);

        now.setText(String.format("%d Point", nowpoint));
        total.setText(String.format("%d Point",tot));
        after.setText(String.format("%d Point",nowpoint-tot));

        ListView listView = (ListView)findViewById(R.id.listView);
        list = new ArrayList<>();

        cursor = paymentDB.getListContents(id);

        while (cursor.moveToNext()){
            list.add(cursor.getString(cursor.getColumnIndex("PRODUCT"))+
                    "\n"+"사이즈:"+cursor.getString(cursor.getColumnIndex("SIZE"))+
                    "  수량:"+cursor.getString(cursor.getColumnIndex("PRODNUM"))+
                    "  상품가격:"+cursor.getString(cursor.getColumnIndex("PRICE"))+
                    "\n"+"총가격:"+cursor.getString(cursor.getColumnIndex("TOTALPRICE")));
        }
        listAdapter = new MyArrayAdapter((getApplicationContext()), list);
        listView.setAdapter(listAdapter);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(PaymentActivity.this, CartActivity.class);
                myIntent.putExtra("id",id);
                startActivity(myIntent);
            }//취소하기 눌렀을 때 전환할 화면,이동될 화면
        });

        button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Cursor cursor=paymentDB.getListContents(id);
                    if (cursor.getCount() == 0) {
                        Toast.makeText(getApplicationContext(), "에러! 장바구니가 비었습니다", Toast.LENGTH_SHORT).show();
                        return;
                    }
                   else if(nowpoint<tot){
                       Toast.makeText(PaymentActivity.this,"포인트가 부족합니다",Toast.LENGTH_SHORT).show();
                   }
                   else {
                       Intent myIntent = new Intent(PaymentActivity.this, PayCheckActivity.class);
                       userDB.setpoint(id,-tot);
                       copyPayToOrder();
                       myIntent.putExtra("id", id);
                       startActivity(myIntent);
                   }
                }//결제하기 눌렀을 때 전환할 화면,이동될 화면
            });
        }
            public void inputtopay(Cursor cursor) {
                String formatDate = getTime();
                if (cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        paymentDB.Insert(cursor.getString(cursor.getColumnIndex("ID")), cursor.getString(cursor.getColumnIndex("PRODUCT")),
                                cursor.getInt(cursor.getColumnIndex("PRODNUM")), cursor.getInt(cursor.getColumnIndex("PRICE")),
                                cursor.getString(cursor.getColumnIndex("SIZE")), formatDate);
                        tot += cursor.getInt(cursor.getColumnIndex("TOTALPRICE"));
                    }
                }

            }

            public String getTime() {
                long now = System.currentTimeMillis();
                Date date = new Date(now);
                SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String formatDate = sdfNow.format(date);
                return formatDate;
            }

            public void copyPayToOrder() {
                cursor = paymentDB.getListContents(id);
                if (cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        String product, size, ordertime;
                        int price, prodnum;
                        product = cursor.getString(cursor.getColumnIndex("PRODUCT"));
                        size = cursor.getString(cursor.getColumnIndex("SIZE"));
                        price = Integer.parseInt(cursor.getString(cursor.getColumnIndex("PRICE")));
                        prodnum = Integer.parseInt(cursor.getString(cursor.getColumnIndex("PRODNUM")));
                        ordertime = cursor.getString(cursor.getColumnIndex("ORDERTIME"));
                        orderDB.Insert(id, product, prodnum, price, size, ordertime);
                    }
                }
            }

            public void onHomeIconClicked(View v) {
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                myIntent.putExtra("id", id);
                startActivity(myIntent);
            }

            public void onLogoIconClicked(View v) {
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                myIntent.putExtra("id", id);
                startActivity(myIntent);
            }

            public void onMypageIconClicked(View v) {
                Intent myIntent = new Intent(getApplicationContext(), MypageActivity.class);
                myIntent.putExtra("id", id);
                startActivity(myIntent);
            }

            public void onPaymentIconClicked(View v) {
                Intent myIntent = new Intent(getApplicationContext(), ReceiptActivity.class);
                myIntent.putExtra("id", id);
                startActivity(myIntent);
            }

            public void onCartIconClicked(View v) {
                Intent myIntent = new Intent(getApplicationContext(), CartActivity.class);
                myIntent.putExtra("id", id);
                startActivity(myIntent);
            }

            public void onSettingIconClicked(View v) {
                Intent myIntent = new Intent(getApplicationContext(), SettingActivity.class);
                myIntent.putExtra("id", id);
                startActivity(myIntent);
            }
    }
