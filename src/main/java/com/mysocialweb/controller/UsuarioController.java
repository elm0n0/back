package com.mysocialweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysocialweb.dto.UsuarioDTO;
import com.mysocialweb.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	protected ObjectMapper mapper;

	// @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
//	public List<UsuarioDTO> saveOrUpdate(@RequestBody List<UsuarioDTO> usuariosJson ){
//		
//		List<UsuarioDTO> usuarios = this.mapper.readValues();
//		
//		return this.usuarioService.saveOrUpdate(usuariosJson);
//	}
	
	@RequestMapping(value = "/obtenerUsuarios2", method = RequestMethod.GET)
	public List<UsuarioDTO> obtenerUsuarios2() {
		return this.usuarioService.obtenerUsuarios();
	}

}
