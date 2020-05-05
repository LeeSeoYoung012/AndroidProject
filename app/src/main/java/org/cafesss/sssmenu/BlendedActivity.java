package org.cafesss.sssmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BlendedActivity extends AppCompatActivity {

    CartDBHelper cartDb;
    UserDBHelper userDb;
    LoginActivity login;

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        cartDb = new CartDBHelper(this);
        userDb = new UserDBHelper(this);

        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        id=intent.getStringExtra("id");

        setContentView(R.layout.activity_blended);
    }

    public void onAvocadoClicked(View v) {

        if(cartDb.chkProduct(id,"Avocado")==true) {
            cartDb.insertprodInfo(id,"Avocado", 1, 5900,R.drawable.avocado_blended_s);
        }
        else {
            int AvocadoNum=cartDb.findProdNum(id,"Avocado");
            AvocadoNum++;
            cartDb.UpDate(id,"Avocado",AvocadoNum,AvocadoNum*5900);
        }
        Toast.makeText(getApplicationContext(), "해당 상품을 장바구니에 담았습니다.", Toast.LENGTH_SHORT).show();

    }

    public void onChchoBananaClicked(View v) {


        if( cartDb.chkProduct(id,"ChchoBanana")==true) {
            cartDb.insertprodInfo(id, "ChchoBanana",  1, 6100,R.drawable.chocolate_banana_blended_s);
        }
        else {
            int ChchoBananaNum=cartDb.findProdNum(id,"ChchoBanana");
            ChchoBananaNum++;
            cartDb.UpDate(id,"ChchoBanana", ChchoBananaNum, ChchoBananaNum*6100);
        }

        Toast.makeText(getApplicationContext(), "해당 상품을 장바구니에 담았습니다.", Toast.LENGTH_SHORT).show();

    }

    public void onGreanBananaClicked(View v) {


        if( cartDb.chkProduct(id,"GreanBanana")==true) {
            cartDb.insertprodInfo( id,"GreanBanana",  1, 6100,R.drawable.green_tea_banana_blended_s);
        }
        else {
            int GreanBananaNum = cartDb.findProdNum(id,"GreanBanana");
            GreanBananaNum++;
            cartDb.UpDate(id,"GreanBanana", GreanBananaNum, GreanBananaNum*6100);
        }

        Toast.makeText(getApplicationContext(), "해당 상품을 장바구니에 담았습니다.", Toast.LENGTH_SHORT).show();

    }

    public void onMangoBananaClicked(View v) {


        if( cartDb.chkProduct(id,"MangoBanana")==true) {
            cartDb.insertprodInfo( id,"MangoBanana",  1, 6300,R.drawable.mango_banana_blended_s);
        }
        else {
            int MangoBananaNum = cartDb.findProdNum(id,"MangoBanana");
            MangoBananaNum++;
            cartDb.UpDate(id,"MangoBanana",  MangoBananaNum,  MangoBananaNum*6300);
        }

        Toast.makeText(getApplicationContext(), "해당 상품을 장바구니에 담았습니다.", Toast.LENGTH_SHORT).show();

    }

    public void onStrawberryPeachClicked(View v){

        if(cartDb.chkProduct(id,"StrawberryPeach")==true) {
            cartDb.insertprodInfo( id,"StrawberryPeach",  1, 6500,R.drawable.strawberry_peach_blended_s);
        }
        else {
            int StrawberryPeachNum  = cartDb.findProdNum(id,"StrawberryPeach");
            StrawberryPeachNum++;
            cartDb.UpDate(id,"StrawberryPeach", StrawberryPeachNum,  StrawberryPeachNum*6500);
        }


        Toast.makeText(getApplicationContext(), "해당 상품을 장바구니에 담았습니다.", Toast.LENGTH_SHORT).show();

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
