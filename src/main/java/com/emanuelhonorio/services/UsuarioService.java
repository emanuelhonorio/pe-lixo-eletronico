package com.emanuelhonorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuelhonorio.error.exceptions.ResourceNotFoundException;
import com.emanuelhonorio.model.Usuario;
import com.emanuelhonorio.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario buscarPorEmail(String email) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if (usuario == null ) {
			throw new ResourceNotFoundException("user not found with given email");
		}
		return usuario;
	}

}
