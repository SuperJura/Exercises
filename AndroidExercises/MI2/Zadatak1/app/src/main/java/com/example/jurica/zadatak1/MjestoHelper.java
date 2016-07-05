package com.example.jurica.zadatak1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

/**
 * Created by Jurica on 7/4/2016.
 */
public class MjestoHelper extends SQLiteOpenHelper {

    public MjestoHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //nemoj nista raditi jer baza postoji
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //nemoj nista raditi s bazom
    }

    public static Cursor getAllMjesta(SQLiteDatabase db){
       return db.query("Mjesto", new String[]{"id", "naziv"}, null, null, null, null, null);
    }

    public static Cursor getMjestoWithId(SQLiteDatabase db, String id){
        return db.query("Mjesto", new String[]{"id", "naziv"}, "Id == ?", new String [] { id }, null, null, null);
    }

    public static int updateMjesto(SQLiteDatabase db, ContentValues cv, String where, String[] whereArgs){
        return db.update("Mjesto", cv, where, whereArgs);
    }
}
