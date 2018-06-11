package com.example.miruka.starbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

 class StarBuzzDatabaseHelper extends SQLiteOpenHelper {
    private static  final  String DB_NAME="starbuzz"; // The name of Our database
     private  static final int DB_VERSION =2; // The version of the Database

    StarBuzzDatabaseHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db){
       updateMyDatabase(db,0,DB_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        updateMyDatabase(db,oldVersion,newVersion);

    }
    private static void insertDrink(SQLiteDatabase db, String name,String description,int resourceId){
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME",name);
        drinkValues.put("DESCRIPTION",description);
        drinkValues.put("IMAGE_RESOURCE_ID",resourceId);
        db.insert("DRINK",null,drinkValues);

    }
    private void updateMyDatabase(SQLiteDatabase db,int oldVersion,int newVersion){
        if(oldVersion < 1){
            db.execSQL("CREATE TABLE DRINK ("
                    +" _id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +" NAME TEXT, "
                    +" DESCRIPTION TEXT, "
                    +" IMAGE_RESOURCE_ID INTEGER);");
            insertDrink(db,"Latte","Espresso and Steamed Milk",R.drawable.latte);
            insertDrink(db,"Cappuccino","Espresso,Hot Milk and Steamed Milk_Foam",R.drawable.cappuccino);
            insertDrink(db,"Filter","Our Best dddddDrip Coffee",R.drawable.filter);

        }
        if(oldVersion < 2){
            db.execSQL(" ALTER TABLE DRINK ADD COLUMN FAVOURITE NUMERIC;");
        }
    }

}
