package com.mysocialweb.Mapper.dao;

import java.util.List;

import com.mysocialweb.dto.UsuarioDTO;
import com.mysocialweb.model.Usuario;

public interface UsuarioMapperDao {

	public List<UsuarioDTO> asDTO(List<Usuario> usuarios);
}
