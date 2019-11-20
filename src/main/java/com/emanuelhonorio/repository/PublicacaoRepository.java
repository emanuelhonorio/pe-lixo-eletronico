package com.emanuelhonorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emanuelhonorio.model.Publicacao;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {

}
