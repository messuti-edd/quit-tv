package com.edd.qtv;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class TvLogDetalleDatabaseHandler extends SQLiteOpenHelper {
	
	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "quitTv";
 
    // TV_Logs_Detalles table name
    private static final String TABLE_TV_LOG_DETALLES = "tv_log_detalles";
 
    // TV_Logs_Detalles Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_HORAS_TV = "horas_tv";
    private static final String KEY_HORA_INICIO = "hora_inicio";
    private static final String KEY_HORA_FIN = "hora_fin";

	public TvLogDetalleDatabaseHandler(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TV_LOG_TABLE = "CREATE TABLE " + TABLE_TV_LOG_DETALLES + "(" +
				KEY_ID + " INTEGER PRIMARY KEY, " + 
				KEY_HORAS_TV + " INTEGER, " + 
				KEY_HORA_INICIO + " DATETIME, " + 
				KEY_HORA_FIN + " DATETIME )";
		
		db.execSQL(CREATE_TV_LOG_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROM TABLE IF EXIST " + TABLE_TV_LOG_DETALLES);
		
		onCreate(db);
	}
    
    public void addTvLogDetalle(TvLogDetalle tvLogDetalle) {
    	SQLiteDatabase db = this.getWritableDatabase();
		 
	    ContentValues values = new ContentValues();
	    values.put(KEY_HORAS_TV, tvLogDetalle.get_horas_tv());
	    values.put(KEY_HORA_INICIO, tvLogDetalle.get_hora_inicio());
	    values.put(KEY_HORA_FIN, tvLogDetalle.get_hora_fin());
	 
	    db.insert(TABLE_TV_LOG_DETALLES, null, values);
	    db.close();
	}
	
	public TvLogDetalle getTvLogDetalle(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		 
	    Cursor cursor = db.query( TABLE_TV_LOG_DETALLES, new String[] { KEY_ID,
	            KEY_HORAS_TV, KEY_HORA_INICIO, KEY_HORA_INICIO }, KEY_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null );
	    
	    if (cursor != null)
	        cursor.moveToFirst();
	 
	    TvLogDetalle tvLogDetalle = new TvLogDetalle (
	    		Integer.parseInt(cursor.getString(0)),
	            Double.parseDouble(cursor.getString(1)), 
	            cursor.getString(2), cursor.getString(1) );
	    
	    return tvLogDetalle;
	}
	
	public List<TvLogDetalle> getAllTvLogs() {
		return null;
	}
	 
	
	public int getTvLogsCount() {
		return 0;
	}
	
	public int updateTvLogDetalle(TvLogDetalle tvLogDetalle) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_HORAS_TV, tvLogDetalle.get_horas_tv());
	    values.put(KEY_HORA_INICIO, tvLogDetalle.get_hora_inicio());
	    values.put(KEY_HORA_FIN, tvLogDetalle.get_hora_fin());
		
		return db.update(TABLE_TV_LOG_DETALLES, values, KEY_ID + "=?", 
				new String[] { String.valueOf(tvLogDetalle.get_id()) });
	}
	
	public int deleteTvLogDetalle(TvLogDetalle tvLogDetalle) {
		SQLiteDatabase db = this.getWritableDatabase();
		return db.delete(TABLE_TV_LOG_DETALLES, KEY_ID+"=?", 
				new String[] {String.valueOf(tvLogDetalle.get_id())});
	}
}
