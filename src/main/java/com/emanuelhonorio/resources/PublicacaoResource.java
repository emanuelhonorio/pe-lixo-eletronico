package com.emanuelhonorio.resources;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emanuelhonorio.model.Publicacao;
import com.emanuelhonorio.model.Usuario;
import com.emanuelhonorio.repository.PublicacaoRepository;
import com.emanuelhonorio.services.PublicacaoService;
import com.emanuelhonorio.services.UsuarioService;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoResource {

	@Autowired
	private PublicacaoRepository publicacaoRepository;
	
	@Autowired
	private PublicacaoService publicacaoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<Publicacao> listarPublicacoes() {
		return publicacaoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Publicacao pegarPublicacaoPorId(@PathVariable Long id) {
		return publicacaoService.buscarPorId(id);
	}
	
	@PostMapping
	public Publicacao publicar(@RequestBody @Valid Publicacao publicacao, Principal principal) {
		Usuario usuario = usuarioService.buscarPorEmail(principal.getName());
		return publicacaoService.publicar(publicacao, usuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarPublicacao(@PathVariable Long id, Principal principal) {
		Usuario usuario = usuarioService.buscarPorEmail(principal.getName());
		publicacaoService.deletarPublicacao(id, usuario);
		return ResponseEntity.noContent().build();
	}
}
