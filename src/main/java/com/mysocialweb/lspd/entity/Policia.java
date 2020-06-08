package com.mysocialweb.lspd.entity;

import java.util.Date;

public class Policia {

	private final Integer idPolicia;
	private final String nombre;
	private final String passwd;
	private final Date fechaAlta;
	private final Date fechaBaja;
	private final Integer idRango;
	private final String usuario;
	private final Integer placa;
	public Policia(Integer idPolicia, String nombre, String passwd, Date fechaAlta, Date fechaBaja, Integer idRango,
			String usuario, Integer placa) {
		super();
		this.idPolicia = idPolicia;
		this.nombre = nombre;
		this.passwd = passwd;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.idRango = idRango;
		this.usuario = usuario;
		this.placa = placa;
	}
	public Integer getIdPolicia() {
		return idPolicia;
	}
	public String getNombre() {
		return nombre;
	}
	public String getPasswd() {
		return passwd;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public Integer getIdRango() {
		return idRango;
	}
	public String getUsuario() {
		return usuario;
	}
	public Integer getPlaca() {
		return placa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaBaja == null) ? 0 : fechaBaja.hashCode());
		result = prime * result + ((idPolicia == null) ? 0 : idPolicia.hashCode());
		result = prime * result + ((idRango == null) ? 0 : idRango.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((passwd == null) ? 0 : passwd.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Policia other = (Policia) obj;
		if (fechaAlta == null) {
			if (other.fechaAlta != null)
				return false;
		} else if (!fechaAlta.equals(other.fechaAlta))
			return false;
		if (fechaBaja == null) {
			if (other.fechaBaja != null)
				return false;
		} else if (!fechaBaja.equals(other.fechaBaja))
			return false;
		if (idPolicia == null) {
			if (other.idPolicia != null)
				return false;
		} else if (!idPolicia.equals(other.idPolicia))
			return false;
		if (idRango == null) {
			if (other.idRango != null)
				return false;
		} else if (!idRango.equals(other.idRango))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (passwd == null) {
			if (other.passwd != null)
				return false;
		} else if (!passwd.equals(other.passwd))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Policia [idPolicia=" + idPolicia + ", nombre=" + nombre + ", passwd={xxxx}" + ", fechaAlta="
				+ fechaAlta + ", fechaBaja=" + fechaBaja + ", idRango=" + idRango + ", usuario=" + usuario + ", placa="
				+ placa + "]";
	}

	
}
