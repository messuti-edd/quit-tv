package com.edd.qtv;

public class TvLog {
	
	int _id;
	String _fecha;
	double _horas_tv;
	
	public TvLog(int _id, String _fecha, double _horas_tv) {
		super();
		this._id = _id;
		this._fecha = _fecha;
		this._horas_tv = _horas_tv;
	}
	
	public int get_id() {
		return _id;
	}
	public String get_fecha() {
		return _fecha;
	}
	public double get_horas_tv() {
		return _horas_tv;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public void set_fecha(String _fecha) {
		this._fecha = _fecha;
	}
	public void set_horas_tv(double _horas_tv) {
		this._horas_tv = _horas_tv;
	}
}
