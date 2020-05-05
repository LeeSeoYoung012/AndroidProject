package org.cafesss.sssmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TeaActivity extends AppCompatActivity {
    String id;
    CartDBHelper cartDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea);
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        cartDb = new CartDBHelper(this);
    }

    public void onChaiClicked(View v){
        if(cartDb.chkProduct(id,"Chai")==true) {
            cartDb.insertprodInfo(id,"Chai", 1, 4300,R.drawable.chai_brewed_tea_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"Chai");
            Num++;
            cartDb.UpDate(id,"Chai",Num,Num*4300);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onChamomileClicked(View v){
        if(cartDb.chkProduct(id,"Chamomile")==true) {
            cartDb.insertprodInfo(id,"Chamomile", 1, 4500,R.drawable.chamomile_blend_brewed_tea_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"Chamomile");
            Num++;
            cartDb.UpDate(id,"Chamomile",Num,Num*4500);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onEarlgreyClicked(View v){
        if(cartDb.chkProduct(id,"Earlgrey")==true) {
            cartDb.insertprodInfo(id,"Earlgrey", 1, 4100,R.drawable.earl_grey_brewed_tea_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"Earlgrey");
            Num++;
            cartDb.UpDate(id,"Earlgrey",Num,Num*4100);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onGrapefruitClicked(View v){
        if(cartDb.chkProduct(id,"Grapefruit")==true) {
            cartDb.insertprodInfo(id,"Grapefruit", 1, 4500,R.drawable.grapefruit_honey_black_tea_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"Grapefruit");
            Num++;
            cartDb.UpDate(id,"Grapefruit",Num,Num*4500);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onGreenClicked(View v){
        if(cartDb.chkProduct(id,"Green")==true) {
            cartDb.insertprodInfo(id,"Green", 1, 4900,R.drawable.jeju_organic_green_tea_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"Green");
            Num++;
            cartDb.UpDate(id,"Green",Num,Num*4900);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onMintClicked(View v){
        if(cartDb.chkProduct(id,"onMint")==true) {
            cartDb.insertprodInfo(id,"onMint", 1, 4100,R.drawable.mint_blend_brewed_tea_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"onMint");
            Num++;
            cartDb.UpDate(id,"onMint",Num,Num*4100);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onHomeIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onLogoIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onMypageIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),MypageActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onPaymentIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),ReceiptActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onCartIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),CartActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void onSettingIconClicked(View v){
        Intent myIntent = new Intent(getApplicationContext(),SettingActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }

    public void Onclick(View v){
        Intent myIntent = new Intent(getApplicationContext(),CartActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
    }
}
