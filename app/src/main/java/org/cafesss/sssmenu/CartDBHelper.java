package org.cafesss.sssmenu;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CartDBHelper extends SQLiteOpenHelper {

    public final static String DATABASE_NAME = "Cart db";
    public final static String TABLE_NAME = "Cart_table";

    public final static String COL_0 = "ID";
    public final static String COL_1 = "PRODUCT";
    public final static String COL_2 = "PRICE";
    public final static String COL_3 = "PRODNUM";
    public final static String COL_4 = "TOTALPRICE";
    public final static String COL_5 = "SIZE";
    public final static String COL_6 = "PIC";
    public final static String COL_7 = "SEL";


    public CartDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 10);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID TEXT, PRODUCT TEXT,PRICE INTEGER, PRODNUM INTEGER, TOTALPRICE INTEGER,SIZE TEXT,PIC INTEGER, SEL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

   public void delete(String id)
   {
       SQLiteDatabase db = this.getWritableDatabase();
       db.delete(TABLE_NAME, "ID=?", new String[]{id});
   }
    public Cursor getListContents(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select*from Cart_table where ID=?", new String[]{id});
        return cursor;
    }
    public Cursor getSelListContents(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select*from Cart_table where ID=? and SEL=?", new String[]{id,"s"});
        return cursor;
    }

    public void insertprodInfo(String id, String product, int prodnum, int price, int pic) {
        int totalprice = prodnum * price;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //Cursor cursor = db.rawQuery("select*from Cart_table where product=?", new String[]{product});

        String size = "small";

        if (product.equals("AlmondCroissant") || product.equals("BlueberryBagel")
                || product.equals("CheeseDanish") || product.equals("LeafPie") ||
                product.equals("ChocolateMuffin") || product.equals("ClassicScone")) {
            size = "none";
        }
        contentValues.put(COL_0, id);
        contentValues.put(COL_1, product);
        contentValues.put(COL_2, price);
        contentValues.put(COL_3, prodnum);
        contentValues.put(COL_4, totalprice);
        contentValues.put(COL_5, size);
        contentValues.put(COL_6, pic);
        contentValues.put(COL_7,"null");
        db.insert(TABLE_NAME, null, contentValues);
    }

    public String findSize(String id, String product) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select*from Cart_table where PRODUCT=? and ID=?", new String[]{product, id});
        cursor.moveToNext();
        String size = cursor.getString(cursor.getColumnIndex("SIZE"));

        return size;
    }
    public int findPic(String product) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select*from Cart_table where PRODUCT=?", new String[]{product});
        cursor.moveToNext();
        int pic = cursor.getInt(cursor.getColumnIndex("PIC"));
        return pic;
    }

    public void inputSize(String id, String product, String size) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_5, size);
        db.update(TABLE_NAME, contentValues, "PRODUCT=? and ID=?", new String[]{product, id});
    }

    public void deleteID(String id, String product) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "ID=? and PRODUCT=?", new String[]{id, product});
        Cursor cursor= db.rawQuery("Select*from Cart_table", null);
        cursor.moveToNext();
    }

    public void UpDate(String id, String product, int prodnum, int totalprice) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_3, prodnum);
        contentValues.put(COL_4, totalprice);
        db.update(TABLE_NAME, contentValues, "PRODUCT=? and ID=?", new String[]{product, id});
    }

    public void UpDatePrice(String id, String product, int price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, price);
        db.update(TABLE_NAME, contentValues, "PRODUCT=? and ID=?", new String[]{product, id});
    }

    public void UpDateSel(String id, String product, String select) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if(select=="s") {
            contentValues.put(COL_7, "s");
        } else {
            contentValues.put(COL_7, "n");
        }
        db.update(TABLE_NAME, contentValues, "PRODUCT=? and ID=?", new String[]{product, id});
    }


    public void UpDateTotalPrice(String id, String product,int totalprice){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_4, totalprice);
        db.update(TABLE_NAME, contentValues, "PRODUCT=? and ID=?", new String[]{product,id});
    }

    public boolean chkProduct(String id, String product) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select*from Cart_table where PRODUCT=? and ID=?", new String[]{product,id});
        if (cursor.getCount() > 0)
            return false;
        else return true;

    }

    public int findProdNum(String id, String product) {
        SQLiteDatabase db = this.getReadableDatabase();
        int prodnum=0;
        Cursor cursor = db.rawQuery("Select*from Cart_table where PRODUCT=? and ID=?", new String[]{product,id});
        cursor.moveToNext();
        prodnum = cursor.getInt(cursor.getColumnIndex("PRODNUM"));

        return prodnum;
    }

    public int findPrice(String id, String product) {
        SQLiteDatabase db = this.getReadableDatabase();
        int price=0;
        Cursor cursor = db.rawQuery("Select*from Cart_table where PRODUCT=? and ID=?", new String[]{product,id});
        cursor.moveToNext();
        price = cursor.getInt(cursor.getColumnIndex("PRICE"));

        return price;
    }

    public int findTotalPrice(String id, String product) {
        SQLiteDatabase db = this.getReadableDatabase();
        int totalPrice=0;
        Cursor cursor = db.rawQuery("Select*from Cart_table where PRODUCT=?and ID=?", new String[]{product,id});
        cursor.moveToNext();
        totalPrice = cursor.getInt(cursor.getColumnIndex("TOTALPRICE"));

        return totalPrice;
    }

}