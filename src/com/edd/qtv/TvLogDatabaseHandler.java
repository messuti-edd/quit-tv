package com.edd.qtv;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class TvLogDatabaseHandler extends SQLiteOpenHelper {
	
	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "quitTv";
 
    // TV_Logs table name
    private static final String TABLE_TV_LOG = "tv_logs";
 
    // TV_Logs Table Columns names
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
	
	public void addTvLog(TvLog tvLog) {
		SQLiteDatabase db = this.getWritableDatabase();
		 
	    ContentValues values = new ContentValues();
	    values.put(KEY_FECHA, tvLog.get_fecha());
	    values.put(KEY_HORAS_TV, tvLog.get_horas_tv());
	 
	    // Inserting Row
	    db.insert(TABLE_TV_LOG, null, values);
	    db.close();
	}
	
	public TvLog getTvLog(int id) {
	    SQLiteDatabase db = this.getReadableDatabase();
	 
	    Cursor cursor = db.query(TABLE_TV_LOG, new String[] { KEY_ID,
	            KEY_FECHA, KEY_HORAS_TV }, KEY_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
	    
	    if (cursor != null)
	        cursor.moveToFirst();
	 
	    TvLog tvLog = new TvLog( Integer.parseInt(cursor.getString(0)),
	            cursor.getString(1), Double.parseDouble(cursor.getString(2)) );
	    
	    return tvLog;
	}
	
	public List<TvLog> getAllTvLogs() {
		List<TvLog> tvLogs = new ArrayList<TvLog>();
		
		String query = "SELECT * from " + TABLE_TV_LOG;
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		
		if (cursor.moveToFirst()) {
			do {
				TvLog tvLog = new TvLog();
				tvLog.set_id( Integer.parseInt(cursor.getString(0)) );
				tvLog.set_fecha( cursor.getString(1) );
				tvLog.set_horas_tv( Double.parseDouble(cursor.getString(2)) );
				
				tvLogs.add(tvLog);
			} while (cursor.moveToNext());
		}
		
		return tvLogs;
	}
	 
	
	public int getTvLogsCount() {
		String query = "SELECT * from " + TABLE_TV_LOG;
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		cursor.close();
		
		return cursor.getCount();
	}
	
	public int updateTvLogDetalle(TvLog tvLog) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_FECHA, tvLog.get_fecha());
		values.put(KEY_HORAS_TV, tvLog.get_horas_tv());
		
		return db.update(TABLE_TV_LOG, values, KEY_ID + "=?", 
				new String[] {String.valueOf(tvLog.get_id())});
	}
	
	public int deleteTvLogDetalle(TvLog tvLog) {
		SQLiteDatabase db = this.getWritableDatabase();
		return db.delete(TABLE_TV_LOG, KEY_ID+"=?", 
				new String[] {String.valueOf(tvLog.get_id())});
	}
}
