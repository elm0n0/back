package com.mysocialweb.dao;

import java.util.List;

import com.mysocialweb.model.Usuario;

public interface UsuariosDao{

	List<Usuario> findAll();

	void saveOrUpdate(final List<Usuario> usuarios);

	boolean DeleteUser(final List<Usuario> temporal);
	
}
