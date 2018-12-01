package com.mysocialweb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mysocialweb.dto.UsuarioDTO;
import com.mysocialweb.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public void saveOrUpdate(@RequestBody final  String usuariosJson) throws JsonParseException, JsonMappingException, IOException {
		this.usuarioService.saveOrUpdate(usuariosJson);
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public List<UsuarioDTO> getUser() {
		return this.usuarioService.findAll();
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteUser(@RequestBody final String usuariosJson) throws JsonParseException, JsonMappingException, IOException {
		this.usuarioService.deleteUser(usuariosJson);
	}
}
