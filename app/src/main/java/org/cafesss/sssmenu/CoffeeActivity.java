package org.cafesss.sssmenu;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CoffeeActivity extends AppCompatActivity {

    CartDBHelper cartDb;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        cartDb = new CartDBHelper(this);
    }

    public void onAmericanoClicked(View v){
        if(cartDb.chkProduct(id,"Americano")==true) {
            cartDb.insertprodInfo(id,"Americano", 1, 4100,R.drawable.americano_s );
        }
        else {
            int Num=cartDb.findProdNum(id,"Americano");
            Num++;
            cartDb.UpDate(id,"Americano",Num,Num*4100);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onCaffeLatteClicked(View v){
        if(cartDb.chkProduct(id,"CaffeLatte")==true) {
            cartDb.insertprodInfo(id,"CaffeLatte", 1, 4300,R.drawable.caffe_latte_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"CaffeLatte");
            Num++;
            cartDb.UpDate(id,"CaffeLatte",Num,Num*4300);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onCaffeMochaClicked(View v){
        if(cartDb.chkProduct(id,"CaffeMocha")==true) {
            cartDb.insertprodInfo(id,"CaffeMocha", 1, 4500,R.drawable.caffe_mocha_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"CaffeMocha");
            Num++;
            cartDb.UpDate(id,"CaffeMocha",Num,Num*4500);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onCappuccinoClicked(View v){
        if(cartDb.chkProduct(id,"Cappuccino")==true) {
            cartDb.insertprodInfo(id,"Cappuccino", 1, 4300,R.drawable.cappuccino_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"Cappuccino");
            Num++;
            cartDb.UpDate(id,"Cappuccino",Num,Num*4300);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onMacchiatoClicked(View v){
        if(cartDb.chkProduct(id,"Macchiato")==true) {
            cartDb.insertprodInfo(id,"Macchiato", 1, 4500,R.drawable.caramel_macchiato_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"Macchiato");
            Num++;
            cartDb.UpDate(id,"Macchiato",Num,Num*4500);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onEspressoClicked(View v){
        if(cartDb.chkProduct(id,"Espresso")==true) {
            cartDb.insertprodInfo(id,"Espresso", 1, 3900,R.drawable.espresso_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"Espresso");
            Num++;
            cartDb.UpDate(id,"Espresso",Num,Num*3900);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
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

    public void onCartIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),CartActivity.class);
        myIntent.putExtra("id", id);
        startActivity(myIntent);
    }

    public void onSettingIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),SettingActivity.class);
        myIntent.putExtra("id", id);
        startActivity(myIntent);
    }

    public void Onclick(View v){
        Intent myIntent = new Intent(getApplicationContext(),CartActivity.class);
        myIntent.putExtra("id", id);
        startActivity(myIntent);
    }
}
