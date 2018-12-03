package com.mysocialweb.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysocialweb.Mapper.dao.UsuarioMapperDao;
import com.mysocialweb.dao.UsuariosDao;
import com.mysocialweb.dto.UsuarioDTO;
import com.mysocialweb.model.Usuario;
import com.mysocialweb.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private UsuariosDao usuariosDao;
	@Autowired
	private UsuarioMapperDao usuarioMapper;

	protected ObjectMapper mapper;

	@Override
	public List<UsuarioDTO> findAll() {
		logger.info("recuperando usuarios");
		List<Usuario> usuarios = this.usuariosDao.findAll();
		List<UsuarioDTO> resultado = this.usuarioMapper.asDTO(usuarios);
		logger.info("se han recuperado {} usuarios ", resultado.size());
		return resultado;
	}

	@Override
	public void saveOrUpdate(final String usuariosJson) throws JsonParseException, JsonMappingException, IOException {
		// creamos una instancia del objeto Mapper
		mapper = new ObjectMapper();
		// convertimos el String con la lista de usuarios a una lista de usuarios
		List<Usuario> usuarios = this.mapper.readValue(usuariosJson, new TypeReference<List<Usuario>>() {
		});
		// quitamos espacios en blanco
		List<Usuario> temporal = new ArrayList<>();
		for (Usuario actual : usuarios) {
			Usuario aux = new Usuario();

			aux.setNombre(actual.getNombre().trim());
			aux.setApellido(actual.getApellido().trim());
			if (actual.getApellido2() != null) {
				aux.setApellido2(actual.getApellido2().trim());
			}
			aux.setEmail(actual.getEmail().trim());
			if (actual.getTelefono() != null) {
				aux.setTelefono(actual.getTelefono().trim());
			}
			temporal.add(aux);
		}
		logger.info("se van a crear o modificar los siguientes usuarios \r\n {}", temporal);
		this.usuariosDao.saveOrUpdate(temporal);
		logger.info("finalizado el proceso de modificacion o guardado de usuarios");
	}

	@Override
	public void deleteUser(final String usuariosJson) throws JsonParseException, JsonMappingException, IOException {
		mapper = new ObjectMapper();
		// convertimos el String con la lista de usuarios a una lista de usuarios
		List<Usuario> usuarios = this.mapper.readValue(usuariosJson, new TypeReference<List<Usuario>>() {
		});
		List<Usuario> temporal = new ArrayList<>();
		for (Usuario actual : usuarios) {
			Usuario aux = new Usuario();
			aux.setNombre(actual.getNombre().trim());
			aux.setApellido(actual.getApellido().trim());
			if (actual.getApellido2() != null) {
				aux.setApellido2(actual.getApellido2().trim());
			}
			aux.setEmail(actual.getEmail().trim());
			if (actual.getTelefono() != null) {
				aux.setTelefono(actual.getTelefono().trim());
			}
			temporal.add(aux);
		}
		logger.info("se van a eliminar los siguientes usuarios \r\n {}", temporal.toString());
		boolean isEliminado = this.usuariosDao.DeleteUser(temporal);
		if (isEliminado) {
			logger.info("se han eliminado correctamente");
		} else {
			logger.info("algunos no han sido eliminados");
		}

	}

}
