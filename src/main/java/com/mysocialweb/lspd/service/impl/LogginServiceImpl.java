package com.mysocialweb.lspd.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysocialweb.Mapper.lspd.dao.PoliciaRowMapper;
import com.mysocialweb.lspd.dao.LogginDao;
import com.mysocialweb.lspd.dto.PoliciaDTO;
import com.mysocialweb.lspd.entity.Policia;
import com.mysocialweb.lspd.entity.PoliciaCredentials;
import com.mysocialweb.lspd.service.LogginService;


@Service
public class LogginServiceImpl implements LogginService {

	@Autowired
	private LogginDao logginDao;
	
	private static Logger logger = LoggerFactory.getLogger(LogginServiceImpl.class);
	
	@Autowired
	private PoliciaRowMapper policiaRowMapper;
	
	protected ObjectMapper mapper;

	@Override
	public PoliciaDTO loggearPolicia(String policiaCredential)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("");
		mapper = new ObjectMapper();
		// convertimos el String con la lista de usuarios a una lista de usuarios
		PoliciaCredentials pc = mapper.readValue(policiaCredential, new TypeReference<PoliciaCredentials>() {
		});
		Policia p = this.logginDao.loggearPolicia(pc);
		
		PoliciaDTO res = this.policiaRowMapper.asDTO(p);
		
		return res;
	}

}
