package com.mysocialweb.Mapper.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mysocialweb.Mapper.dao.UsuarioMapperDao;
import com.mysocialweb.dto.UsuarioDTO;
import com.mysocialweb.model.Usuario;

@Repository
public class UsuarioMapperDaoImpl implements UsuarioMapperDao{	
	public List<UsuarioDTO> asDTO(List<Usuario> usuarios){
		List<UsuarioDTO> dtoList = new ArrayList<>();
		for (Usuario actual : usuarios) {
			UsuarioDTO dto = new UsuarioDTO();
			dto.setNombre(actual.getNombre());
			dto.setApellido(actual.getApellido());
			dto.setApellido2(actual.getApellido2());
			dto.setEmail(actual.getEmail());
			dto.setTelefono(actual.getTelefono());
			dtoList.add(dto);
		}
		return dtoList;
	};
}