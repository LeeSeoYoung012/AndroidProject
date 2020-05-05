package org.cafesss.sssmenu;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BakeryActivity extends AppCompatActivity {
    CartDBHelper cartDb;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakery);

        Intent intent=getIntent();
        id=intent.getStringExtra("id");

        cartDb = new CartDBHelper(this);
    }

    public void onAlmondCroissantClicked(View v){
        if(cartDb.chkProduct(id,"AlmondCroissant")==true) {
            cartDb.insertprodInfo(id,"AlmondCroissant", 1, 5400,R.drawable.almond_valley_croissant_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"AlmondCroissant");
            Num++;
            cartDb.UpDate(id,"AlmondCroissant",Num,Num*5400);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();

    }

    public void onBlueberryBagelClicked(View v){
        if(cartDb.chkProduct(id,"BlueberryBagel")==true) {
            cartDb.insertprodInfo(id,"BlueberryBagel", 1, 4800,R.drawable.blueberry_bagel_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"Espresso");
            Num++;
            cartDb.UpDate(id,"Espresso",Num,Num*4800);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onCheeseDanishClicked(View v){
        if(cartDb.chkProduct(id,"CheeseDanish")==true) {
            cartDb.insertprodInfo(id,"CheeseDanish", 1, 5300,R.drawable.cheese_danish_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"CheeseDanish");
            Num++;
            cartDb.UpDate(id,"CheeseDanish",Num,Num*5300);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onClassicSconeClicked(View v){
        if(cartDb.chkProduct(id,"ClassicScone")==true) {
            cartDb.insertprodInfo(id,"ClassicScone", 1, 4500,R.drawable.classic_scone_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"ClassicScone");
            Num++;
            cartDb.UpDate(id,"ClassicScone",Num,Num*4500);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onChocolateMuffinClicked(View v){
        if(cartDb.chkProduct(id,"ChocolateMuffin")==true) {
            cartDb.insertprodInfo(id,"ChocolateMuffin", 1, 3800,R.drawable.dark_chocolate_chip_muffin_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"ChocolateMuffin");
            Num++;
            cartDb.UpDate(id,"ChocolateMuffin",Num,Num*3800);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onLeafPieClicked(View v){
        if(cartDb.chkProduct(id,"LeafPie")==true) {
            cartDb.insertprodInfo(id,"LeafPie", 1, 4200,R.drawable.leaf_pie_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"LeafPie");
            Num++;
            cartDb.UpDate(id,"LeafPie",Num,Num*4200);
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
