package com.mysocialweb.lspd.dto;

import java.util.Date;

public class PoliciaDTO {

	private final Integer idPolicia;
	private final String nombre;
	private final Date fechaAlta;
	private final Date fechaBaja;
	private final Integer idRango;
	private final Integer placa;
	public PoliciaDTO(Integer idPolicia, String nombre, Date fechaAlta, Date fechaBaja, Integer idRango,
			Integer placa) {
		super();
		this.idPolicia = idPolicia;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.idRango = idRango;
		this.placa = placa;
	}
	public Integer getIdPolicia() {
		return idPolicia;
	}
	public String getNombre() {
		return nombre;
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
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		PoliciaDTO other = (PoliciaDTO) obj;
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
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PoliciaDTO [idPolicia=" + idPolicia + ", nombre=" + nombre + ", fechaAlta=" + fechaAlta + ", fechaBaja="
				+ fechaBaja + ", idRango=" + idRango + ", placa=" + placa + "]";
	}

	
}
