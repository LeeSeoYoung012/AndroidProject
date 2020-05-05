package org.cafesss.sssmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FrappuccinoActivity extends AppCompatActivity {

    String id;
    CartDBHelper cartDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frappuccino);
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        cartDb = new CartDBHelper(this);
    }

    public void onEspressoFClicked(View v){
        if(cartDb.chkProduct(id,"EspressoF")==true) {
            cartDb.insertprodInfo(id,"EspressoF", 1, 5300,R.drawable.espresso_frappuccino_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"EspressoF");
            Num++;
            cartDb.UpDate(id,"EspressoF",Num,Num*5300);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onGreenFClicked(View v){
        if(cartDb.chkProduct(id,"GreenF")==true) {
            cartDb.insertprodInfo(id,"GreenF", 1, 5700,R.drawable.green_tea_cream_frappuccino_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"GreenF");
            Num++;
            cartDb.UpDate(id,"GreenF",Num,Num*5700);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onJavaFClicked(View v){
        if(cartDb.chkProduct(id,"JavaF")==true) {
            cartDb.insertprodInfo(id,"JavaF", 1, 6100,R.drawable.java_chip_frappuccino_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"JavaF");
            Num++;
            cartDb.UpDate(id,"JavaF",Num,Num*6100);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onMochaFClicked(View v){
        if(cartDb.chkProduct(id,"MochaF")==true) {
            cartDb.insertprodInfo(id,"MochaF", 1, 5900,R.drawable.mocha_frappuccino_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"MochaF");
            Num++;
            cartDb.UpDate(id,"MochaF",Num,Num*5900);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onStrawberriesFClicked(View v){
        if(cartDb.chkProduct(id,"StrawberriesF")==true) {
            cartDb.insertprodInfo(id,"StrawberriesF", 1, 6500,R.drawable.strawberries_frappuccino_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"StrawberriesF");
            Num++;
            cartDb.UpDate(id,"StrawberriesF",Num,Num*6500);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onVanillaFClicked(View v){
        if(cartDb.chkProduct(id,"VanillaF")==true) {
            cartDb.insertprodInfo(id,"VanillaF", 1, 5900,R.drawable.vanilla_cream_frappuccino_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"VanillaF");
            Num++;
            cartDb.UpDate(id,"VanillaF",Num,Num*5900);
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
