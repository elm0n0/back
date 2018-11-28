package com.mysocialweb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mysocialweb.dao.UsuariosDao;
import com.mysocialweb.model.Usuario;
import com.mysocialweb.template.TemplateImpl;

@Repository
public class UsuariosDaoImpl extends TemplateImpl implements UsuariosDao {
	
	private final RowMapper<Usuario> rowMapUser = new RowMapper<Usuario>() {

		@Override
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario user = new Usuario();
			user.setNombre(rs.getString("nombre"));
			user.setApellido(rs.getString("apellido"));
			user.setApellido2(rs.getString("apellido2"));
			user.setEmail(rs.getString("email"));
			user.setTelefono(rs.getString("telefono"));
			return user;
		}
	};

	@Override
	public List<Usuario> obtenerUsuarios() {
		String sql = "SELECT nombre, apellido, apellido2, email , telefono FROM usuarios.usuarios";
		return this.getTemplate().query(sql, rowMapUser);
	}
}
