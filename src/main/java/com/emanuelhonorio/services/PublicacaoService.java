package com.emanuelhonorio.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import com.emanuelhonorio.error.exceptions.ResourceNotFoundException;
import com.emanuelhonorio.error.exceptions.ResourceOwnerException;
import com.emanuelhonorio.model.Foto;
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

	public Publicacao uparFotos(MultipartFile[] files, Long idPublicacao) {
		Publicacao publicacao = buscarPorId(idPublicacao);
		
		for (MultipartFile file : files) {
			try {
				Foto foto = new Foto(file.getBytes());
				foto.setPublicacao(publicacao);
				publicacao.getFotos().add(foto);
			} catch (IOException e) {
				throw new MultipartException("error while saving image");
			}
		}
		
		publicacao = publicacaoRepository.save(publicacao);
		return publicacao;
	}
}
