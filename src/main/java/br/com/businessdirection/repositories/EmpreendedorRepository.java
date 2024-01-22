package br.com.businessdirection.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.businessdirection.models.Empreendedor;

public interface EmpreendedorRepository extends JpaRepository<Empreendedor, Long> {

	@EntityGraph(attributePaths = { "mentoriasAdquiridas" })
	List<Empreendedor> findAllByMentoriasAdquiridasIsNotNull();// , "conteudosEstudados"
	// List<Empreendedor> findAllById(Long id);//

	@EntityGraph(attributePaths = { "conteudosEstudados" })
	List<Empreendedor> findAllByConteudosEstudadosIsNotNull();
	/*
	 * @Query("SELECT e FROM Empreendedor e JOIN FETCH e.conteudosEstudados ce WHERE ce IS NOT NULL"
	 * ) List<Empreendedor> findAllConteudosEstudados();//
	 */
	/*
	 * @EntityGraph(attributePaths = { "mentoriasAdquiridas", "conteudosEstudados"
	 * }) List<Empreendedor> findAll();//
	 */
	// List<ConteudoEmpreendedor> findAllConteudosEstudados();

}
