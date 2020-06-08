package com.mysocialweb.lspd.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ResultSetNullEstractor {

	public static Integer getInteger(ResultSet rs, String column) throws SQLException {
		Integer valor = rs.getInt(column);
		if (rs.wasNull()) {
			valor = null;
		}
		return valor;
	}

	public static String getString(ResultSet rs, String column) throws SQLException {
		String valor = rs.getString(column);
		if (rs.wasNull()) {
			valor = null;
		}
		return valor;
	}

	public static Date getDate(ResultSet rs, String column) throws SQLException {
		Date valor = rs.getDate(column);
		if (rs.wasNull()) {
			valor = null;
		}
		return valor;
	}

	
	
}
