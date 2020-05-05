package org.cafesss.sssmenu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.BaseAdapter;

public class OrderDBHelper extends SQLiteOpenHelper {
    public final static String COL_0 = "ID";
    public final static String COL_1 = "PRODUCT";
    public final static String COL_2 = "PRICE";
    public final static String COL_3 = "PRODNUM";
    public final static String COL_4 = "TOTALPRICE";
    public final static String COL_5 = "SIZE";
    public final static String COL_6 = "ORDEREDTIME";
    public final static String COL_7 = "DELETED";

    public OrderDBHelper(Context context) {
        super(context, "tb_Order", null, 3);
    }

    public void onCreate(SQLiteDatabase db) {
        String userSql = "create table tb_Order (ID TEXT," +
                "PRODUCT TEXT, " +
                "PRICE INTEGER," +
                "PRODNUM INTEGER," +
                "TOTALPRICE " +
                "INTEGER," +
                "SIZE TEXT," +
                "ORDEREDTIME,"+
                "DELETED TEXT)";
        db.execSQL(userSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "tb_Order");
        onCreate(db);
    }

    public void Insert( String id, String product, int prodnum, int price, String size, String orderedtime)
    {
        int totalprice = prodnum*price;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("PRODUCT", product);
        contentValues.put("PRICE", price);
        contentValues.put("PRODNUM", prodnum);
        contentValues.put("TOTALPRICE", totalprice);
        contentValues.put("SIZE", size);
        contentValues.put("ORDEREDTIME", orderedtime);
        contentValues.put("DELETED", "n");
        db.insert("tb_Order", null, contentValues);
    }


    public void deleteOrder(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DELETED", "d");
        db.update("tb_Order",contentValues,"ID=?",new String[]{id});
    }

    public String findtime(String id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor=db.rawQuery("Select*from tb_Order where ID=?", new String[]{id});
        cursor.moveToNext();
        String time=cursor.getString(cursor.getColumnIndex("ORDEREDTIME"));
        return time;
    }
    public void ChangeDeleteToN(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("deleted","n");
        db.update("tb_user",contentValues,"ID=?",new String[]{id});
    }

    public String getDelInf(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select*from tb_Order where ID=?", new String[]{id});
        return cursor.getString(cursor.getColumnIndex("DELETED"));
    }
    public Cursor getListContents(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select*from tb_Order where ID=?", new String[]{id});
        return cursor;
    }

    public  Cursor getTimeListContents(String id,String time)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select*from tb_Order where ID=? and ORDEREDTIME=?", new String[]{id,time});
        return cursor;
    }

    public Cursor getNDelListContents(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select*from tb_Order where ID=? and DELETED=?", new String[]{id, "n"});
        return cursor;
    }
}