package com.example.miruka.sqllite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{
    private static final  int DATABASE_VERSION = 1;
    private static final  String DATABASE_NAME = "Mosala";
    private  static  final  String TABLE_M = "mytable";
    SQLiteDatabase db;
    public DbHelper(Context ct){
        super(ct, DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
public void onCreate(SQLiteDatabase db)
    {
      String create=" CREATE TABLE "  + TABLE_M +"(regno TEXT,name TEXT)";
                db.execSQL(create);
    }
@Override
    public void  onUpgrade(SQLiteDatabase db, int  oldVersion, int newVersion){
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_M);
         onCreate(db);

}
public Cursor readData(String regno )
{
    Cursor c1 = null;
    try
    {
        SQLiteDatabase db = this.getReadableDatabase();
        c1 = db.rawQuery(" Select name from my table Where regno " + regno, null);

    }
    catch (Exception e)
    {
        System.out.println("DATABASE ERROR" + e);
    }
    return c1;
}
public void writeData(String regno,String name)
{
        db=getWritableDatabase();
        db.execSQL("insert into mytable values ('+regno+','+name+')");
}
}

