package com.emanuelhonorio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuelhonorio.error.exceptions.ResourceNotFoundException;
import com.emanuelhonorio.error.exceptions.ResourceOwnerException;
import com.emanuelhonorio.model.Publicacao;
import com.emanuelhonorio.model.Usuario;
import com.emanuelhonorio.repository.PublicacaoRepository;

@Service
public class PublicacaoService {
	
	@Autowired
	private PublicacaoRepository publicacaoRepository;
	
	public Publicacao publicar(Publicacao publicacao, Usuario usuario) {
		publicacao.setId(null);
		publicacao.setUsuario(usuario);
		publicacao = publicacaoRepository.save(publicacao);
		return publicacao;
	}

	public void deletarPublicacao(Long id, Usuario usuario) {
		Publicacao publicacao = buscarPorId(id);
		Usuario publicador = publicacao.getUsuario();
		
		if (!publicador.equals(usuario)) {
			throw new ResourceOwnerException();
		}
		
		publicacaoRepository.deleteById(id);
	}
	
	public Publicacao buscarPorId(Long id) {
		Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(id);
		if (!publicacaoOpt.isPresent()) {
			throw new ResourceNotFoundException("publication not found with given email");
		}
		return publicacaoOpt.get();
	}
}
