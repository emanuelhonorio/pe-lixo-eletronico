package com.emanuelhonorio.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import com.emanuelhonorio.error.exceptions.ResourceNotFoundException;
import com.emanuelhonorio.model.Foto;
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
	
	
	public Usuario uparFoto(MultipartFile file, Long idUsuario) {
		Usuario usuario = buscarPorId(idUsuario);
		try {
			Foto foto = new Foto(file.getBytes());
			foto.setUsuario(usuario);
			usuario.setFoto(foto);
		} catch (IOException e) {
			throw new MultipartException("error while saving image");
		}
		usuario = usuarioRepository.save(usuario);
		return usuario;
	}


	public Usuario buscarPorId(Long idUsuario) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
		if (!usuarioOpt.isPresent()) {
			throw new ResourceNotFoundException("user not found with given id");
		}
		return usuarioOpt.get();
	}

}
