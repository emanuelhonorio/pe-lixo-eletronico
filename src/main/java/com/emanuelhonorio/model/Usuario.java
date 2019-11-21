package com.emanuelhonorio.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "usuario")
public class Usuario extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String nome;

	private String email;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String senha;

	private Double estrelas;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Foto foto;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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

	public Double getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(Double estrelas) {
		this.estrelas = estrelas;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

}
