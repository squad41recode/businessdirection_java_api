package br.com.businessdirection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.businessdirection.model.MentorModalidade;

public interface MentorModalidadeRepository extends JpaRepository<MentorModalidade, Long> {

	@EntityGraph(attributePaths = { "mentor", "modalidadeMentoria" })
	List<MentorModalidade> findAll();

	@Query("SELECT mm FROM MentorModalidade mm WHERE mm.id NOT IN (SELECT emSub.mentorModalidade.id FROM EmpreendedorMentoria emSub)")
	List<MentorModalidade> listarMentoriasSemLigacaoComEmpreendedor();

	@Query("SELECT mm FROM MentorModalidade mm WHERE mm.ativo = true")
	List<MentorModalidade> findAllAtivos();

	MentorModalidade findByIdAndAtivo(Long id, boolean ativo);
}
