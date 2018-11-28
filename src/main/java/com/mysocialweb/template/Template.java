package com.mysocialweb.template;

import org.springframework.jdbc.core.JdbcTemplate;

public interface Template {
	
	JdbcTemplate getTemplate();
}
