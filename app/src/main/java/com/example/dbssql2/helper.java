package com.example.dbssql2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.StringSearch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.security.acl.LastOwnerException;

public class helper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME="OMER2.db";
    public static final String TABLE_NAME="OMER3_table";
    public static final String COL1 ="REGNO";
    public static final String COL2 ="CNIC";
    public static final String COL3 ="NAME";
    public static final String COL4 ="FATHERNAME";
    public static final String COL5 ="SEMESTER";
    public static final String COL6 ="GPA";
    public static final String COL7="YEAR";



    public helper(@Nullable Context context) {
        super(context, DATABASE_NAME ,null ,1);

    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("create TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+"REGNO INTEGER,CNIC INTEGER,NAME TEXT,FATHERNAME TEXT,SEMESTER INTEGER,GPA INTEGER,YEAR INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {

        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);

    }
    public  boolean insertdata(String REGNO,String CNIC,String NAME,String FATHERNAME,String SEMESTER,String GPA,String YEAR) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, REGNO);
        contentValues.put(COL2, CNIC);
        contentValues.put(COL3, NAME);
        contentValues.put(COL4, FATHERNAME);
        contentValues.put(COL5, SEMESTER);
        contentValues.put(COL6, GPA);
        contentValues.put(COL7, YEAR);

        long result =database.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }
    public boolean updateData(String REGNO,String CNIC,String NAME,String FATHERNAME,String SEMESTER,String GPA,String YEAR)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL1, REGNO);
        contentValues.put(COL2, CNIC);
        contentValues.put(COL3, NAME);
        contentValues.put(COL4, FATHERNAME);
        contentValues.put(COL5, SEMESTER);
        contentValues.put(COL6, GPA);
        contentValues.put(COL7, YEAR);
        database.update(TABLE_NAME,contentValues,"REGNO = ?",new String[] {REGNO});
        return true;
    }

    public Cursor showData()
    {
        SQLiteDatabase database =this.getWritableDatabase();
        Cursor cursor =database.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }

}
