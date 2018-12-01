package com.mysocialweb.base.dao.impl;

import java.util.Collection;

import com.mysocialweb.base.dao.BaseDao;

public class BaseDaoImpl implements BaseDao {

	@Override
	public void addNullableParam(StringBuilder sb, Collection<Object> params, Object object, String text,
			boolean needComa) {
		if (object != null) {
			sb.append(text);
			sb.append("= ? ");
			params.add(object);
		}
		if (needComa) {
			sb.append(", ");
		}
	}

	@Override
	public void insert(StringBuilder sb, String tabla, String columns, int objetos) {
		sb.append("insert into " + tabla + "( ");
		sb.append(columns + ") ");
		sb.append("values (");
		for (int i = 0; i < objetos; i++) {
			sb.append("?,");
		}
		sb.replace(sb.length() - 1, sb.length(), ")");
	}

	@Override
	public void addIn(StringBuilder sb, Collection<Object> params, Collection<?> lista, final String nombreIn,
			final boolean isAnd) {
		if (isAnd) {
			sb.append("AND ");
		}
		sb.append(nombreIn);
		sb.append(" in (");
		for (Object actual : lista) {
			sb.append("?,");
			params.add(actual);
		}
		sb.replace(sb.length() - 1, sb.length(), ") ");
	}

}
