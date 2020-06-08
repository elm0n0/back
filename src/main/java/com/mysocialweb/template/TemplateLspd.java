package com.mysocialweb.template;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysocialweb.base.dao.BaseDao;

public interface TemplateLspd extends BaseDao {
	
	JdbcTemplate getTemplate();
}
