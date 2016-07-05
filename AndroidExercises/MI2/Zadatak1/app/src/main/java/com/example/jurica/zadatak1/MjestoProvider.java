package com.example.jurica.zadatak1;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by Jurica on 7/4/2016.
 */
public class MjestoProvider extends ContentProvider {

    SQLiteDatabase database;
    String databaseName = "nekaBaza";
    String authority = "com.example.mjesto";
    UriMatcher matcher;

    @Override
    public boolean onCreate() {
        //Da baza postoji, ovako bi se inicijalizirala
        //MjestoHelper helper = new MjestoHelper(this.getContext(), databaseName, null, 1);
        //database = helper.getWritableDatabase();

        matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(authority, "mjesto", 1);
        matcher.addURI(authority, "mjesto/#", 2);

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int uriMatch = matcher.match(uri);
        switch (uriMatch){
            case 1:
                return MjestoHelper.getAllMjesta(database);
            case 2:
                String id = uri.getLastPathSegment();
                return MjestoHelper.getMjestoWithId(database, id);
        }
        return null;
    }

    @Override
    public String getType(Uri uri) {
        int uriMatch = matcher.match(uri);
        switch (uriMatch){
            case 1:
                return "vnd.android.cursor.dir/vnd.example.mjesto";
            case 2:
                return "vnd.android.cursor.item/vnd.example.mjesto";
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return MjestoHelper.updateMjesto(database, values, selection, selectionArgs);
    }
}
