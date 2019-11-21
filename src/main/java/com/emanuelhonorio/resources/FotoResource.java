package com.emanuelhonorio.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emanuelhonorio.model.Foto;
import com.emanuelhonorio.repository.FotoRepository;

@RestController
@RequestMapping("/fotos")
public class FotoResource {
	
	@Autowired
	private FotoRepository fotoRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> pegarFoto(@PathVariable Long id) {
		Optional<Foto> fotoOpt = fotoRepository.findById(id);
		
		if (!fotoOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(fotoOpt.get().getArquivo());
	}

}
