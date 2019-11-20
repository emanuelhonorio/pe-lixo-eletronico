package com.emanuelhonorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emanuelhonorio.error.exceptions.ResourceAlreadyExistsException;
import com.emanuelhonorio.model.Usuario;
import com.emanuelhonorio.repository.UsuarioRepository;
import com.emanuelhonorio.services.dto.UsuarioDTO;

@Service
public class AccountService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*
	 * Verifica email e codifica senha antes de salvar
	 */
	public Usuario registrar(UsuarioDTO usuarioDTO) {
		if (usuarioRepository.existsByEmail(usuarioDTO.getEmail())) {
			throw new ResourceAlreadyExistsException("Email ja cadastrado");
		}
		Usuario usuario = new Usuario();
		
		String senhaCript = passwordEncoder.encode(usuarioDTO.getSenha());
		
		usuario.setNome(usuarioDTO.getNome());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setSenha(senhaCript);
		
		usuario = usuarioRepository.save(usuario);	
		return usuario;
	}
}
