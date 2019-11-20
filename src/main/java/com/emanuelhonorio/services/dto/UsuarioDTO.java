package com.emanuelhonorio.services.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UsuarioDTO {

	@Size(max = 80)
	@NotEmpty
	private String nome;

	@Email
	@Size(max = 300)
	@NotEmpty
	private String email;

	@Size(max = 16)
	@NotEmpty
	private String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
