package org.cafesss.sssmenu;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.util.Log;

public class UserDBHelper extends SQLiteOpenHelper {
    public  UserDBHelper(Context context)
    {
        super(context,"ssscafe.db",null,5);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String userSql="create table tb_user ("+
                "id integer primary key autoincrement,"+
                "userId text,"+
                "userPw text,"+
                "userName text,"+
                "userAge text,"+
                "userPoint integer,"+
                "userOrder integer,"+
                "userPhone text,"+
                "deleted text)";

        db.execSQL(userSql);

        //table create
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tb_user");
        onCreate(db);
    }

    public Boolean ChkUser(String name, String phone)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select*from tb_user where userName =? and userPhone=?", new String[]{name,phone});
        if(cursor.getCount()>0)return false;
        else return true;

    }
    public boolean insert(String userId, String userPw,String userName,String userAge, String userPhone){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("userId",userId);
        contentValues.put("userPw",userPw);
        contentValues.put("userName",userName);
        contentValues.put("userAge",userAge);
        contentValues.put("userPhone",userPhone);
        contentValues.put("userPoint",0);
        contentValues.put("deleted","d");
        long ins=db.insert("tb_user",null,contentValues);

        if(ins==-1)return false;
        else return true;

    }
    public void delete(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("Delete from tb_user where userId=id");
    }

    public void odelete(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("deleted", "d");
        db.update("tb_user",contentValues,"userId=?",new String[]{id});
    }

    public Cursor getListContents()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select*from tb_user",null);
        return cursor;
    }

    public  Cursor ndgetListContents()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select*from tb_user where deleted=?",new String[]{"n"});
        return cursor;
    }

    public boolean chkId(String userId){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select*from tb_user where userId=?",new String[]{userId});
        if (cursor.getCount()>0)
            return false;
        else return true;
    }
    public Cursor getpersonInfo(String id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select*from tb_user where userId=?",new String[]{id});
        return cursor;
    }


    public String findid(String name, String phone, String age) {
        SQLiteDatabase db = this.getReadableDatabase();
        String id="";
        Cursor cursor = db.rawQuery("select*from tb_user where userName=? and userPhone=?and userAge=?",new String[]{name,phone,age});
        for(int i=0;i<cursor.getCount();i++) {
            cursor.moveToNext();
            id=cursor.getString(cursor.getColumnIndex("userId"));
            }

        return id;
    }

    public int findOrderNum(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select*from tb_user where userId=?",new String[]{id});
        cursor.moveToNext();
        int num=cursor.getInt(cursor.getColumnIndex("ordernum"));
        return num;
    }

    public int findpoint(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        int point;
        Cursor cursor = db.rawQuery("select*from tb_user where userId=?",new String[]{id});
        cursor.moveToNext();
        point=cursor.getInt(cursor.getColumnIndex("userPoint"));

        return point;
    }

    public int setpoint(String id, int point) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select*from tb_user where userId=?",new String[]{id});
        cursor.moveToNext();
        point+=cursor.getInt(cursor.getColumnIndex("userPoint"));
        ContentValues contentValues = new ContentValues();
        contentValues.put("userPoint",point);
        db=this.getWritableDatabase();
        db.update("tb_user",contentValues,"userId=?",new String[]{id});
        return point;
    }

    public void ChangeDeleteToN(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("deleted","n");
        db.update("tb_user",contentValues,"userId=?",new String[]{id});
    }

    public String findpw(String id, String phone) {
        SQLiteDatabase db = this.getReadableDatabase();
        String pw="";
        Cursor cursor = db.rawQuery("select*from tb_user where userId=? and userPhone=?",new String[]{id,phone});
        for(int i=0;i<cursor.getCount();i++) {
            cursor.moveToNext();
            pw=cursor.getString(cursor.getColumnIndex("userPw"));
        }

        return pw;
    }

    public Boolean idpw(String userId, String userPw)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select*from tb_user where userId=? and userPw=?",new String[]{userId,userPw});
        if(cursor.getCount()>0) return true;
        else return false;
    }


}
