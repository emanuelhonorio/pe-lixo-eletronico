package com.emanuelhonorio.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emanuelhonorio.model.Usuario;
import com.emanuelhonorio.services.AccountService;
import com.emanuelhonorio.services.dto.UsuarioDTO;

@RestController
public class AccountResource {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/register")
	private Usuario registrar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
		return accountService.registrar(usuarioDTO);
	}

}
