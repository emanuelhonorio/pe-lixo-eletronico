package com.emanuelhonorio.resources;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.emanuelhonorio.model.Usuario;
import com.emanuelhonorio.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("/me")
	public ResponseEntity<?> getMe(Principal principal) {
		return ResponseEntity.ok(usuarioService.buscarPorEmail(principal.getName()));
	}
	
	@PutMapping("/{id}/foto")
	public ResponseEntity<?> uparFotos(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
		Usuario usuario = usuarioService.uparFoto(file, id);
		return ResponseEntity.ok(usuario);
	}

}
