package com.mysocialweb.Mapper.lspd.dao;

import java.util.List;

import com.mysocialweb.lspd.dto.PoliciaDTO;
import com.mysocialweb.lspd.entity.Policia;

public interface PoliciaRowMapper {

	PoliciaDTO asDTO(final Policia p);

	List<PoliciaDTO> asDTO(final List<Policia> pl);

}
