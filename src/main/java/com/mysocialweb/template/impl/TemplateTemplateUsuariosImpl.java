package com.mysocialweb.template.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysocialweb.base.dao.impl.BaseDaoImpl;
import com.mysocialweb.template.TemplateUsuarios;

public class TemplateTemplateUsuariosImpl extends BaseDaoImpl implements TemplateUsuarios{

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public JdbcTemplate getTemplate() {
		return template;
	}

}
