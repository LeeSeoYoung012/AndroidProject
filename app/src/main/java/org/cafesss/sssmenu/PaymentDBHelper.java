package org.cafesss.sssmenu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PaymentDBHelper extends SQLiteOpenHelper {
    public final static String DATABASE_NAME = "Payment DB";
    public final static String TABLE_NAME = "Payment_table";

    public final static String COL_0 ="ID";
    public final static String COL_1 = "PRODUCT";
    public final static String COL_2 = "PRICE";
    public final static String COL_3 = "PRODNUM";
    public final static String COL_4 = "TOTALPRICE";
    public final static String COL_5 = "SIZE";
    public final static String COL_6 ="ORDERTIME";

    public PaymentDBHelper(Context context){ super(context,DATABASE_NAME,null,4);}

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(ID TEXT,PRODUCT TEXT,PRICE INTEGER,PRODNUM INTEGER,TOTALPRICE INTEGER," +
                "SIZE TEXT, ORDERTIME TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void delete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "ID=?", new String[]{id});
    }

    public void Insert( String id, String product, int prodnum, int price, String size, String ordertime)
    {
        int totalprice = prodnum*price;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_0, id);
        contentValues.put(COL_1, product);
        contentValues.put(COL_2, price);
        contentValues.put(COL_3, prodnum);
        contentValues.put(COL_4, totalprice);
        contentValues.put(COL_5, size);
        contentValues.put(COL_6, ordertime);
        db.insert(TABLE_NAME, null, contentValues);
    }


    public Cursor getListContents(String id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select*from Payment_table where ID=?",new String[]{id});
        return cursor;
    }


}