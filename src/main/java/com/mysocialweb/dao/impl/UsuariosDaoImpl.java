package com.mysocialweb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mysocialweb.dao.UsuariosDao;
import com.mysocialweb.model.Usuario;
import com.mysocialweb.template.impl.TemplateTemplateUsuariosImpl;

@Repository
public class UsuariosDaoImpl extends TemplateTemplateUsuariosImpl implements UsuariosDao {
	
	private final RowMapper<Usuario> rowMapUser = new RowMapper<Usuario>() {

		@Override
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario user = new Usuario();
			user.setId(rs.getLong("id"));
			user.setNombre(rs.getString("nombre"));
			user.setApellido(rs.getString("apellido"));
			user.setApellido2(rs.getString("apellido2"));
			user.setEmail(rs.getString("email"));
			user.setTelefono(rs.getString("telefono"));
			return user;
		}
	};

	@Override
	public List<Usuario> findAll() {
		String sql = "SELECT id, nombre, apellido, apellido2, email , telefono FROM usuarios";
		return this.getTemplate().query(sql, rowMapUser);
	}

	@Override
	public void saveOrUpdate(final List<Usuario> usuarios) {

		StringBuilder sb = new StringBuilder();
		List<Object> params = new ArrayList<>();
		for (Usuario actual : usuarios) {
			// comprobar si existe
			sb.append("select ");
			sb.append("id, ");
			sb.append("nombre, ");
			sb.append("apellido, ");
			sb.append("apellido2, ");
			sb.append("email, ");
			sb.append("telefono ");
			sb.append("from usuarios ");
			sb.append("where ");
			addNullableParam(sb, params, actual.getEmail(), "email", false);
			String sql = sb.toString();
			Object[] parametros = new Object[params.size()];
			parametros = params.toArray(parametros);
			Usuario usuario;
			try {
				usuario = this.getTemplate().queryForObject(sql, rowMapUser, parametros);
			} catch (DataAccessException e) {
				usuario = null;
			}
			if (usuario != null) { // si el usuario existe, actualizamos sus campos
				// borramos el contenido del String builder para realizar una nueva llamada a la
				// BBDD
				sb.setLength(0);
				// vaciamos el contenido de la lista de objetos para realizar una nueva llamada
				// a la BBDD
				params.clear();
				sb.append("UPDATE usuarios ");
				sb.append("SET ");
				addNullableParam(sb, params, actual.getNombre(), "nombre", true);
				addNullableParam(sb, params, actual.getApellido(), "apellido", true);
				addNullableParam(sb, params, actual.getApellido2(), "apellido2", true);
				addNullableParam(sb, params, actual.getTelefono(), "telefono", false);
				sb.append("WHERE ");
				addNullableParam(sb, params, actual.getEmail(), "email", false);
				sql = sb.toString();
				parametros = params.toArray(parametros);
				this.getTemplate().update(sql, parametros);
			} else { // si no existe el usuario, hay que crearlo
				sb.setLength(0);
				params.clear();
				String tabla = "usuarios";
				String columnas = "nombre,apellido,apellido2,email,telefono";
				params.add(actual.getNombre());
				params.add(actual.getApellido());
				params.add(actual.getApellido2());
				params.add(actual.getEmail());
				params.add(actual.getTelefono());
				insert(sb, tabla, columnas, params.size());
				parametros = new Object[params.size()];
				parametros = params.toArray(parametros);
				this.getTemplate().update(sb.toString(), parametros);
			}
			sb.setLength(0);
			params.clear();
		}
	}

	@Override
	public boolean DeleteUser(final List<Usuario> usuarios) {
		StringBuilder sb = new StringBuilder();
		List<Object> params = new ArrayList<>();
		List<String> emails = new ArrayList<>();
		for (Usuario actual : usuarios) {
			emails.add(actual.getEmail());
		}
		sb.append("SELECT id ");
		sb.append("FROM usuarios ");
		sb.append("WHERE ");
		addIn(sb, params, emails, "email", false);
		Object[] parametros = new Object[params.size()];
		parametros = params.toArray(parametros);
		List<Long> idUsuarios = this.getTemplate().queryForList(sb.toString(), Long.class, parametros);
		if (!idUsuarios.isEmpty()) {
			sb.setLength(0);
			params.clear();
			sb.append("DELETE FROM usuarios ");
			sb.append("WHERE ");
			addIn(sb, params, idUsuarios, "id", false);
			parametros = new Object[params.size()];
			parametros = params.toArray(parametros);
			this.getTemplate().update(sb.toString(), parametros);
			return true;
		}else {
			return false;
		}
	}
}
