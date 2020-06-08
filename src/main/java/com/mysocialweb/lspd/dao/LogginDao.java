package com.mysocialweb.lspd.dao;

import com.mysocialweb.lspd.entity.Policia;
import com.mysocialweb.lspd.entity.PoliciaCredentials;

public interface LogginDao {

	Policia loggearPolicia(final PoliciaCredentials pc);

}
