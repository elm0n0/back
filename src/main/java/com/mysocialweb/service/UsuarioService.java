package com.mysocialweb.service;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mysocialweb.dto.UsuarioDTO;

public interface UsuarioService {

	List<UsuarioDTO> findAll();

	void saveOrUpdate(final String usuariosJson) throws JsonParseException, JsonMappingException, IOException;

	void deleteUser(String usuariosJson) throws JsonParseException, JsonMappingException, IOException;

}
