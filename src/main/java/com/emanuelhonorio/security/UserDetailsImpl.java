package com.emanuelhonorio.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emanuelhonorio.model.Usuario;
import com.emanuelhonorio.repository.UsuarioRepository;

@Service
public class UserDetailsImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Invalid email");
		}
		return new User(usuario.getEmail(), usuario.getSenha(), getAuthorities(usuario));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Usuario usuario) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

}
