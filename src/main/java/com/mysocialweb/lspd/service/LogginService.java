package com.mysocialweb.lspd.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mysocialweb.lspd.dto.PoliciaDTO;

public interface LogginService {

	PoliciaDTO loggearPolicia(final String policiaCredential) throws JsonParseException, JsonMappingException, IOException;

}
