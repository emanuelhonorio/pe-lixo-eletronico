package com.emanuelhonorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emanuelhonorio.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public boolean existsByEmail(String email);
	public Usuario findByEmail(String email);
}
