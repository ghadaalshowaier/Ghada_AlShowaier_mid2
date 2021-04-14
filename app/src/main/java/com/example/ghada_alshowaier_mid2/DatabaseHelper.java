package com.example.ghada_alshowaier_mid2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="ghada.db";
    private static final String TABLE_NAME ="my database";
    private static final String COLUMN_ID="ID";
    private static final String COLUMN_NAME="Name";
    private static final String COLUMN_EMAIL="email";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE "+TABLE_NAME+" ( "+COLUMN_ID+" INTEGER PRIMARY KEY, "+COLUMN_NAME+" TEXT NOT NULL, "+COLUMN_EMAIL+" INTEGER NOT NULL )"
        );

    }

    public void Add(String id,String name, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(COLUMN_ID,id);
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_EMAIL,email);
        db.insert(TABLE_NAME,null,values);

    }

    public Cursor View(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor x=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return x;
    }

    public Integer Delete(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME," ID=? ",new String[]{id});


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}