package com.mysocialweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mysocialweb.Mapper.dao.UsuarioMapperDao;
import com.mysocialweb.dao.UsuariosDao;
import com.mysocialweb.dto.UsuarioDTO;
import com.mysocialweb.model.Usuario;
import com.mysocialweb.service.UsuarioService;
@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuariosDao usuariosDao;
	@Autowired
	private UsuarioMapperDao usuarioMapper; 
	
	@Override
	public List<UsuarioDTO> obtenerUsuarios() {
		List<Usuario> usuarios = this.usuariosDao.obtenerUsuarios();
		List<UsuarioDTO> resultado = this.usuarioMapper.asDTO(usuarios);
		return resultado;
		
	}

}
