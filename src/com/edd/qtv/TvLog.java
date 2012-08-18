package com.edd.qtv;

public class TvLog {
	
	public TvLog(int _id, String _fecha, double _horas_tv) {
		super();
		this._id = _id;
		this._fecha = _fecha;
		this._horas_tv = _horas_tv;
	}
	
	/**
	 * @return the _id
	 */
	public int get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(int _id) {
		this._id = _id;
	}
	/**
	 * @return the _fecha
	 */
	public String get_fecha() {
		return _fecha;
	}
	/**
	 * @param _fecha the _fecha to set
	 */
	public void set_fecha(String _fecha) {
		this._fecha = _fecha;
	}
	/**
	 * @return the _horas_tv
	 */
	public double get_horas_tv() {
		return _horas_tv;
	}
	/**
	 * @param _horas_tv the _horas_tv to set
	 */
	public void set_horas_tv(double _horas_tv) {
		this._horas_tv = _horas_tv;
	}
	int _id;
	String _fecha;
	double _horas_tv;
}
