package com.mysocialweb.lspd.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mysocialweb.lspd.dto.PoliciaDTO;
import com.mysocialweb.lspd.service.LogginService;

@RestController
@Validated
@RequestMapping(path = "/loggin")
public class LogginController {
	
	@Autowired
	private LogginService logginService;
	
	@RequestMapping(value = "loggearPolicia", method = RequestMethod.POST)
	public PoliciaDTO loggearPolicia(@RequestBody final  String policiaCredential) throws JsonParseException, JsonMappingException, IOException {
		return this.logginService.loggearPolicia(policiaCredential);
	}
}
