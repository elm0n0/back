package com.mysocialweb.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TemplateImpl implements Template{

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public JdbcTemplate getTemplate() {
		return template;
	}

}
