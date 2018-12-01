package com.mysocialweb.base.dao;

import java.util.Collection;

public interface BaseDao {

	void addNullableParam(StringBuilder sb, Collection<Object> params, final Object objeto, final String text,
			final boolean needComa);

	void insert(StringBuilder sb, final String tabla, final String columns, final int objetos);

	void addIn(StringBuilder sb, Collection<Object> params, final Collection<?> lista, final String nombreIn,
			final boolean isAnd);
}
