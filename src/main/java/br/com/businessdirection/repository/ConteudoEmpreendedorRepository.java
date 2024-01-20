package br.com.businessdirection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.businessdirection.model.ConteudoEmpreendedor;

public interface ConteudoEmpreendedorRepository extends JpaRepository<ConteudoEmpreendedor, Long> {

	@EntityGraph(attributePaths = { "conteudoOnline", "empreendedor" })
	List<ConteudoEmpreendedor> findAll();

	@Query("SELECT ce FROM ConteudoEmpreendedor ce WHERE ce.ativo = true")
	List<ConteudoEmpreendedor> findAllAtivos();

	ConteudoEmpreendedor findByIdAndAtivo(Long id, boolean ativo);

}
