package br.com.businessdirection.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.businessdirection.models.ConteudoEmpreendedor;

public interface ConteudoEmpreendedorRepository extends JpaRepository<ConteudoEmpreendedor, Long> {

	@Override
	@EntityGraph(attributePaths = { "conteudoOnline", "empreendedor" })
	List<ConteudoEmpreendedor> findAll();

	List<ConteudoEmpreendedor> findAllByEmpreendedor_Id(Long id);

	// listar todos os ativos usando query
	@Query("SELECT ce FROM ConteudoEmpreendedor ce WHERE ce.ativo = :ativo")
	List<ConteudoEmpreendedor> findAllAtivos(@Param("ativo") boolean ativo);

	// listar todos os ativos usando jpa
	// List<ConteudoEmpreendedor> findAllConteudoEmpreendedor_Ativo(boolean ativo);

	ConteudoEmpreendedor findByIdAndAtivo(Long id, boolean ativo);

}
