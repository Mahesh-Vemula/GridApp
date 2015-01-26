package com.training.mvqkc.gridapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/**
 * Created by Nandu on 1/25/2015.
 */
public class Datachoice {

    String dbName = "userchoice";
    SQLiteDatabase mydatabase;

    public Datachoice() {
        this.connectDb();
    }

    public void connectDb(){
        try {
            mydatabase = SQLiteDatabase.openDatabase(dbName, null,SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLiteException e) {
            mydatabase = SQLiteDatabase.openOrCreateDatabase(dbName,null);
            this.insertToDb();
        }
    }

    public void insertToDb(){
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS CHOICES(Position INTEGER, Color VARCHAR);");
        mydatabase.execSQL("INSERT INTO CHOICES VALUES(0,'Red');");
        mydatabase.execSQL("INSERT INTO CHOICES VALUES(1,'Orange');");
        mydatabase.execSQL("INSERT INTO CHOICES VALUES(2,'Yellow');");
        mydatabase.execSQL("INSERT INTO CHOICES VALUES(3,'Green');");
        mydatabase.execSQL("INSERT INTO CHOICES VALUES(4,'Blue');");
        mydatabase.execSQL("INSERT INTO CHOICES VALUES(5,'Purple');");
        mydatabase.execSQL("INSERT INTO CHOICES VALUES(6,'White');");
        mydatabase.execSQL("INSERT INTO CHOICES VALUES(7,'Black');");
    }

    public void updateDb(int position, String color){
        mydatabase.execSQL("UPDATE CHOICES SET Color = '"+color+"' WHERE Position = "+position+";");
    }
}
