package com.mysocialweb.Mapper.lspd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mysocialweb.Mapper.lspd.dao.PoliciaRowMapper;
import com.mysocialweb.lspd.dto.PoliciaDTO;
import com.mysocialweb.lspd.entity.Policia;

@Repository
public class PoliciaRowMapperImpl implements PoliciaRowMapper {

	@Override
	public PoliciaDTO asDTO(final Policia p) {

		PoliciaDTO pdto = new PoliciaDTO(p.getIdPolicia(), p.getNombre(), p.getFechaAlta(), p.getFechaBaja(),
				p.getIdRango(), p.getPlaca());
		return pdto;
	}
	
	@Override
	public List<PoliciaDTO> asDTO(final List<Policia> pl) {
		List<PoliciaDTO> pdtol = new ArrayList<>();
		for (Policia p : pl) {
			PoliciaDTO pdto = new PoliciaDTO(p.getIdPolicia(), p.getNombre(), p.getFechaAlta(), p.getFechaBaja(),
					p.getIdRango(), p.getPlaca());
			pdtol.add(pdto);
		}
		return pdtol;
	}

}
