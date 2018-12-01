package com.mysocialweb.model;

public class Usuario {

	private Long id;

	private String nombre;

	private String apellido;

	private String apellido2;

	private String email;

	private String telefono;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {

		return "Usuario [	nombre =	" + nombre + "\r\n"
				+ "		apellido =	" + apellido + "\r\n"
				+ "		apellido2 =	" + apellido2+ "\r\n"
				+ "		email =		" + email + "\r\n"
				+ "		telefono =	" + telefono + "] \r\n\r\n";
	}

}
