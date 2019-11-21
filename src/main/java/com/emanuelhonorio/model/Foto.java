package com.emanuelhonorio.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "foto")
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@NotNull
	@Lob
	private byte[] arquivo;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "fk_publicacao_id")
	private Publicacao publicacao;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "fk_usuario_id")
	private Usuario usuario;

	public Foto() {
		super();
	}

	public Foto(@NotNull byte[] arquivo) {
		super();
		this.arquivo = arquivo;
	}

	@Transient
	public String getUrl() {
		if (this.id != null) {
			return "http://localhost:8080/fotos/" + this.id;
		}
		return null;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
