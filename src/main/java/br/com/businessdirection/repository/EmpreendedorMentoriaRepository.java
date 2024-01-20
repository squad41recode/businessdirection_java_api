package br.com.businessdirection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.businessdirection.model.EmpreendedorMentoria;

public interface EmpreendedorMentoriaRepository extends JpaRepository<EmpreendedorMentoria, Long> {

	@EntityGraph(attributePaths = { "mentorModalidade", "empreendedor" })
	List<EmpreendedorMentoria> findAll();

	@Query("SELECT em FROM EmpreendedorMentoria em WHERE em.ativo = true")
	List<EmpreendedorMentoria> findAllAtivos();

	EmpreendedorMentoria findByIdAndAtivo(Long id, boolean ativo);

}
