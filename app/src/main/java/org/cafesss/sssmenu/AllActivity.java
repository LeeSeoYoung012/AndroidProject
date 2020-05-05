package org.cafesss.sssmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AllActivity extends AppCompatActivity {
    CartDBHelper cartDb;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        Intent intent=getIntent();
        id=intent.getStringExtra("id");

        cartDb = new CartDBHelper(this);
    }

    public void onAlmondCroissantClicked(View v){
        if(cartDb.chkProduct(id,"AlmondCroissant")==true) {
            cartDb.insertprodInfo(id,"AlmondCroissant", 1, 5400, R.drawable.almond_valley_croissant_s);
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
            cartDb.insertprodInfo(id,"BlueberryBagel", 1, 4800, R.drawable.blueberry_bagel_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"BlueberryBagel");
            Num++;
            cartDb.UpDate(id,"BlueberryBagel",Num,Num*4800);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onCheeseDanishClicked(View v){
        if(cartDb.chkProduct(id,"CheeseDanish")==true) {
            cartDb.insertprodInfo(id,"CheeseDanish", 1, 5300, R.drawable.cheese_danish_s);
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
            cartDb.insertprodInfo(id,"ClassicScone", 1, 4500, R.drawable.classic_scone_s);
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
            cartDb.insertprodInfo(id,"ChocolateMuffin", 1, 3800, R.drawable.dark_chocolate_chip_muffin_s);
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
            cartDb.insertprodInfo(id,"LeafPie", 1, 4200, R.drawable.leaf_pie_s);
        }
        else {
            int Num=cartDb.findProdNum(id,"LeafPie");
            Num++;
            cartDb.UpDate(id,"LeafPie",Num,Num*4200);
        }
        Toast.makeText(getApplicationContext(),"해당 상품을 장바구니에 담았습니다.",Toast.LENGTH_SHORT).show();
    }

    public void onAvocadoClicked(View v) {

        if(cartDb.chkProduct(id,"Avocado")==true) {
            cartDb.insertprodInfo( id,"Avocado", 1, 5900, R.drawable.avocado_blended_s);
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
            cartDb.insertprodInfo(id, "ChchoBanana",  1, 6100, R.drawable.chocolate_banana_blended_s);
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
            cartDb.insertprodInfo( id,"GreanBanana",  1, 6100, R.drawable.green_tea_banana_blended_s);
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
            cartDb.insertprodInfo( id,"MangoBanana",  1, 6300, R.drawable.mango_banana_blended_s);
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


    public void onChaiClicked(View v){
        if(cartDb.chkProduct(id,"Chai")==true) {
            cartDb.insertprodInfo(id,"Chai", 1, 4300, R.drawable.chai_brewed_tea_s);
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
            cartDb.insertprodInfo(id,"Chamomile", 1, 4500, R.drawable.chamomile_blend_brewed_tea_s);
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
            cartDb.insertprodInfo(id,"Earlgrey", 1, 4100, R.drawable.earl_grey_brewed_tea_s);
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
            cartDb.insertprodInfo(id,"Grapefruit", 1, 4500, R.drawable.grapefruit_honey_black_tea_s);
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
            cartDb.insertprodInfo(id,"CaffeLatte", 1, 4300, R.drawable.caffe_latte_s);
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
            cartDb.insertprodInfo(id,"Espresso", 1, 3900, R.drawable.espresso_s);
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
