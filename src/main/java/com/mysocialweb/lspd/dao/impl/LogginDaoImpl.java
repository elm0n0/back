package com.mysocialweb.lspd.dao.impl;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.google.common.hash.Hashing;
import com.mysocialweb.lspd.dao.LogginDao;
import com.mysocialweb.lspd.entity.Policia;
import com.mysocialweb.lspd.entity.PoliciaCredentials;
import com.mysocialweb.lspd.utils.ResultSetNullEstractor;
import com.mysocialweb.template.impl.TemplateLspdImpl;

@Repository
public class LogginDaoImpl extends TemplateLspdImpl implements LogginDao {

	private final static RowMapper<Policia> policiaRM = new RowMapper<Policia>() {

		@Override
		public Policia mapRow(ResultSet rs, int rowNum) throws SQLException {
			final Integer idPolicia = ResultSetNullEstractor.getInteger(rs, "ID_POLICIA");
			final String nombre = ResultSetNullEstractor.getString(rs, "NOMBRE");
			final String passwd = ResultSetNullEstractor.getString(rs, "PASSWD");
			final Date fechaAlta = ResultSetNullEstractor.getDate(rs, "FECHA_ALTA");
			final Date fechaBaja = ResultSetNullEstractor.getDate(rs, "FECHA_BAJA");
			final Integer idRango = ResultSetNullEstractor.getInteger(rs, "ID_RANGO");
			final String usuario = ResultSetNullEstractor.getString(rs, "USUARIO");
			final Integer placa = ResultSetNullEstractor.getInteger(rs, "PLACA");
			Policia p = new Policia(idPolicia, nombre, passwd, fechaAlta, fechaBaja, idRango, usuario, placa);
			return p;
		}
	};

	@Override
	public Policia loggearPolicia(final PoliciaCredentials pc) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(" ID_POLICIA, ");
		sb.append(" NOMBRE, ");
		sb.append(" PASSWD, ");
		sb.append(" FECHA_ALTA, ");
		sb.append(" FECHA_BAJA, ");
		sb.append(" ID_RANGO, ");
		sb.append(" USUARIO, ");
		sb.append(" PLACA FROM LSPD.POLICIAS ");
		sb.append(" WHERE ");
		sb.append(" USUARIO = ? ");
		sb.append(" AND PASSWD = ? ");
		List<Object> params = new ArrayList<>();
		params.add(pc.getUsuario());
		params.add(Hashing.sha256().hashString(pc.getPasswd(), StandardCharsets.UTF_8).toString());
		
		Object[] parametros = new Object[params.size()];
		parametros = params.toArray(parametros);
		Policia p = this.getTemplate().queryForObject(sb.toString(), policiaRM, parametros);
		return p;
	}

}
