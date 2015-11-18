package com.example.crud;

import com.example.crud.TableData.TableInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOperations extends SQLiteOpenHelper {
	
	public static final int database_version=1;
	public String CREATE_QUERY="CREATE TABLE "+TableInfo.TABLE_NAME+"("
	+TableInfo.Username+"VARCHAR,"+TableInfo.Pass+"VARCHAR);";

	public DatabaseOperations(Context context) {
		super(context, TableInfo.DATABASE_NAME, null, database_version);
		Log.d("Database operations", "Db  created");
	}

	@Override
	public void onCreate(SQLiteDatabase sdb) {
		
		sdb.execSQL(CREATE_QUERY);
		Log.d("Databse operations", "Table created");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		

	}
	
	public void putInformation(DatabaseOperations dop, String name, String pass)
	{
		SQLiteDatabase SQ= dop.getWritableDatabase();
		ContentValues cv= new ContentValues();
		cv.put(TableInfo.Username, name);
		cv.put(TableInfo.Pass, pass);
		long k= SQ.insert(TableInfo.TABLE_NAME, null, cv);
		Log.d("Database operations", "one row inserted");
	}

	public Cursor getInformation(DatabaseOperations dop) 
	{
		SQLiteDatabase SQ = dop.getReadableDatabase();
		String[] columns = {TableInfo.Username,TableInfo.Pass};
		Cursor CR = SQ.query(TableInfo.TABLE_NAME, columns, null, null, null, null, null);
		return CR;
	}
}
