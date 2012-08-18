package com.edd.qtv;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class TvLogDatabaseHandler extends SQLiteOpenHelper {
	
	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "quitTv";
 
    // Contacts table name
    private static final String TABLE_TV_LOG = "tv_logs";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_FECHA = "fecha";
    private static final String KEY_HORAS_TV = "horas_tv";

	public TvLogDatabaseHandler(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TV_LOG_TABLE = "CREATE TABLE " + TABLE_TV_LOG + "(" +
				KEY_ID + " INTEGER PRIMARY KEY, " + 
				KEY_FECHA + " DATETIME, " +
				KEY_HORAS_TV + " INTEGER )";
		
		db.execSQL(CREATE_TV_LOG_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROM TABLE IF EXIST " + TABLE_TV_LOG);
		
		onCreate(db);
	}
	
}
