package com.edd.qtv;


class TvLogDetalle {
	
	int _id;
	double _horas_tv;
	String _hora_inicio;
	String _hora_fin;
	
	public TvLogDetalle(int _id, double _horas_tv, String _hora_inicio, String _hora_fin) {
		super();
		this._id = _id;
		this._horas_tv = _horas_tv;
		this._hora_inicio = _hora_inicio;
		this._hora_fin = _hora_fin;
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
	/**
	 * @return the _hora_inicio
	 */
	public String get_hora_inicio() {
		return _hora_inicio;
	}
	/**
	 * @param _hora_inicio the _hora_inicio to set
	 */
	public void set_hora_inicio(String _hora_inicio) {
		this._hora_inicio = _hora_inicio;
	}
	/**
	 * @return the _hora_fin
	 */
	public String get_hora_fin() {
		return _hora_fin;
	}
	/**
	 * @param _hora_fin the _hora_fin to set
	 */
	public void set_hora_fin(String _hora_fin) {
		this._hora_fin = _hora_fin;
	}
}