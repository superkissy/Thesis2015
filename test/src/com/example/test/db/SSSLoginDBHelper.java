package com.example.test.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SSSLoginDBHelper extends SQLiteOpenHelper {

	private static final String LOGTAG = "EXAMPLE";
	private static final String DATABASE_NAME = "login.db";
	private static final int DATABASE_VERSION = 1;
	
	public static final String TABLE_LOGIN = "Login_tbl";
	public static final String COLUMN_ID = "user_id";
	public static final String COLUMN_pass = "password";
	
	public static final String TABLE_CREATE =
			"CREATE TABLE " + TABLE_LOGIN + "(" +
			COLUMN_ID + " INTERGER PRIMARY KEY, " +
			COLUMN_pass + " VARCHAR, " +
			")";
	
	
		
	public SSSLoginDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {  
		db.execSQL(TABLE_CREATE);
		Log.i(LOGTAG, "Table has been created");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
		onCreate(db);

	}

}
